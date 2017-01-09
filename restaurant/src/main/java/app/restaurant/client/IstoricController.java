package app.restaurant.client;

import java.net.URL;
import java.util.ResourceBundle;

import app.restaurant.util.ClientUtil;
import app.restaurant.util.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;


public class IstoricController extends AnchorPane implements Initializable {
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void backButton(ActionEvent event) {
		URL location = getClass().getClassLoader().getResource(Constants.MENU_FXML);
		ClientUtil.showWindow(location, event);
		
	}
}
