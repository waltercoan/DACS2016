package ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Message-Driven Bean implementation class for: ReceptorMDB
 */
@MessageDriven(
		activationConfig = { 
			@ActivationConfigProperty(
				propertyName = "destination", 
				propertyValue = "topiczueira"), 
			@ActivationConfigProperty(
				propertyName = "destinationType", 
				propertyValue = "javax.jms.Topic")
		}, 
		mappedName = "topiczueira")
public class ReceptorMDB implements MessageListener {

    public ReceptorMDB() {
    
    }
	
    public void onMessage(Message message) {
        try {
			System.out.println("SERVIDOR: " + 
						message.getBody(String.class));
		} catch (JMSException e) {
			e.printStackTrace();
		}
    }

}




