package dream.development.firstProjectGWT.client.services.callObjectsService;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import dream.development.firstProjectGWT.client.objects.CallInput;
import dream.development.firstProjectGWT.client.objects.CallResult;

/**
 * The client-side stub for the RPC service, objects calling
 */
@RemoteServiceRelativePath("callObjectsCheckString")
public interface CallObjectsService extends RemoteService {

    CallResult checkString(CallInput input) throws Exception;

}
