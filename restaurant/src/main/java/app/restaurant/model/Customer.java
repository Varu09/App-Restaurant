package app.restaurant.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Column(name = "nume")
	private String nume;
	
	@NotNull
	@Column(name = "prenume")
	private String prenume;
	
	@Column(name = "nr_masa")
	private int nrMasa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public int getNrMasa() {
		return nrMasa;
	}

	public void setNrMasa(int nrMasa) {
		this.nrMasa = nrMasa;
	}
	
	
}
