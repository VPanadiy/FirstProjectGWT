package dream.development.firstProjectGWT.client.services.callObjectsService;

import com.google.gwt.user.client.rpc.AsyncCallback;
import dream.development.firstProjectGWT.client.objects.CallInput;
import dream.development.firstProjectGWT.client.objects.CallResult;

public interface CallObjectsServiceAsync {

    void checkString(CallInput input, AsyncCallback<CallResult> async);

}
