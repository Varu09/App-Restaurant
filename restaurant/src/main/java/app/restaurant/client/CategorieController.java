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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class CategorieController extends AnchorPane implements Initializable {
	
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
	
	@FXML
	public void adaugaCategorie(ActionEvent event) {
		
		CategorieDao categorieDao = new CategorieDaoImpl();
		Categorie categorie = new Categorie();
		
		categorie.setDenumire(textField1.getText());
		categorieDao.addCategorie(categorie);
		
		textArea.setText("A fost adaugata categoria : \n"
				+ categorie.getDenumire());
	}
	
	@FXML
	public void stergeCategorie(ActionEvent event) {
		
		CategorieDao categorieDao = new CategorieDaoImpl();
		Categorie categorie = new Categorie();
		
		categorie.setId(Integer.parseInt(textField2.getText()));
		categorieDao.removeCategorie(categorie);
		textArea.setText("A fost stearsa categoria cu numarul : " + categorie.getId());
	}
	
	@FXML
	public void updateCategorie(ActionEvent event) {
		
		CategorieDao categorieDao = new CategorieDaoImpl();
		Categorie categorie = new Categorie();
		
		categorie.setDenumire(textField1.getText());
		categorie.setId(Integer.parseInt(textField2.getText())); 
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
		textArea.setText("SELECT C.denumire, P.nume \n"
					+ "FROM produs P \n"
					+ "INNER JOIN categorie C ON P.categorie_id = C.id \n"
					+ "WHERE P.categorie_id = " + produs.getCategorieId() + "\n"
					+ "AND C.id = " + categorie.getId() + "\n"
					+ "\n"
					+ "\n"
				+ "Rezultatul query-ului este: \n"
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
		  textArea.setText("SELECT denumire \n"
					+ "FROM categorie \n"
					+ "WHERE id IN (SELECT categorie_id \n"
					+ 	 "\t \t \t FROM produs \n"
					+ 	 "\t \t \t WHERE gramaj = " + produs.getGramaj() + ") \n"
					+ "\n"
					+ "\n"
		  		+ "Rezultatul query-ului este : \n"
		  		+ result.get(0));
	}
	
	@FXML
	public void afisCategorii(ActionEvent event) {
		
		CategorieDao categorieDao = new CategorieDaoImpl();
		List<Categorie> categorii = categorieDao.getCategorie();
		
		String categoriiList = "";
		for(Categorie categorie : categorii) {
			categoriiList += categorie.display();
		}
		textArea.setText("Numarul categoriei" + Constants.TAB + "Denumirea" + "\n" 
				+ "\n" 
				+ categoriiList);
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
