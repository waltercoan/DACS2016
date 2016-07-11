package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Pedido implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private Cliente meuCliente = new Cliente();
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date data;
	private float valorTotal;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pedido_oid")
	private List<ItemPedido> colItens 
				= new ArrayList<ItemPedido>();
	

	
	public List<ItemPedido> getColItens() {
		return colItens;
	}
	public void setColItens(List<ItemPedido> colItens) {
		this.colItens = colItens;
	}
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public Cliente getMeuCliente() {
		return meuCliente;
	}
	public void setMeuCliente(Cliente meuCliente) {
		this.meuCliente = meuCliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	
	
}
