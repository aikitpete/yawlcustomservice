/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author swyna
 */
public class MessageHandler implements SOAPHandler<SOAPMessageContext> {

    public boolean handleMessage(SOAPMessageContext messageContext) {
        log(messageContext);
        return true;
    }

    private void log(SOAPMessageContext messageContext) {
        Boolean outcoming = (Boolean)
                messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outcoming.booleanValue()) {
            System.out.println("\nOutcoming message :");
        } else {
            System.out.println("\nIncoming message :");
        }
        SOAPMessage message = messageContext.getMessage();
        try {
            message.writeTo(System.out);
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Exception in handler: " + e);
        }
    }

    public Set<QName> getHeaders() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean handleFault(SOAPMessageContext arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void close(MessageContext arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
