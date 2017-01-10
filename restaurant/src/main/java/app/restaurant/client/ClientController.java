package app.restaurant.client;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import app.restaurant.dao.CustomerDao;
import app.restaurant.dao.impl.CustomerDaoImpl;
import app.restaurant.model.Comanda;
import app.restaurant.model.Customer;
import app.restaurant.model.Masa;
import app.restaurant.util.ClientUtil;
import app.restaurant.util.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class ClientController extends AnchorPane implements Initializable {
	
	@FXML
	private TextArea textArea;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void adaugaClient(ActionEvent event) {
		
		CustomerDao clientDao = new CustomerDaoImpl();				
		Customer client = new Customer();
		
		client.setNume("Gheorge");
		client.setPrenume("Ionel");
		client.setNrMasa(1);
		clientDao.addCustomer(client);
		
		textArea.setText("A fost adaugat clientul cu urmatoarele specificatii : \n"
				+ "Nume : " + client.getNume() + "\n"
				+ "Prenume : " + client.getPrenume() + "\n"
				+ "Numarul mesei : " + client.getNrMasa());		
	}
	
	@FXML
	public void stergeClient(ActionEvent event) {
		
		CustomerDao clientDao = new CustomerDaoImpl();				
		Customer client = new Customer();
		
		client.setId(4);
	    clientDao.removeCustomer(client);
	    
	    textArea.setText("A fost sters clientul cu id : " + client.getId());
	}
	
	@FXML
	public void updateClient(ActionEvent event) {
		
		CustomerDao clientDao = new CustomerDaoImpl();				
		Customer client = new Customer();
		
		client.setId(3);
		client.setNume("Yamamoto");
		client.setPrenume("Gengryusai");
		client.setNrMasa(2);
		clientDao.updateCustomer(client);
		
		textArea.setText("S-a realizat urmatorul update : \n"
				+ "Nume : " + client.getNume() + "\n"
				+ "Prenume : " + client.getPrenume() + "\n"
				+ "Numarul mesei : " + client.getNrMasa());		
		
	}
	
	@FXML
	public void queryComplexButton(ActionEvent event) {
		  
		CustomerDao clientDao = new CustomerDaoImpl();				
		Customer client = new Customer();
		Comanda comanda = new Comanda();	
		
		comanda.setData("2017-01-01 02:20:00");
		List<Object[]> result = clientDao.complexQuery(client, comanda);
		textArea.setText("Rezultatul query-ului este : \n"
				+ result.get(0)[0] + " " + result.get(0)[1]);
	}
	
	@FXML
	public void querySimpleButton1(ActionEvent event) {
		
		CustomerDao clientDao = new CustomerDaoImpl();				
		Customer client = new Customer();
		Masa masa = new Masa();
		
		masa.setId(2);
		client.setNrMasa(2);
		List<Object[]> result = clientDao.simpleQuery(client, masa);
		
		textArea.setText("Rezultatul query-ului este : \n" 
				+ result.get(0)[0] + " " + result.get(0)[1] + "\n"
				+ result.get(1)[0] + " " + result.get(1)[1] + "\n"
				+ result.get(2)[0] + " " + result.get(2)[1] + "\n");
	}
	
	@FXML
	public void querySimpleButton2(ActionEvent event) {
		
		CustomerDao clientDao = new CustomerDaoImpl();				
		Customer client = new Customer();
		Comanda comanda = new Comanda();
		
		client.setId(1);
		comanda.setClientId(1);
		List<Object[]> result = clientDao.simpleQuery2(client,comanda);
		
		textArea.setText("Rezultatul query-ului este : \n" 
				+ result.get(0)[0] + " " + result.get(0)[1]+ " " + result.get(0)[2]+ "\n");
				
		
	}
	
	@FXML
	public void afisClienti(ActionEvent event) {
		
		CustomerDao clientDao = new CustomerDaoImpl();				
		
		List<Customer> clienti = clientDao.getCustomers();
		
		String clientsList = "";
		for(Customer client: clienti){
			clientsList += client.display();			
		}
		textArea.setText("Nume" + Constants.TAB + "Prenume" + Constants.TAB + "Numarul mesei \n"
						+ "\n" 
						+ clientsList);
		
	}
	
	@FXML
	public void backButton(ActionEvent event) {
		URL location = getClass().getClassLoader().getResource(Constants.MENU_FXML);
		ClientUtil.showWindow(location, event);
		
	}
}
