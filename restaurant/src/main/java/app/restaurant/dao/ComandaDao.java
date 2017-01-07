package app.restaurant.dao;

import java.util.List;

import app.restaurant.model.Comanda;
import app.restaurant.model.IstoricComenzi;

public interface ComandaDao {
	public List<Comanda> getComanda();
	public void addComanda(Comanda comanda);
	public void updateComanda(Comanda comanda);
	public void removeComanda(Comanda comanda);
	public List<Object[]> simpleQuery(Comanda comanda, IstoricComenzi istoric);
}
