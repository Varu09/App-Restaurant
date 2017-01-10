package app.restaurant.model;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import app.restaurant.util.ClientUtil;

@Entity
@Table(name = "produs")
public class Produs implements Serializable {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "categorie_id")
	private int categorieId;
	
	@NotNull
	@Column(name = "nume")
	private String nume;
	
	@Column(name = "pret")
	private int pret;
	
	@Column(name = "gramaj")
	private int gramaj;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(int categorieId) {
		this.categorieId = categorieId;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getPret() {
		return pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}

	public int getGramaj() {
		return gramaj;
	}

	public void setGramaj(int gramaj) {
		this.gramaj = gramaj;
	}
	
	//@Transient
	public String display() {
		return categorieId + ClientUtil.TAB + nume + ClientUtil.TAB + pret + " lei " + ClientUtil.TAB + gramaj + " g " + "\n";
	}
	
	
}
