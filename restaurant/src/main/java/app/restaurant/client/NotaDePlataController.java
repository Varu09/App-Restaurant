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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class NotaDePlataController extends AnchorPane implements Initializable {
	
	@FXML
	private TextArea textArea;
	
	@FXML
	private TextField textField1;
	
	@FXML
	private TextField textField2;
	
	@FXML
	private TextField textField3;
	
	@FXML
	private TextField textField4;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void adaugaChitanta(ActionEvent event) {
		
		NotaDePlataDao notaDao = new NotaDePlataDaoImpl();
		NotaDePlata nota = new NotaDePlata();
		
		nota.setNrMasa(Integer.parseInt(textField1.getText()));
		nota.setGramajTotal(Integer.parseInt(textField2.getText()));		
		nota.setPretTotal(Integer.parseInt(textField3.getText()));
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
		nota.setId(Integer.parseInt(textField4.getText()));
		notaDao.removeNota(nota);
		
		textArea.setText("A fost stearsa nota de plata cu numarul : " + nota.getId());
	}
	
	@FXML
	public void updateChitanta(ActionEvent event) {
		
		NotaDePlataDao notaDao = new NotaDePlataDaoImpl();
		NotaDePlata nota = new NotaDePlata();
		
		nota.setId(Integer.parseInt(textField4.getText()));
		nota.setGramajTotal(Integer.parseInt(textField2.getText()));
		nota.setPretTotal(Integer.parseInt(textField3.getText()));
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
		textArea.setText("SELECT A.nr_masa, A.gramaj_total, A.pret_total \n"
					+ "FROM nota_de_plata A \n"
					+ "INNER JOIN masa B ON A.nr_masa = B.id \n"
					+ "WHERE A.nr_masa = " + nota.getNrMasa() + "\n"
					+ "AND B.id = " + masa.getId() + "\n"
					+ "\n"
					+ "\n"
				+ "Rezultatul query-ului este : \n"
				+ "Numarul mesei : " + result.get(0)[0] + "\n"
				+ "Gramajul total : " + result.get(0)[1] + " g " +"\n"
				+ "Pretul total : " + result.get(0)[2] + " lei ");
		
	}
	
	@FXML
	public void queryComplex(ActionEvent event) {
		
		NotaDePlataDao notaDao = new NotaDePlataDaoImpl();
		NotaDePlata nota = new NotaDePlata();		
		Comanda comanda = new Comanda();
		
		comanda.setData("2017-01-01 02:20:00");
		List<Object[]> result = notaDao.complexQuery(comanda);		
		textArea.setText("SELECT pret_total \n"
					+ "FROM nota_de_plata \n"
					+ "WHERE id IN (SELECT id \n"
					+ 	  "\t \t \t FROM comanda \n"
					+ 	  "\t \t \t WHERE data = " + comanda.getData() + ") \n"
					+ "\n"
					+ "\n"
				+ "Rezultatul query-ului este : \n"				
				+ "Pretul total : " + result.get(0) + " lei ");
		  	
	}
	
	@FXML
	public void afisChitante(ActionEvent event) {
		
		NotaDePlataDao notaDao = new NotaDePlataDaoImpl();
		List<NotaDePlata> chitante = notaDao.getChitante();
		
		String chitanteList = "";
		for(NotaDePlata nota : chitante) {
			chitanteList += nota.display();
		}
		textArea.setText("Id chitanta"+ Constants.TAB +"Numarul mesei" + Constants.TAB + "Gramajul total" + Constants.TAB + "Pretul total" + "\n" 
				+ "\n" 
				+ chitanteList);
	}
	
	@FXML
	public void resetButton(ActionEvent event) {
		
		textField1.setText(null);
		textField2.setText(null);	
		textField3.setText(null);
		textField4.setText(null);
	}
	
	@FXML
	public void backButton(ActionEvent event) {
		URL location = getClass().getClassLoader().getResource(Constants.MENU_FXML);
		ClientUtil.showWindow(location, event);
		
	}
}
