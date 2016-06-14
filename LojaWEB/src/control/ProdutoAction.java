package control;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Produto;
import ejb.ProdutoBeanRemote;

@ManagedBean(name="produtoAction")
@ViewScoped
public class ProdutoAction {
	@EJB
	private ProdutoBeanRemote produtoBean;
	private Produto model;

	public void createNewProduct(){
		model = new Produto();
	}
	public void saveProduct(){
		produtoBean.save(model);
	}
	
	public void removeProduct(){
		produtoBean.remove(model);
	}
	
	
		
	public Produto getModel() {
		return model;
	}

	public void setModel(Produto model) {
		this.model = model;
	}
	
	public List<Produto> getProductsList(){
		return produtoBean.getAllProducts();
	}




	
}
