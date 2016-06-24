package control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.Produto;
import ejb.ProdutoBeanRemote;

@ManagedBean(name="pedidoAction")
@ViewScoped
public class PedidoAction {
	@EJB
	private ProdutoBeanRemote produtoBean;
	private Produto productSelect;
	private List<Produto> basketList;
	private int tabnum;
	
	public List<Produto> getBasketList() {
		return basketList;
	}


	public void setBasketList(List<Produto> basketList) {
		this.basketList = basketList;
	}


	@PostConstruct
	public void startBasket(){
		basketList = new ArrayList<Produto>();
	}
	
	public void confirmOrder(){
		tabnum = 1;
	}
	
	public void removeItem(){
		basketList.remove(productSelect);
	}
	public void addBasket(){
		if(productSelect != null){
			basketList.add(productSelect);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", String.format("Produto %s incluso no carrinho de compras", productSelect.getDescricao())));
		}
	}
	
	public List<Produto> getProductsList(){
		return produtoBean.getAllProducts();
	}

	public Produto getProductSelect() {
		return productSelect;
	}

	public void setProductSelect(Produto productSelect) {
		this.productSelect = productSelect;
	}


	public int getTabnum() {
		return tabnum;
	}


	public void setTabnum(int tabnum) {
		this.tabnum = tabnum;
	}
}
