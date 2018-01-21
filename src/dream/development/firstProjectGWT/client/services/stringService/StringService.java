package dream.development.firstProjectGWT.client.services.stringService;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service
 */
@RemoteServiceRelativePath("checkString")
public interface StringService extends RemoteService {

    String checkString(String text);

}
