package dream.development.firstProjectGWT.server.serviceImplementations.firstProjectGWTService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import dream.development.firstProjectGWT.client.services.firstProjectGWTService.FirstProjectGWTService;

public class FirstProjectGWTServiceImpl extends RemoteServiceServlet implements FirstProjectGWTService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}