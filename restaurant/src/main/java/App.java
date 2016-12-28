
import java.io.IOException;
import java.util.List;

import app.restaurant.client.MenuController;
import app.restaurant.dao.CategorieDao;
import app.restaurant.dao.ComandaDao;
import app.restaurant.dao.CustomerDao;
import app.restaurant.dao.MasaDao;
import app.restaurant.dao.impl.CategorieDaoImpl;
import app.restaurant.dao.impl.ComandaDaoImpl;
import app.restaurant.dao.impl.CustomerDaoImpl;
import app.restaurant.dao.impl.MasaDaoImpl;
import app.restaurant.model.Categorie;
import app.restaurant.model.Comanda;
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
    
    
    //===================================================
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
       // launch(args);   	
    	
    	test();
		
		
    	
    }
    //====================================================

    
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
		
		//Comanda
		
		ComandaDao comandaDao = new ComandaDaoImpl();
		Comanda comanda = new Comanda();
		
		comanda.setClientId(3);
		comanda.setData("2016-09-23");
		comandaDao.addComanda(comanda);
		
		
		/*====================================================================================================
		// Categorie
			
				CategorieDao categorieDao = new CategorieDaoImpl();
				Categorie categorie = new Categorie();
				
				//categorie.setDenumire("Gratar");
				//categorieDao.addCategorie(categorie);
				
				//categorie.setDenumire("Bauturi");
				//categorie.setId(3); 
				//categorieDao.updateCategorie(categorie);
				
				//categorieDao.removeCategorie(categorie);
				
				//List<Categorie> categorii = categorieDao.getCategorie();				
				//categorii.stream().map(m -> m.getDenumire()).forEach(System.out::println);
		
		   ====================================================================================================*/
		/* ====================================================================================================
		// Masa
				MasaDao masaDao = new MasaDaoImpl();
				Masa masa = new Masa();
				//masa.setNrLocuri(10);
				//masaDao.addTable(masa);
				
				
				//masa.setId(3);
				//masa.setNrLocuri(5);
				//masaDao.updateTable(masa);
				
				//masa.setId(2);
				//masaDao.removeTable(masa);
				
				
				//newTable.setNrLocuri(7);
				//masaDao.updateTable(newTable);
				List<Masa> mese = masaDao.getTables();

				mese.stream().map(m -> m.getNrLocuri()).forEach(System.out::println);
			====================================================================================================*/	
			
		/* ====================================================================================================
		 
		// Clienti
				
				CustomerDao clientDao = new CustomerDaoImpl();
				
				Customer newClient = new Customer();
				newClient.setNume("Hamilton");
				newClient.setPrenume("John");
				newClient.setNrMasa(1);
				clientDao.addCustomer(newClient);
				
				newClient.setId(1);
				newClient.setNume("Vasile");
				clientDao.updateCustomer(newClient);			
				
				newClient.setId(1);
			    clientDao.removeCustomer(newClient);
			    
				
				//List<Customer> clienti = clientDao.getCustomersByName("Vasile", "John");
				
				//clienti.stream().map(c -> c.getNume()).forEach(System.out::println);
		==================================================================================================== */
		
	}


}
