package app.restaurant.client;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.restaurant.dao.MasaDao;
import app.restaurant.dao.impl.MasaDaoImpl;
import app.restaurant.model.Masa;
import app.restaurant.util.ClientUtil;
import app.restaurant.util.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MeseController extends AnchorPane implements Initializable {
	
	@FXML
	private TextArea textArea;
	
	@FXML
	private TextField textField1;
	
	@FXML
	private TextField textField2;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Aici vin metodele butoanelor
	 */
	
	@FXML
	public void adaugaMasa(ActionEvent event) {
		
		MasaDao masaDao = new MasaDaoImpl();
		Masa masa = new Masa();
		
		masa.setNrLocuri(Integer.parseInt(textField2.getText()));
		masaDao.addTable(masa);
		
		textArea.setText("A fost adaugata o masa: \n"
				+ "Nr de locuri : " + masa.getNrLocuri() + "\n");
	}
	
	@FXML
	public void stergeMasa(ActionEvent event) {
		
		MasaDao masaDao = new MasaDaoImpl();
		Masa masa = new Masa();
		
		masa.setId(Integer.parseInt(textField1.getText()));
		masaDao.removeTable(masa);
		textArea.setText("A fost stearsa masa cu numarul : " + masa.getId());
	}
	
	@FXML
	public void updateMasa(ActionEvent event) {
		
		MasaDao masaDao = new MasaDaoImpl();
		Masa masa = new Masa();
		
		masa.setId(Integer.parseInt(textField1.getText()));
		masa.setNrLocuri(Integer.parseInt(textField2.getText()));
		masaDao.updateTable(masa);
		
		textArea.setText("Masa cu numarul : " + masa.getId() + "\n"
				+ "Are acum " + masa.getNrLocuri() + " locuri");
	}
	
	@FXML
	public void queryComplex(ActionEvent event) {
		MasaDao masaDao = new MasaDaoImpl();
		Masa masa = new Masa();
		
		masa.setId(2);
		  List<Object[]> result = masaDao.complexQuery(masa);
		  textArea.setText("SELECT M.id, P.nume, P.gramaj \n"
					+ "FROM masa M \n"
					+ "INNER JOIN customer C ON C.nr_masa = M.id \n"
					+ "INNER JOIN comanda CM ON C.id = CM.customer_id \n"
					+ "INNER JOIN istoric_comenzi IC ON CM.id = IC.comanda_id \n"
					+ "INNER JOIN  produs P ON IC.produs_id = P.id \n"
					+ "WHERE M.id = " + masa.getId() + "\n"
					+ "\n"
					+ "\n"
		  		+ "Rezultatul query-ului: \n"
		  		+ "Numarul mesei : " +result.get(0)[0] + "\n" 
				+ "Produsul : " + result.get(0)[1] + "\n"
				+ "Gramajul : " + result.get(0)[2] + " g ");
		  		
	}
	
	@FXML
	public void afisMese(ActionEvent event) {
		
		MasaDao masaDao = new MasaDaoImpl();
		List<Masa> mese = masaDao.getTables();
		
		String meseList = "";
		for(Masa masa : mese) {
			meseList += masa.display();
		}
		textArea.setText("Numarul mesei" + Constants.TAB + "Numarul de locuri" + "\n" 
				+ "\n" 
				+ meseList);
	}
	
	@FXML
	public void resetButton(ActionEvent event) {
		
		textField1.setText(null);
		textField2.setText(null);		
	}
	
	@FXML
	public void backButton(ActionEvent event) {
		
		URL location = getClass().getClassLoader().getResource(Constants.MENU_FXML);
		ClientUtil.showWindow(location, event);		
	}
}
