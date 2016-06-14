import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Produto;
import ejb.ProdutoBeanLocal;

@Path("/produto")
@javax.enterprise.context.RequestScoped
/***
 * 
 * @author Walter
 *	DOC: http://docs.oracle.com/javaee/6/tutorial/doc/giepu.html
 */
public class ProdutoRest {
	@Inject
	private ProdutoBeanLocal produtoBean;
	
	@GET
	@Path("/olamundo")
	public String olamundo(){
		return "ola mundo legal do java...";
	}
	@GET
	@Path("/getallproducts")
	@Produces("application/json; charset=UTF-8")
	public List<Produto> getAllProdutos(){
		return produtoBean.getAllProducts();
	}
	
	@GET
	@Path("/getallproductsbydesc/{desc}")
	@Produces("application/json; charset=UTF-8")
	public List<Produto> getAllProdutosByDesc(@PathParam("desc") String descricao){
		return produtoBean.getProductsByDesc(descricao);
	}
	
	@GET
	@Path("/getallproductsxml")
	@Produces("application/xml")
	public List<Produto> getAllProdutosXml(){
		return produtoBean.getAllProducts();
	}
	
}



