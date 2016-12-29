package app.restaurant.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import app.restaurant.dao.CustomerDao;
import app.restaurant.model.Customer;
import app.restaurant.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {
	
	public List<Customer> getCustomer() {
		List<Customer> clienti = null;		
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            clienti = session.createCriteria(Customer.class).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return clienti;
	}
	
	/**
	 * Metoda asta face INSERT
	 */
	public void addCustomer(Customer client) {
		Session session = null;
        Transaction transaction = null;
        //Customer newCustomer = null;
        try {
            session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery("INSERT INTO CUSTOMER(nume,prenume,nr_masa) "
            										+ "VALUES(:nume,:prenume,:nrMasa)");
            query.setParameter("nume", client.getNume());
            query.setParameter("prenume", client.getPrenume());
            query.setParameter("nrMasa", client.getNrMasa());
            
            int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
            
            /*Integer clientId = (Integer) session.save(client);
            newCustomer = (Customer) session.get(Customer.class, clientId);
            */    
          transaction.commit();
          
        } catch (Exception e) {
            e.printStackTrace();
        }
       // return newCustomer;
		
	}
	
	/**
	 * Metoda asta face UPDATE
	 */
	
	public void updateCustomer(Customer client) {
		Session session = null;
		Transaction transaction = null;
        try {
            session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery("UPDATE CUSTOMER set nume = :nume, prenume = :prenume, "
            								+ "nr_masa = :nrMasa WHERE id = :id");
            query.setParameter("nume", client.getNume());
            query.setParameter("prenume", client.getPrenume());
            query.setParameter("nrMasa", client.getNrMasa());
            query.setParameter("id", client.getId());           
            int result = query.executeUpdate();
            transaction.commit();
            session.flush();
			System.out.println("Rows affected: " + result);
            
            /*session.saveOrUpdate(client);
            session.flush();
            */
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }		
	}
	
	/**
	 * Metoda asta face DELETE
	 */
	
	public void removeCustomer(Customer client) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
			Query query = session.createSQLQuery("DELETE FROM CUSTOMER " +
												"WHERE id = :id");		
			query.setParameter("id", client.getId());           
			int result = query.executeUpdate();
			transaction.commit();
            session.flush();
			System.out.println("Rows affected: " + result);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	/**
	 * AFISARE
	 */
	
	public List<Customer> getCustomersByName(String nume, String prenume) {
		Session session = null;
        try {
            session = HibernateUtil.getInstance().getSession();
            Query query = session.createQuery("from Customer c where c.nume = :nume and c.prenume = :prenume");
            query.setParameter("nume", nume);
            query.setParameter("prenume", prenume);
 
            List<Customer> customers = query.list();
            if (customers != null && customers.isEmpty()) {
                return null;
            } else {
                return customers;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
		
	}
}
