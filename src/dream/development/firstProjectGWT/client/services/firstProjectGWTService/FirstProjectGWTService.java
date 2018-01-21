package dream.development.firstProjectGWT.client.services.firstProjectGWTService;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("FirstProjectGWTService")
public interface FirstProjectGWTService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use FirstProjectGWTService.App.getInstance() to access static instance of FirstProjectGWTServiceAsync
     */
    public static class App {
        private static FirstProjectGWTServiceAsync ourInstance = GWT.create(FirstProjectGWTService.class);

        public static synchronized FirstProjectGWTServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
