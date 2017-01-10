package app.restaurant.client;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.restaurant.dao.CustomerDao;
import app.restaurant.dao.ProdusDao;
import app.restaurant.dao.impl.CustomerDaoImpl;
import app.restaurant.dao.impl.ProdusDaoImpl;
import app.restaurant.model.Categorie;
import app.restaurant.model.Customer;
import app.restaurant.model.Produs;
import app.restaurant.util.ClientUtil;
import app.restaurant.util.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class ProduseController extends AnchorPane implements Initializable {
	
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
	public void adaugaProdus(ActionEvent event) {
		//System.out.println("Produs adaugat...");
		
		ProdusDao produsDao = new ProdusDaoImpl();
		Produs produs = new Produs();
		
		produs.setCategorieId(2);
		produs.setNume("Ciorba de burta");
		produs.setPret(11);
	    produs.setGramaj(150);
		produsDao.addProdus(produs);
		
		textArea.setText("A fost adaugat urmatorul produs: \n"
				+ "Denumire : " + produs.getNume() + "\n"
				+ "Pret : " + produs.getPret() + " lei \n"
				+ "Gramaj : " + produs.getGramaj() + " g");
		
	}
	
	@FXML
	public void stergeProdus(ActionEvent event) {
		//System.out.println("Produs sters...");
		
		ProdusDao produsDao = new ProdusDaoImpl();
		Produs produs = new Produs();
		
		produs.setId(9);
		produsDao.removeProdus(produs);
		textArea.setText("A fost sters produsul cu id : " + produs.getId());
		
	}
	
	@FXML
	public void updateProdus(ActionEvent event) {
		//System.out.println("S-a realizat update-ul...");
		ProdusDao produsDao = new ProdusDaoImpl();
		Produs produs = new Produs();
		
		produs.setPret(6);
		produs.setId(1);
		produs.setGramaj(100);
		produs.setNume("Sunca");
		produsDao.updateProdus(produs);
		
		textArea.setText("S-a realizat urmatorul update : \n"
				+ "Denumire : " + produs.getNume() + "\n"
				+ "Pret : " + produs.getPret() + " lei \n"
				+ "Gramaj : " + produs.getGramaj() + " g");
		
	}
	
	@FXML
	public void queryButton(ActionEvent event) {
		ProdusDao produsDao = new ProdusDaoImpl();		
		Categorie categorie = new Categorie();
		  
		  categorie.setDenumire("Preparate reci");
		  List<Object[]> result = produsDao.complexQuery(categorie);
		  textArea.setText("Rezultatul query-ului este : \n "
				  + result.get(0)[0] + " " + result.get(0)[1] + " ");
	}
	
	@FXML
	public void afisProduse(ActionEvent event) {
		
		ProdusDao produsDao = new ProdusDaoImpl();					
		
		List<Produs> produse = produsDao.getProduse();
		
		String produseList = "";		
		for(Produs produs: produse){
			produseList += produs.display();
			System.out.println(produseList);
		}
		textArea.setText("Numarul categoriei" + Constants.TAB + "Denumire" + Constants.TAB + "Pret" + Constants.TAB + "Gramaj" 
						+ "\n" 
						+ produseList);
	}
	
	@FXML
	public void backButton(ActionEvent event) {
		
		URL location = getClass().getClassLoader().getResource(Constants.MENU_FXML);
		ClientUtil.showWindow(location, event);		
	}

}
