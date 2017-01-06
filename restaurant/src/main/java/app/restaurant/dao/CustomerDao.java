package app.restaurant.dao;

import java.util.List;

import app.restaurant.model.Masa;
import app.restaurant.model.Comanda;
import app.restaurant.model.Customer;


public interface CustomerDao {
	public List<Customer> getCustomer();
	public void addCustomer(Customer client);
	public void updateCustomer(Customer client);
	public void removeCustomer(Customer client);
	public List<Customer> getCustomersByName(String nume, String prenume);
	public List<Object[]> simpleQuery(Customer client, Masa masa);
	public List<Object[]> simpleQuery2(Customer client, Comanda comanda);
}
