package dream.development.firstProjectGWT.server.serviceImplementations.uploadedFileService;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadedFileService extends HttpServlet {

    private static final String UPLOAD_DIRECTORY = "C:\\uploaded\\";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO Auto-generated method stub
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Process only multipart requests
        if (ServletFileUpload.isMultipartContent(req)) {

            File tempDir = getTempDir();
            if (!tempDir.exists()) {
                tempDir.mkdirs();
            }
            // Create a factory for disk-based file items.
            FileItemFactory factory = new DiskFileItemFactory();

            // Create a new file upload handler.
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Parse the request.
            try {
                List<FileItem> items = upload.parseRequest(req);

                for (FileItem fileItem : items) {
                    // process only file upload
                    if (fileItem.isFormField())
                        continue;

                    String fileName = fileItem.getName();

                    if (fileName != null) {
                        //get only the file name not a whole path
                        fileName = FilenameUtils.getName(fileName);

                        File uploadedFile = new File(UPLOAD_DIRECTORY, fileName);
                        if (uploadedFile.createNewFile()) {
                            fileItem.write(uploadedFile);
                            resp.setStatus(HttpServletResponse.SC_CREATED);
                            resp.getWriter().print("The file was created successfully");
                            resp.flushBuffer();
                        } else {
                            throw new IOException("The file is already exists in repository");
                        }

                    } else {
                        throw new IOException("The file name should not be null");
                    }

                }

            } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while creating this file : " + e.getMessage());
            }

        } else {
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Request contents type is not supported by the servlet.");
        }

    }

    private File getTempDir() {
        return new File(UPLOAD_DIRECTORY);
    }

}
