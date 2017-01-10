package app.restaurant.client;

import java.awt.Desktop.Action;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.restaurant.dao.IstoricComenziDao;
import app.restaurant.dao.impl.IstoricComenziDaoImpl;
import app.restaurant.model.IstoricComenzi;
import app.restaurant.model.Produs;
import app.restaurant.util.ClientUtil;
import app.restaurant.util.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;


public class IstoricController extends AnchorPane implements Initializable {
	
	@FXML
	private TextArea textArea;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void adaugaIstoric(ActionEvent event) {
		
		IstoricComenziDao istoricDao = new IstoricComenziDaoImpl();
		IstoricComenzi istoric = new IstoricComenzi();
		
		istoric.setComandaId(2);
		istoric.setProdusId(3);
		istoricDao.addIstoricComenzi(istoric);
		textArea.setText("A fost adaugata o noua comanda in istoric: \n"
				+ "Numarul comenzii: " + istoric.getComandaId() + "\n"
				+ "Numarul produsului: " + istoric.getProdusId() + "\n");
	}
	
	@FXML
	public void stergeIstoric(ActionEvent event) {
		
		IstoricComenziDao istoricDao = new IstoricComenziDaoImpl();
		IstoricComenzi istoric = new IstoricComenzi();
		
		istoric.setId(3);
		istoricDao.removeIstoricComenzi(istoric);
		textArea.setText("A fost sters din istoric comanda cu numarul : " + istoric.getId());
	}
	
	@FXML
	public void querryButton(ActionEvent event) {
		
		IstoricComenziDao istoricDao = new IstoricComenziDaoImpl();
		IstoricComenzi istoric = new IstoricComenzi();
		
		Produs produs = new Produs();
		
		produs.setId(4);
		istoric.setProdusId(4);
		List<Object[]> result = istoricDao.simpleQuery(istoric, produs);				
		textArea.setText("Rezultatul query-ului este : \n"
				+ result.get(0)[0] + " " + result.get(0)[1] + " " + result.get(0)[2]);
		
	}
	
	@FXML
	public void backButton(ActionEvent event) {
		URL location = getClass().getClassLoader().getResource(Constants.MENU_FXML);
		ClientUtil.showWindow(location, event);
		
	}
}
