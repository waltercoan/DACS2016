package control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Produto;

import org.primefaces.context.RequestContext;

@ManagedBean(name="ctrProduto")
@ViewScoped
public class CtrProduto {
	private List<Produto> colProdutos = new ArrayList<Produto>();
	
	@PostConstruct
	public void init(){
		Produto p = new Produto();
		p.setDescricao("Pão");
		p.setUnidade("unidade");
		p.setValor(0.20f);
		
		colProdutos.add(p);
	
		p = new Produto();
		p.setDescricao("Pão");
		p.setUnidade("unidade");
		p.setValor(0.20f);
		
		colProdutos.add(p);
		
		
		RequestContext reqcontext = RequestContext.getCurrentInstance();
		reqcontext.update("listaProdutos");
		
		
	}
	
	
	public List<Produto> getColProdutos() {
		return colProdutos;
	}

	public void setColProdutos(List<Produto> colProdutos) {
		this.colProdutos = colProdutos;
	}
	
	
}
