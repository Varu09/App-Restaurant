package app.restaurant.dao;

import java.util.List;

import app.restaurant.model.Comanda;

public interface ComandaDao {
	public List<Comanda> getComanda();
	public void addComanda(Comanda comanda);
	public void updateComanda(Comanda comanda);
	public void removeComanda(Comanda comanda);
}
