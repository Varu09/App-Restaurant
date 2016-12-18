package app.restaurant.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="istoric_comenzi")
public class IstoricComenzi implements Serializable {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "comanda_id")
	private int comandaId;
	
	@Column(name = "produs_id")
	private int produsId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getComandaId() {
		return comandaId;
	}

	public void setComandaId(int comandaId) {
		this.comandaId = comandaId;
	}

	public int getProdusId() {
		return produsId;
	}

	public void setProdusId(int produsId) {
		this.produsId = produsId;
	}
	
	
	

}
