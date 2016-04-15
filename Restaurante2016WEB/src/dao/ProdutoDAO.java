package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO {
	private Connection conn;
	
	public ProdutoDAO(Connection conn) {
		this.conn = conn;
	}

	public void insert(Produto produto){
		try {
			String sql = "insert into produto(descricao,valor,unidade) "
					+ "values(?,?,?)";
			
			PreparedStatement sqlp = conn.prepareStatement(sql);
			sqlp.setString(1, produto.getDescricao());
			sqlp.setFloat(2, produto.getValor());
			sqlp.setString(3, produto.getUnidade());
			
			sqlp.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Produto> getAll(){
		List<Produto> colProdutos = new ArrayList<Produto>();
		
		try {
			String sql = "select * from produto";
			PreparedStatement sqlp = conn.prepareStatement(sql);
			
			ResultSet resul= sqlp.executeQuery();
			while(resul.next()){
				Produto umProduto = new Produto();
				umProduto.setOid(resul.getLong("oid"));
				umProduto.setDescricao(resul.getString("descricao"));
				umProduto.setUnidade(resul.getString("unidade"));
				umProduto.setValor(resul.getFloat("valor"));
				colProdutos.add(umProduto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return colProdutos;
	}
}
