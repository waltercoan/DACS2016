package ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import model.ItemPedido;
import model.Pedido;

/**
 * Message-Driven Bean implementation class for: OrderProcessMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "orderqueue"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "orderqueue")
public class OrderProcessMDB implements MessageListener {

    /**
     * Default constructor. 
     */
    public OrderProcessMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        try {
			Pedido p =message.getBody(Pedido.class);
			System.out.println(p.getMeuCliente().getNome());
			System.out.println(p.getMeuCliente().getEndereco());
			for(ItemPedido pi:p.getColItens()){
				System.out.println(pi.getMeuProduto().getDescricao());
				System.out.println(pi.getQuantidade());
				System.out.println(pi.getMeuProduto().getPreco());
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
        
        
    }

}
