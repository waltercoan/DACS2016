import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Produto;
import ejb.ProdutoBeanRemote;

public class Desktop extends JFrame implements ActionListener{
	
	private ProdutoBeanRemote produtoBean;
	
	public Desktop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,200);
		setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("Conectar");
		btn1.setName("btn1");
		btn1.addActionListener(this);
		JButton btn2 = new JButton("Salvar");
		btn2.setName("btn2");
		btn2.addActionListener(this);
		JButton btn3 = new JButton("Log");
		btn3.setName("btn3");
		btn3.addActionListener(this);
		
		add(btn1);
		add(btn2);
		add(btn3);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		JComponent comp = (JComponent)e.getSource();
		if(comp.getName().equals("btn1")){
			//System.out.println("Conectar...");
			
			produtoBean = 
				ServerConnection.getInstance().getProdutoBean();
			
			
		}else{
			if(comp.getName().equals("btn2")){
				//System.out.println("Salvar");
				
				Produto produto = new Produto();
				produto.setOid(9999);
				produto.setDescricao("SAL");
				produto.setPreco(2);
				
				produtoBean.save(produto);
				
				
			}else{
				if(comp.getName().equals("btn3")){
					System.out.println("LOG");
					
					Produto umProduto = produtoBean.getProduto();
					JOptionPane.showMessageDialog(this, umProduto);
					
					
				}
			}
		}
	}
	public static void main(String[] args) {
		new Desktop();
	}

	

}
