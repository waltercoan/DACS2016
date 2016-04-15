package control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Produto;

import org.primefaces.context.RequestContext;

import dao.DAOFactory;

@ManagedBean(name="ctrProduto")
@ViewScoped
public class CtrProduto {
	private List<Produto> colProdutos = new ArrayList<Produto>();
	
	@PostConstruct
	public void init(){
		/*
		//DAOFactory.getInstance();
		Produto p = new Produto();
		p.setDescricao("Pão");
		p.setUnidade("unidade");
		p.setValor(0.20f);
		
		DAOFactory.getInstance().getProdutoDAO().insert(p);
	
		p = new Produto();
		p.setDescricao("Pão");
		p.setUnidade("unidade");
		p.setValor(0.20f);
		
		DAOFactory.getInstance().getProdutoDAO().insert(p);
		*/
		colProdutos = 
				DAOFactory.getInstance().getProdutoDAO().getAll();

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
