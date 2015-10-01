/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.util.List;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;
import org.yawlfoundation.yawl.engine.interfce.interfaceB.InterfaceBWebsideController;
/**
 *
 * @author swyna
 */
@WebService()
@HandlerChain(file = "YAWLCustomWS_handler.xml")
public class YAWLCustomWS extends InterfaceBWebsideController {

    String sessionHandle;
    String username = "admin";
    String password = "YAWL";

    @WebMethod(operationName = "enabled")
    @Override
    public void handleEnabledWorkItemEvent(@WebParam(name = "record") WorkItemRecord enabledWorkItem) {
        try {

            sessionHandle = connect(username, password);

            if (checkConnection(sessionHandle)) {

                System.err.print("Password correct");

                List executingChildren = getChildren(enabledWorkItem.getID(), sessionHandle);

                /*
                for (int i = 0; i < executingChildren.size(); i++) {

                    WorkItemRecord itemRecord = (WorkItemRecord) executingChildren.get(i);
                    Element data = itemRecord.getDataList();
                    data = (Element) data.getChildren().get(0);
                    String dataText = data.getText();

                }
                 * */

            } else {

                System.err.print("Password incorrect");

            }

            return;

        } catch (IOException ex) {

            System.err.print("IO exception");

        }
    }

    @WebMethod(operationName = "cancelled")
    @Override
    public void handleCancelledWorkItemEvent(@WebParam(name = "record") WorkItemRecord arg0) {
        return;
    }
}
