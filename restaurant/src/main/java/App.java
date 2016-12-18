
import java.io.IOException;
import java.util.List;

import app.restaurant.client.MenuController;
import app.restaurant.dao.CustomerDao;
import app.restaurant.dao.MasaDao;
import app.restaurant.dao.impl.CustomerDaoImpl;
import app.restaurant.dao.impl.MasaDaoImpl;
import app.restaurant.model.Customer;
import app.restaurant.model.Masa;
import app.restaurant.util.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {
	
	
	private Stage primaryStage;
    private BorderPane rootLayout;

    public static void main(String[] args) {
        launch(args);
    }

    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Meniul Principal");

        initRootLayout();

        showMenu();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource(Constants.ROOT_FXML));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showMenu() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource(Constants.MENU_FXML));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
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


}
