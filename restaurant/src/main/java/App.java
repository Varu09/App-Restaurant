
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
        //launch(args);   	
    	
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
		/* ====================================================================================================
		//IstoricComenzi
		
		IstoricComenziDao istoricDao = new IstoricComenziDaoImpl();
		IstoricComenzi istoric = new IstoricComenzi();
		
		//istoric.setComandaId(1);
		//istoric.setProdusId(3);
		//istoricDao.addIstoricComenzi(istoric);
		
		//istoric.setId(2);
		//istoricDao.removeIstoricComenzi(istoric);
		 ====================================================================================================*/
		
		/* ====================================================================================================
		//NotaDePlata
		  
		NotaDePlataDao notaDao = new NotaDePlataDaoImpl();
		NotaDePlata nota = new NotaDePlata();
		
		//nota.setGramajTotal(600);
		//nota.setNrMasa(2);
		//nota.setPretTotal(150);
		//notaDao.addNota(nota);
		
		//nota.setId(1);
		//nota.setGramajTotal(1000);
		//nota.setPretTotal(200);
		//notaDao.updateNota(nota);
		
		//notaDao.removeNota(nota);
		====================================================================================================*/
		
		/* ====================================================================================================
		//Produs
		ProdusDao produsDao = new ProdusDaoImpl();
		Produs produs = new Produs();
		
		//produs.setCategorieId(3);
		//produs.setNume("Ceafa de porc");
		//produs.setPret(15);
		//produs.setGramaj(300);
		//produsDao.addProdus(produs);
		
		//produs.setPret(6);
		//produs.setId(1);
		//produs.setGramaj(250);
		//produs.setNume("Kaiser");
		//produsDao.updateProdus(produs);
		
		//produsDao.removeProdus(produs);
		
		//List<Produs> produse = produsDao.getProduse();
		//produse.stream().map(p -> p.getNume()).forEach(System.out::println);
		
		====================================================================================================*/
		
		/* ====================================================================================================
		//Comanda
		
		ComandaDao comandaDao = new ComandaDaoImpl();
		Comanda comanda = new Comanda();
		
		//comanda.setClientId(2);
		//comanda.setData("2016-09-23 13:54:25");
		//comandaDao.addComanda(comanda);
		
		//comanda.setId(1);
		//comanda.setData("2016-09-23 15:44:04");
		//comandaDao.updateComanda(comanda);
		
		//comandaDao.removeComanda(comanda);
		====================================================================================================*/
		
		/*====================================================================================================
		// Categorie
			
				CategorieDao categorieDao = new CategorieDaoImpl();
				Categorie categorie = new Categorie();
				Produs produs = new Produs();
				
				//==================== JOIN ================================================
				
				categorie.setId(2);
				produs.setCategorieId(2);
				List<Object[]> result = categorieDao.simpleQuery(categorie, produs);
				
				
				System.out.print(result.get(0)[0] + ": ");
				System.out.print(result.get(0)[1]);
				//System.out.println(result.get(1)[0]);
				//System.out.println(result.get(1)[1]);
				
				//==========================================================================
				
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
				Masa masa = new Masa();
				
				//==================== JOIN ================================================
				//masa.setId(2);
				//newClient.setNrMasa(2);
				//List<Object[]> cl = clientDao.simpleQuery(newClient, masa);
				//cl.forEach(c -> System.out.println(c.getNume()));
				//System.out.println(cl.size());
				//cl.stream().map(c -> c.getNume()).forEach(System.out::println);
				//System.out.println(cl.get(0)[0]);
				//System.out.println(cl.get(0)[1]);
				//System.out.println(cl.get(1)[0]);
				//System.out.println(cl.get(1)[1]);
				
				//==========================================================================
				
				//==================== JOIN 2 ================================================
				//Comanda comanda = new Comanda();
				//newClient.setId(1);
				//comanda.setClientId(1);
				//List<Object[]> cl = clientDao.simpleQuery2(newClient,comanda);
				//System.out.print(cl.get(0)[0] + " ");
				//System.out.print(cl.get(0)[1] + ": ");
				//System.out.print(cl.get(0)[2]);				
				
				//==========================================================================
				
				//newClient.setNume("Hamilton");
				//newClient.setPrenume("John");
				//newClient.setNrMasa(1);
				//clientDao.addCustomer(newClient);
				
				//newClient.setId(1);
				//newClient.setNume("Carol");
				//newClient.setPrenume("Alfred");
				//newClient.setNrMasa(2);
				//clientDao.updateCustomer(newClient);			
				
				//newClient.setId(1);
			    //clientDao.removeCustomer(newClient);		    
				
				//List<Customer> clienti = clientDao.getCustomersByName("Carol", "Alfred");
				
				//clienti.stream().map(c -> c.getNume()).forEach(System.out::println);
		==================================================================================================== */
		
	}


}
