package app.restaurant.dao;

import java.util.List;
import app.restaurant.model.Produs;

public interface ProdusDao {
	public List<Produs> getProduse();
	public void addProdus(Produs produs);
	public void updateProdus(Produs produs);
	public void removeProdus(Produs produs);	
}
