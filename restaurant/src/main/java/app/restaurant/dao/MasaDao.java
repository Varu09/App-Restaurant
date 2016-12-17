package app.restaurant.dao;


import java.util.List;

import app.restaurant.model.Masa;

public interface MasaDao {
	public List<Masa> getTables();
	public Masa addTable(Masa masa);
	public void updateTable(Masa masa);
	
}
