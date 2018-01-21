package dream.development.firstProjectGWT.client.uploadedFile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

/**
 * FileUpload example
 */
public class UploadedFile {

    private static final String UPLOAD_ACTION_URL = GWT.getModuleBaseURL() + "upload";

    /**
     * The message displayed to the user when the server cannot be reached or return errors
     */
    private static final String SERVER_ERROR = "An error occurred while attempting to contact the server. Please check your network connection.";

    /**
     * FileUpload main method
     */
    public FormPanel upload() {
        final FormPanel uploadedForm = new FormPanel();

        //Create FormPanel and point it at the service
        uploadedForm.setAction(UPLOAD_ACTION_URL);

        // Because we are going to use FileUpload widget, we will need to set the
        // uploadedForm to use the POST method, and multipart MIME encoding.
        uploadedForm.setEncoding(FormPanel.ENCODING_MULTIPART);
        uploadedForm.setMethod(FormPanel.METHOD_POST);

        // Create a panel to hold all of the uploadedForm widgets.
        VerticalPanel panel = new VerticalPanel();
        uploadedForm.setWidget(panel);

        // Create a FileUpload widget.
        FileUpload fileUpload = new FileUpload();
        fileUpload.setName("uploadFormElement");
        panel.add(fileUpload);

        // Add a submit button
        panel.add(new Button("Submit", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                uploadedForm.submit();
            }
        }));

        // Add an event handler to the uploadedForm.
        uploadedForm.addSubmitHandler(new FormPanel.SubmitHandler() {
            @Override
            public void onSubmit(FormPanel.SubmitEvent event) {
                // This event is fired just before the uploadedForm is submitted. We can
                // take this opportunity to perform validation.

            }
        });

        uploadedForm.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                // When the uploadedForm submission is successfully completed, this event is fired.
                // Assuming the service returned a response of type text/html, we can get
                // the result text here (see te FormPanel documentation for the further explanation)
                Window.alert(event.getResults());
            }
        });

        return uploadedForm;
    }

}
