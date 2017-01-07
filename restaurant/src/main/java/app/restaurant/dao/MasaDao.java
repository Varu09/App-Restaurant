package app.restaurant.dao;


import java.util.List;

import app.restaurant.model.Masa;

public interface MasaDao {
	public List<Masa> getTables();
	public void addTable(Masa masa);
	public void updateTable(Masa masa);
	public void removeTable(Masa masa);
	public List<Object[]> complexQuery(Masa masa);
	
}
