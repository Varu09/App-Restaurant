package app.restaurant.client;

import java.io.IOException;

import app.restaurant.util.Constants;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuController extends AnchorPane{
	private Stage primaryStage;
    private BorderPane rootLayout;
	
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
            loader.setLocation(getClass().getResource(Constants.MENU_FXML));
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
	
}
