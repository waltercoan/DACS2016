package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
	@NamedQuery(name="getAllProducts" , 
				query="select p from Produto p"),
	@NamedQuery(name="getProductsByDesc",
				query="select p from Produto p "
						+ "where p.descricao like :desc")
})

@XmlRootElement(name="produto")
@Entity
public class Produto implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;
	@Column(length=1000)
	private String descricao;
	private float preco;


	public String toString(){
		return descricao + preco;
	}
	
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
}
