package app.restaurant.client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.restaurant.util.ClientUtil;
import app.restaurant.util.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuController extends AnchorPane implements Initializable {
	private Stage primaryStage;
    private BorderPane rootLayout;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void start() {

		primaryStage = new Stage();
		primaryStage.setTitle(Constants.APPLICATION_NAME);
		//primaryStage.getIcons().add(new Image(getClass().getResource(Constants.ICON_FILE_NAME).toExternalForm()));
	}
	
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getParent().getClass().getResource(Constants.MENU_FXML));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	
	/**
	 * Metodele de pe butoanele meniului principal
	 */
	public void showClient(ActionEvent event) {
		System.out.println("Asta e clientul...");
	}
	
	public void showComanda(ActionEvent event) {
		System.out.println("Asta e comanda...");
	}
	
	@FXML
	public void showProduse(ActionEvent event) throws IOException  {
		
		URL location = getClass().getClassLoader().getResource(Constants.PRODUSE_FXML);
        ClientUtil.showWindow(location, event);
	}
	
	
	
	public void showIstoric(ActionEvent event) {
		System.out.println("Asta e istoricul...");
	}
}
