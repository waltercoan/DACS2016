package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton
 * @author Walter
 *
 */
public class DAOFactory {
	
	private static DAOFactory instance;
	private Connection conn;
	private ProdutoDAO produtoDAO;
	
	private DAOFactory() {
		//codificar aqui no construtor..
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn 	= DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurante2016?user=root&password=root");
			produtoDAO = new ProdutoDAO(conn);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ProdutoDAO getProdutoDAO(){
		return produtoDAO;
	}
	
	
	public static DAOFactory getInstance(){
		if(instance == null)
			instance = new DAOFactory();
		
		return instance;
	}
}
