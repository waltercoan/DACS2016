import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import ejb.ProdutoBeanRemote;
import javax.naming.Context;

public class ServerConnection {
	//Singleton
	private static ServerConnection instance;
	private InitialContext ic;
	private ProdutoBeanRemote produtoBean;

	private ServerConnection() {
		try {
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
			props.setProperty("org.omg.CORBA.ORBInitialHost", "192.168.115.148");
			props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
			ic = new InitialContext(props);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public static ServerConnection getInstance(){
		if(instance == null)
			instance = new ServerConnection();
		return instance;
	}
	public ProdutoBeanRemote getProdutoBean(){

		if(produtoBean == null){
			try {
				produtoBean = (ProdutoBeanRemote)
						ic.lookup("java:global/LojaServer/LojaEJB/ProdutoBean!ejb.ProdutoBeanRemote");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return produtoBean;
	}

	/*public ProdutoBeanRemote getProdutoBeanRemote(){
		if(produtoBean == null){
			try {
				produtoBean = (ProdutoBeanRemote) 
						ic.lookup("java:global/DSI2015Server/DSI2015EJB/ProdutoBean!ejb.ProdutoBeanRemote");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return produtoBean;
	}*/



}

