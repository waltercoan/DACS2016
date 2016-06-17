package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Produto;

/**
 * Session Bean implementation class ProdutoBean
 */
@Stateless
public class ProdutoBean implements ProdutoBeanRemote,ProdutoBeanLocal{

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
	@Override
	public void remove(Produto produto) {
		produto = em.find(Produto.class, produto.getOid());
		if(produto != null){
			em.remove(produto);
		}
	}
	@Override
	public void remove(int oid) {
		Produto produto = em.find(Produto.class, oid);
		if(produto != null){
			em.remove(produto);
		}
	}
	@Override
	public List<Produto> getAllProducts() {
		Query q = em.createNamedQuery("getAllProducts");
		return q.getResultList();
	}
	@Override
	public List<Produto> getProductsByDesc(String desc) {
		Query q = em.createNamedQuery("getProductsByDesc");
		q.setParameter("desc", desc);
		q.setMaxResults(10);
		return q.getResultList();
	}
}






