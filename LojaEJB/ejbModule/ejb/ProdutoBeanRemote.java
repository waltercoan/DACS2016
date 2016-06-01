package ejb;

import javax.ejb.Remote;

import model.Produto;

@Remote
public interface ProdutoBeanRemote {
	public void save(Produto produto);
	public void logData();
	public Produto getProduto();
}
