package ejb;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Produto;

/**
 * Session Bean implementation class ProdutoBean
 */
@Stateless
public class ProdutoBean implements ProdutoBeanRemote{

	@PersistenceContext(name="dacs2016context")
	private EntityManager em;
	
	
    //private Produto produto;
    
    public ProdutoBean() {
        System.out.println("Fui criado...");
    }
    public void save(Produto produto){
    	if(em.find(Produto.class, produto.getOid()) == null){
    		em.persist(produto);
    	}else{
    		em.merge(produto);
    	}
    	System.out.println(produto);
    }
    
    public void logData(){
    	System.out.println(produto);
    }
	@Override
	public Produto getProduto() {
		return produto;
	}

}






