package dream.development.firstProjectGWT.client.services.stringService;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface StringServiceAsync {

    void checkString(String text, AsyncCallback<String> async);

}
