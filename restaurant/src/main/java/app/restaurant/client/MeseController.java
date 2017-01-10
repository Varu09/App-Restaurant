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
import javafx.scene.layout.AnchorPane;

public class MeseController extends AnchorPane implements Initializable {
	
	@FXML
	private TextArea textArea;

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
		
		masa.setNrLocuri(10);
		masaDao.addTable(masa);
		
		textArea.setText("A fost adaugata o masa: \n"
				+ "Nr de locuri : " + masa.getNrLocuri() + "\n");
	}
	
	@FXML
	public void stergeMasa(ActionEvent event) {
		
		MasaDao masaDao = new MasaDaoImpl();
		Masa masa = new Masa();
		
		masa.setId(4);
		masaDao.removeTable(masa);
		textArea.setText("A fost stearsa masa cu numarul : " + masa.getId());
	}
	
	@FXML
	public void updateMasa(ActionEvent event) {
		
		MasaDao masaDao = new MasaDaoImpl();
		Masa masa = new Masa();
		
		masa.setId(3);
		masa.setNrLocuri(5);
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
		  textArea.setText("Rezultatul query-ului: \n"
		  		+ result.get(0)[0] + " " + result.get(0)[1] + "\n");
		  		
	}
	
	//TODO afis
	
	@FXML
	public void backButton(ActionEvent event) {
		
		URL location = getClass().getClassLoader().getResource(Constants.MENU_FXML);
		ClientUtil.showWindow(location, event);		
	}
}
