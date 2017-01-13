package app.restaurant.client;

import java.awt.Desktop.Action;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.restaurant.dao.CategorieDao;
import app.restaurant.dao.impl.CategorieDaoImpl;
import app.restaurant.model.Categorie;
import app.restaurant.model.Produs;
import app.restaurant.util.ClientUtil;
import app.restaurant.util.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;


public class CategorieController extends AnchorPane implements Initializable {
	
	@FXML
	private TextArea textArea;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void adaugaCategorie(ActionEvent event) {
		
		CategorieDao categorieDao = new CategorieDaoImpl();
		Categorie categorie = new Categorie();
		
		categorie.setDenumire("Specialitatea casei");
		categorieDao.addCategorie(categorie);
		
		textArea.setText("A fost adaugata categoria : \n"
				+ categorie.getDenumire());
	}
	
	@FXML
	public void stergeCategorie(ActionEvent event) {
		
		CategorieDao categorieDao = new CategorieDaoImpl();
		Categorie categorie = new Categorie();
		
		categorie.setId(4);
		categorieDao.removeCategorie(categorie);
		textArea.setText("A fost stearsa categoria cu numarul : " + categorie.getId());
	}
	
	@FXML
	public void updateCategorie(ActionEvent event) {
		
		CategorieDao categorieDao = new CategorieDaoImpl();
		Categorie categorie = new Categorie();
		
		categorie.setDenumire("Bauturi");
		categorie.setId(5); 
		categorieDao.updateCategorie(categorie);
		textArea.setText("S-a realizat update-ul urmator : \n"
				+ "Denumire categorie : " + categorie.getDenumire() + "\n");
		
	}
	
	@FXML
	public void querySimplu(ActionEvent event) {
		
		CategorieDao categorieDao = new CategorieDaoImpl();
		Categorie categorie = new Categorie();
		Produs produs = new Produs();
		
		categorie.setId(2);
		produs.setCategorieId(2);
		List<Object[]> result = categorieDao.simpleQuery(categorie, produs);
		textArea.setText("Rezultatul query-ului este: \n"
				+ result.get(0)[0] + ": " + result.get(0)[1] + "\n"
				+ result.get(1)[0] + ": " + result.get(1)[1]);		
	}
	
	@FXML
	public void queryComplex(ActionEvent event) {
		
		CategorieDao categorieDao = new CategorieDaoImpl();
		Categorie categorie = new Categorie();
		Produs produs = new Produs();
		  
		  produs.setGramaj(500);				  
		  List<Object[]> result = categorieDao.complexQuery(produs);
		  textArea.setText("Rezultatul query-ului este : \n"
		  		+ result.get(0));
	}
	
	//TODO afisare
	
	@FXML
	public void backButton(ActionEvent event) {
		URL location = getClass().getClassLoader().getResource(Constants.MENU_FXML);
		ClientUtil.showWindow(location, event);
		
	}
}
