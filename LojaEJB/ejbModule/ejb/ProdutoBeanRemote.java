package ejb;

import java.util.List;

import javax.ejb.Remote;

import model.Produto;

@Remote
public interface ProdutoBeanRemote {
	public void save(Produto produto);
	public void remove(Produto produto);
	public List<Produto> getAllProducts();
	public List<Produto> getProductsByDesc(String desc);
	public void remove(int oid);
}
