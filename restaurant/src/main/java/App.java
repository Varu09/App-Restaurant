
import java.io.IOException;
import java.util.List;

import app.restaurant.client.MenuController;
import app.restaurant.dao.CategorieDao;
import app.restaurant.dao.ComandaDao;
import app.restaurant.dao.CustomerDao;
import app.restaurant.dao.IstoricComenziDao;
import app.restaurant.dao.MasaDao;
import app.restaurant.dao.NotaDePlataDao;
import app.restaurant.dao.ProdusDao;
import app.restaurant.dao.impl.CategorieDaoImpl;
import app.restaurant.dao.impl.ComandaDaoImpl;
import app.restaurant.dao.impl.CustomerDaoImpl;
import app.restaurant.dao.impl.IstoricComenziDaoImpl;
import app.restaurant.dao.impl.MasaDaoImpl;
import app.restaurant.dao.impl.NotaDePlataDaoImpl;
import app.restaurant.dao.impl.ProdusDaoImpl;
import app.restaurant.model.Categorie;
import app.restaurant.model.Comanda;
import app.restaurant.model.Customer;
import app.restaurant.model.IstoricComenzi;
import app.restaurant.model.Masa;
import app.restaurant.model.NotaDePlata;
import app.restaurant.model.Produs;
import app.restaurant.util.Constants;
import app.restaurant.tests.*;
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
        launch(args);   	
    	
    	//Tester.runTest();
		
		
    	
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


}
