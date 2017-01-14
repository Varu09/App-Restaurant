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

import app.restaurant.util.Constants;

@Entity
@Table(name = "masa")
public class Masa implements Serializable{
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nr_locuri")
	private int nrLocuri;	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNrLocuri() {
		return nrLocuri;
	}


	public void setNrLocuri(int nrLocuri) {
		this.nrLocuri = nrLocuri;
	}
	
	@Transient
	public String display() {
		return id + Constants.TAB + nrLocuri + "\n";
	}


	
}
