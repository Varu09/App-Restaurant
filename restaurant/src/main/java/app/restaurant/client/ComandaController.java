package app.restaurant.client;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.restaurant.dao.ComandaDao;
import app.restaurant.dao.impl.ComandaDaoImpl;
import app.restaurant.model.Comanda;
import app.restaurant.model.IstoricComenzi;
import app.restaurant.util.ClientUtil;
import app.restaurant.util.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class ComandaController extends AnchorPane implements Initializable{
	
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
	public void adaugaComenzi(ActionEvent event) {
		
		ComandaDao comandaDao = new ComandaDaoImpl();
		Comanda comanda = new Comanda();
		
		comanda.setClientId(Integer.parseInt(textField1.getText()));
		comanda.setData(textField2.getText());
		comandaDao.addComanda(comanda);
		
		textArea.setText("A fost adaugata comanda : \n"
				 + "Numarul clientului : " + comanda.getClientId() + "\n"
				 + "Data comenzii: " + comanda.getData() + "\n");	
	}
	
	@FXML
	public void stergeComanda(ActionEvent event) {
		
		ComandaDao comandaDao = new ComandaDaoImpl();
		Comanda comanda = new Comanda();
		
		comanda.setId(Integer.parseInt(textField3.getText()));
		comandaDao.removeComanda(comanda);
		
		textArea.setText("A fost stearsa comanda cu numarul : " + comanda.getId());
	}
	
	@FXML
	public void updateComanda(ActionEvent event) {
		
		ComandaDao comandaDao = new ComandaDaoImpl();
		Comanda comanda = new Comanda();
		
		comanda.setId(Integer.parseInt(textField3.getText()));
		comanda.setData(textField2.getText());
		comandaDao.updateComanda(comanda);
		
		textArea.setText("S-a realizat un update : \n"
						 + "Comanda cu numarul : "+ comanda.getId() + "\n"
						 + "Are data de : " + comanda.getData());
		
	}
	
	@FXML
	public void queryButton(ActionEvent event) {
		
		ComandaDao comandaDao = new ComandaDaoImpl();
		Comanda comanda = new Comanda();		
		IstoricComenzi istoric = new IstoricComenzi();
		
		comanda.setId(1);
		istoric.setComandaId(1);
		List<Object[]> result = comandaDao.simpleQuery(comanda, istoric);
		textArea.setText("SELECT A.data "
					+ "FROM comanda A \n"
					+ "INNER JOIN istoric_comenzi B ON A.id = B.comanda_id \n"
					+ "WHERE A.id = " + comanda.getId() + "\n"
					+ "AND B.comanda_id = " + istoric.getComandaId() + "\n"
					+ "\n"
					+ "\n"
				+ "Rezultatul query-ului : \n"
				+ result.get(0));		
		
	}
	
	@FXML
	public void afisComenzi(ActionEvent event) {
		
		ComandaDao comandaDao = new ComandaDaoImpl();
		
		List<Comanda> comenzi = comandaDao.getComenzi();
		
		String comandaList = "";
		for(Comanda comanda: comenzi) {
			comandaList += comanda.display();
		}
		
		textArea.setText("Id comanda"+ Constants.TAB +"Numarul clientului" + Constants.TAB + "data comenzii" + "\n"
				+ "\n" 
				+ comandaList);
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
