package app.restaurant.util;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ClientUtil  extends AnchorPane {
	
	 
	
	public static void showWindow(URL location, ActionEvent event){
		Parent root;
        try {
            root = FXMLLoader.load(location);
            Stage stage = new Stage();
            //stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
}
