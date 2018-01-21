package dream.development.firstProjectGWT.client.services.firstProjectGWTService;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FirstProjectGWTServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
