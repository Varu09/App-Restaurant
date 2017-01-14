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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ProduseController extends AnchorPane implements Initializable {
	
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
	
	@FXML
	private TextField textField5;

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
		
		produs.setCategorieId(Integer.parseInt(textField1.getText()));
		produs.setNume(textField2.getText());
		produs.setPret(Integer.parseInt(textField3.getText()));
	    produs.setGramaj(Integer.parseInt(textField4.getText()));
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
		
		produs.setId(Integer.parseInt(textField5.getText()));
		produsDao.removeProdus(produs);
		textArea.setText("A fost sters produsul cu id : " + produs.getId());
		
	}
	
	@FXML
	public void updateProdus(ActionEvent event) {
		//System.out.println("S-a realizat update-ul...");
		ProdusDao produsDao = new ProdusDaoImpl();
		Produs produs = new Produs();
		
		produs.setPret(Integer.parseInt(textField3.getText()));
		produs.setId(Integer.parseInt(textField5.getText()));
		produs.setGramaj(Integer.parseInt(textField4.getText()));
		produs.setNume(textField2.getText());
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
		  textArea.setText("SELECT  P.nume, P.pret \n"
					+ "FROM produs P \n"
					+ "WHERE P.id IN (SELECT categorie_id \n"
					+ 		 "\t \t \t FROM categorie \n"
					+  		 "\t \t \t WHERE denumire = " + categorie.getDenumire() + ") \n"
					+ "\n"
					+ "\n"
		  		+ "Rezultatul query-ului este : \n "
				  + result.get(0)[0] + " " + result.get(0)[1] + " lei ");
	}
	
	@FXML
	public void afisProduse(ActionEvent event) {
		
		ProdusDao produsDao = new ProdusDaoImpl();	
		List<Produs> produse = produsDao.getProduse();
		
		String produseList = "";		
		for(Produs produs: produse){
			produseList += produs.display();
			
		}
		textArea.setText("Id produs"+ Constants.TAB +"Numarul categoriei" + Constants.TAB + "Denumire" + Constants.TAB + "Pret" + Constants.TAB + "Gramaj" + "\n" 
						+ "\n" 
						+ produseList);
	}
	
	@FXML
	public void resetButton(ActionEvent event) {
		
		textField1.setText(null);
		textField2.setText(null);
		textField3.setText(null);
		textField4.setText(null);
		textField5.setText(null);
	}
	
	@FXML
	public void backButton(ActionEvent event) {
		
		URL location = getClass().getClassLoader().getResource(Constants.MENU_FXML);
		ClientUtil.showWindow(location, event);		
	}

}
