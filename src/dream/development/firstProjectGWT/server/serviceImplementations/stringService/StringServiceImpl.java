package dream.development.firstProjectGWT.server.serviceImplementations.stringService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import dream.development.firstProjectGWT.client.services.stringService.StringService;

/**
 * The server-side stub implementation for the RPC service
 */

@SuppressWarnings("serial")
public class StringServiceImpl extends RemoteServiceServlet implements StringService {

    @Override
    public String checkString(String text) {
        System.out.println("Input = " + text);
        return "Hello text: " + text;
    }

}
