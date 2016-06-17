package ejb;

import java.util.List;
import javax.ejb.Local;
import model.Produto;

@Local
public interface ProdutoBeanLocal {
	public void save(Produto produto);
	public void remove(Produto produto);
	public List<Produto> getAllProducts();
	public List<Produto> getProductsByDesc(String desc);
	public void remove(int oid);
}
