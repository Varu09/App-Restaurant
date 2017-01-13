package app.restaurant.client;

import java.awt.Desktop.Action;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.restaurant.dao.NotaDePlataDao;
import app.restaurant.dao.impl.NotaDePlataDaoImpl;
import app.restaurant.model.Comanda;
import app.restaurant.model.Masa;
import app.restaurant.model.NotaDePlata;
import app.restaurant.util.ClientUtil;
import app.restaurant.util.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class NotaDePlataController extends AnchorPane implements Initializable {
	
	@FXML
	private TextArea textArea;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void adaugaChitanta(ActionEvent event) {
		
		NotaDePlataDao notaDao = new NotaDePlataDaoImpl();
		NotaDePlata nota = new NotaDePlata();
		
		nota.setGramajTotal(600);
		nota.setNrMasa(1);
		nota.setPretTotal(120);
		notaDao.addNota(nota);
		
		textArea.setText("A fost adaugata urmatoarea nota de plata : \n"
				+ "Numarul mesei : " + nota.getNrMasa() + "\n"
				+ "Gramajul total : " + nota.getGramajTotal() + "\n"
				+ "Pretul total : " + nota.getPretTotal());
	}
	
	@FXML
	public void stergeChitanta(ActionEvent event) {
		
		NotaDePlataDao notaDao = new NotaDePlataDaoImpl();
		NotaDePlata nota = new NotaDePlata();
		nota.setId(3);
		notaDao.removeNota(nota);
		
		textArea.setText("A fost stearsa nota de plata cu numarul : " + nota.getId());
	}
	
	@FXML
	public void updateChitanta(ActionEvent event) {
		
		NotaDePlataDao notaDao = new NotaDePlataDaoImpl();
		NotaDePlata nota = new NotaDePlata();
		
		nota.setId(4);
		nota.setGramajTotal(1000);
		nota.setPretTotal(200);
		notaDao.updateNota(nota);
		textArea.setText("S-a realizat urmatorul update : \n"
				+ "Nota cu numarul : " + nota.getId() + "\n"
				+ "Noul gramaj total : " + nota.getGramajTotal() + "\n"
				+ "Noul pret total : " + nota.getPretTotal());		
	}
	
	@FXML
	public void querySimplu(ActionEvent event) {
		
		NotaDePlataDao notaDao = new NotaDePlataDaoImpl();
		NotaDePlata nota = new NotaDePlata();
		Masa masa = new Masa();
		
		masa.setId(2);
		nota.setNrMasa(2);
		List<Object[]> result = notaDao.simpleQuery(nota, masa);
		textArea.setText("Rezultatul query-ului este: \n"
				+ result.get(0)[0] + " " + result.get(0)[1] + " " + result.get(0)[2]);
		
	}
	
	@FXML
	public void queryComplex(ActionEvent event) {
		
		NotaDePlataDao notaDao = new NotaDePlataDaoImpl();
		NotaDePlata nota = new NotaDePlata();		
		Comanda comanda = new Comanda();
		
		comanda.setData("2017-01-01 02:20:00");
		List<Object[]> result = notaDao.complexQuery(comanda);		
		textArea.setText("Rezultatul query-ului este: \n"
				+ result.get(0)[0] + " " + result.get(0)[1] + " " + result.get(0)[2]);
		  	
	}
	
	//TODO afisare
	
	@FXML
	public void backButton(ActionEvent event) {
		URL location = getClass().getClassLoader().getResource(Constants.MENU_FXML);
		ClientUtil.showWindow(location, event);
		
	}
}
