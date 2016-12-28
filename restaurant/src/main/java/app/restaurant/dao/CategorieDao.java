package app.restaurant.dao;

import java.util.List;
import app.restaurant.model.Categorie;

public interface CategorieDao {
	public List<Categorie> getCategorie();
	public void addCategorie(Categorie categorie);
	public void updateCategorie(Categorie categorie);
	public void removeCategorie(Categorie categorie);
}
