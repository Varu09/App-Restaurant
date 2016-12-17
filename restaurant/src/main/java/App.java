
import java.util.List;

import app.restaurant.client.MenuController;
import app.restaurant.dao.CustomerDao;
import app.restaurant.dao.MasaDao;
import app.restaurant.dao.impl.CustomerDaoImpl;
import app.restaurant.dao.impl.MasaDaoImpl;
import app.restaurant.model.Customer;
import app.restaurant.model.Masa;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
	
	
	public static void main(String[] args) {
		
		//test();
		launch(args);
	}
	
	public static void test() {
		
		// Masa
				MasaDao masaDao = new MasaDaoImpl();
				Masa masa = new Masa();
				masa.setNrLocuri(10);
				Masa newTable = masaDao.addTable(masa);
				
				newTable.setNrLocuri(7);
				masaDao.updateTable(newTable);
				List<Masa> mese = masaDao.getTables();

				mese.stream().map(m -> m.getNrLocuri()).forEach(System.out::println);
				
		// Clienti
				
				CustomerDao clientDao = new CustomerDaoImpl();
				Customer client = new Customer();
				client.setNume("George");
				client.setPrenume("Valentin");
				client.setNrMasa(3);
				Customer newClient = clientDao.addCustomer(client);
				newClient.setNume("Hamilton");
				newClient.setPrenume("John");
				newClient.setNrMasa(1);
				//clientDao.updateCustomer(newClient);
				List<Customer> clienti = clientDao.getCustomersByName("Hamilton", "John");
				
				clienti.stream().map(c -> c.getNume()).forEach(System.out::println);
		
	}

	@Override
	public void start(Stage arg0) throws Exception {
		new MenuController().start();
	}
}
