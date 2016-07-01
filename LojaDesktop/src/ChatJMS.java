import java.util.Properties;
import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ChatJMS implements MessageListener{

	private InitialContext ic;
	
	public ChatJMS() {
		try {
			System.out.println("Configurando...");
			Properties props = new Properties();

	        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
	        props.put(Context.PROVIDER_URL, "iiop://localhost:7676");
	        //props.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
	        //props.put("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
			props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
	        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
	         
			
			System.out.println("Conectando...");
			ic = new InitialContext(props);
			System.out.println("Conectado...");
			
			
			
			JMSContext jmsContext = ((ConnectionFactory)ic.lookup("java:comp/DefaultJMSConnectionFactory")).createContext();
			System.out.println("JMS Factory encontrado...");
			Topic topico = (Topic)ic.lookup("topiczueira");
			System.out.println("Tópico encontrado...");
			//Queue fila = (Queue) ic.lookup("jms/myQueue");
			
			
			Scanner leitor = new Scanner(System.in);
			JMSProducer jmsProducer = jmsContext.createProducer();
			
			jmsContext.createConsumer(topico).setMessageListener(this);
			
			
			while(true){
				System.out.println("Digite sua mensagem");
				String msg = leitor.nextLine();
				jmsProducer.send(topico, msg);
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatJMS();
	}
	//MEU IP 192.168.115.120
	public void onMessage(Message arg0) {
		try {
			System.out.println(arg0.getBody(String.class));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
