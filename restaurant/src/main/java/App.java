
import java.util.List;

import app.restaurant.dao.MasaDao;
import app.restaurant.dao.impl.MasaDaoImpl;
import app.restaurant.model.Masa;

public class App {
	
	
	public static void main(String[] args) {
		MasaDao masaDao = new MasaDaoImpl();
		Masa masa = new Masa();
		masa.setNrLocuri(10);
		Masa newTable = masaDao.addTable(masa);
		
		newTable.setNrLocuri(7);
		masaDao.updateTable(newTable);
		List<Masa> mese = masaDao.getTables();

		mese.stream().map(m -> m.getNrLocuri()).forEach(System.out::println);
		
		
	}
}
