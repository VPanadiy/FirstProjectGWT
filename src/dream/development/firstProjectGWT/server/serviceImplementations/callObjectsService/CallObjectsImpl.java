package dream.development.firstProjectGWT.server.serviceImplementations.callObjectsService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import dream.development.firstProjectGWT.client.objects.CallInput;
import dream.development.firstProjectGWT.client.objects.CallResult;
import dream.development.firstProjectGWT.client.services.callObjectsService.CallObjectsService;

/**
 * The server-side stub implementation for the RPC service, objects calling
 */
@SuppressWarnings("serial")
public class CallObjectsImpl extends RemoteServiceServlet implements CallObjectsService {

    @Override
    public CallResult checkString(CallInput input) throws Exception {
        CallResult callResult = new CallResult();
        callResult.setText("Hello text: " + input.getText());
        callResult.setCode(1);

        if (input.getText().length() >= 10) {
            throw new Exception("[ERROR] Text is too big!");
        }

        return callResult;
    }

}
