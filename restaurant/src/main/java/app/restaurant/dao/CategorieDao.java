package app.restaurant.dao;

import java.util.List;
import app.restaurant.model.Categorie;
import app.restaurant.model.Produs;

public interface CategorieDao {
	public List<Categorie> getCategorie();
	public void addCategorie(Categorie categorie);
	public void updateCategorie(Categorie categorie);
	public void removeCategorie(Categorie categorie);
	public List<Object[]> simpleQuery(Categorie categorie, Produs produs);
	public List<Object[]> complexQuery(Produs produs);
}
