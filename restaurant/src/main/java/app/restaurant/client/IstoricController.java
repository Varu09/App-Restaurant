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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class IstoricController extends AnchorPane implements Initializable {
	
	@FXML
	private TextArea textArea;
	
	@FXML
	private TextField textField1;
	
	@FXML
	private TextField textField2;
	
	@FXML
	private TextField textField3;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void adaugaIstoric(ActionEvent event) {
		
		IstoricComenziDao istoricDao = new IstoricComenziDaoImpl();
		IstoricComenzi istoric = new IstoricComenzi();
		
		istoric.setComandaId(Integer.parseInt(textField1.getText()));
		istoric.setProdusId(Integer.parseInt(textField2.getText()));
		istoricDao.addIstoricComenzi(istoric); 
		textArea.setText("A fost adaugata o noua comanda in istoric: \n"
				+ "Numarul comenzii: " + istoric.getComandaId() + "\n"
				+ "Numarul produsului: " + istoric.getProdusId() + "\n");
	}
	
	@FXML
	public void stergeIstoric(ActionEvent event) {
		
		IstoricComenziDao istoricDao = new IstoricComenziDaoImpl();
		IstoricComenzi istoric = new IstoricComenzi();
		
		istoric.setId(Integer.parseInt(textField3.getText()));
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
		textArea.setText("SELECT A.nume, A.pret, A.gramaj \n"
					+ "FROM produs A "
					+ "INNER JOIN istoric_comenzi B ON A.id = B.produs_id \n"
					+ "WHERE A.id = " + produs.getId() + "\n"
					+ "AND produs_id = " + istoric.getProdusId() + "\n"
					+ "\n"
					+ "\n"
				+ "Rezultatul query-ului este : \n"
				+ result.get(0)[0] + " " + result.get(0)[1] + " lei " + result.get(0)[2] + " g ");
		
	}
	
	@FXML
	public void afisIstoric(ActionEvent action) {
		
		IstoricComenziDao istoricDao = new IstoricComenziDaoImpl();
		List<IstoricComenzi> istorice = istoricDao.getIstoricComenzi();
		
		String istoricList = "";
		for(IstoricComenzi istoric : istorice) {
			istoricList += istoric.display();
		}
		textArea.setText("Id"+ Constants.TAB +"Numarul comenzii" + Constants.TAB + "numarul produsului" + "\n"
				+ "\n" 
				+ istoricList);
	}
	
	@FXML
	public void resetButton(ActionEvent event) {
		
		textField1.setText(null);
		textField2.setText(null);	
		textField3.setText(null);
	}
	
	@FXML
	public void backButton(ActionEvent event) {
		URL location = getClass().getClassLoader().getResource(Constants.MENU_FXML);
		ClientUtil.showWindow(location, event);
		
	}
}
