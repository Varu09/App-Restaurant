package app.restaurant.dao;

import java.util.List;

import app.restaurant.model.Categorie;
import app.restaurant.model.Produs;

public interface ProdusDao {
	public List<Produs> getProduse();
	public void addProdus(Produs produs);
	public void updateProdus(Produs produs);
	public void removeProdus(Produs produs);
	public List<Object[]> complexQuery(Categorie categorie);
}
