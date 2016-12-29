package app.restaurant.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="nota_de_plata")
public class NotaDePlata implements Serializable{
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nr_masa")
	private int nrMasa;
	
	@Column(name = "gramaj_total")
	private int gramajTotal;
	
	@Column(name = "pret_total")
	private int pretTotal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNrMasa() {
		return nrMasa;
	}

	public void setNrMasa(int nrMasa) {
		this.nrMasa = nrMasa;
	}

	public int getGramajTotal() {
		return gramajTotal;
	}

	public void setGramajTotal(int gramajTotal) {
		this.gramajTotal = gramajTotal;
	}

	public int getPretTotal() {
		return pretTotal;
	}

	public void setPretTotal(int pretTotal) {
		this.pretTotal = pretTotal;
	}
	
	
	
}
