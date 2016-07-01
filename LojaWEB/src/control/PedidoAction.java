package control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.ItemPedido;
import model.Pedido;
import model.Produto;
import ejb.ProdutoBeanRemote;

@ManagedBean(name="pedidoAction")
@ViewScoped
public class PedidoAction {
	@EJB
	private ProdutoBeanRemote produtoBean;
	private ItemPedido itemSelect;
	//private List<Produto> basketList;
	private int tabnum;
	private Pedido pedido;
	private Produto productSelect;
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@PostConstruct
	public void startBasket(){
		pedido = new Pedido();
	}
	
	public void confirmOrder(){
		tabnum = 1;
	}
	
	public void removeItem(){
		//basketList.remove(productSelect);
		pedido.getColItens().remove(itemSelect);
		
	}
	public void addBasket(){
		if(productSelect != null){
			ItemPedido novoItem = new ItemPedido();
			novoItem.setMeuProduto(productSelect);
			pedido.getColItens().add(novoItem);
			
			FacesContext.getCurrentInstance().
			addMessage(null, new FacesMessage(
			FacesMessage.SEVERITY_INFO, "Info", 
			String.format("Produto %s incluso no carrinho "
				+ "de compras", 
				itemSelect.getMeuProduto().getDescricao())));
		}
	}
	
	public List<Produto> getProductsList(){
		return produtoBean.getAllProducts();
	}

	public ItemPedido getItemSelect() {
		return itemSelect;
	}

	public void setItemSelect(ItemPedido itemSelect) {
		this.itemSelect = itemSelect;
	}

	public int getTabnum() {
		return tabnum;
	}


	public void setTabnum(int tabnum) {
		this.tabnum = tabnum;
	}

	public Produto getProductSelect() {
		return productSelect;
	}

	public void setProductSelect(Produto productSelect) {
		this.productSelect = productSelect;
	}
}
