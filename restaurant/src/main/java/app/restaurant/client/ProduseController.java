package app.restaurant.client;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class ProduseController extends AnchorPane implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Aici vin metodele butoanelor
	 */
	
	public void adaugaProdus(ActionEvent event) {
		System.out.println("Produs adaugat...");
	}
	
	public void stergeProdus(ActionEvent event) {
		System.out.println("Produs sters...");
	}
	
	public void updateProdus(ActionEvent event) {
		System.out.println("S-a realizat update-ul...");
	}

}
