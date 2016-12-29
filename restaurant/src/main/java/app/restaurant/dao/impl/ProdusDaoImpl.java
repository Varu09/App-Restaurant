package app.restaurant.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import app.restaurant.dao.ProdusDao;
import app.restaurant.model.Produs;
import app.restaurant.util.HibernateUtil;

public class ProdusDaoImpl implements ProdusDao{
	
	/**
	 * AFISARE
	 */
	
	public List<Produs> getProduse() {
		List<Produs> produse = null;
		Session session = null;
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            produse = session.createCriteria(Produs.class).list();
            transaction.commit();
        	
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        return produse;
	}
	
	/**
	 * INSERT
	 */
	
	public void addProdus(Produs produs) {
		Session session = null;
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery("INSERT INTO Produs(categorie_id, nume, pret, gramaj) "
					+ "VALUES(:categorieId, :nume, :pret, :gramaj)");
            query.setParameter("categorieId", produs.getCategorieId());
            query.setParameter("nume", produs.getNume());
            query.setParameter("pret", produs.getPret());
            query.setParameter("gramaj", produs.getGramaj());
            int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			transaction.commit();
        	
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	/**
	 * UPDATE
	 */
	
	public void updateProdus(Produs produs) {
		
		Session session = null;	
        Transaction transaction = null;
        
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
        	Query query = session.createSQLQuery("UPDATE Produs SET pret = :pret, gramaj = :gramaj, "
        						+ "nume = :nume  WHERE id = :id");
        	query.setParameter("id", produs.getId());
        	query.setParameter("pret", produs.getPret()); 
        	query.setParameter("gramaj", produs.getGramaj());
        	query.setParameter("nume", produs.getNume());
        	
        	
        	int result = query.executeUpdate();
 			transaction.commit();
 			session.flush();
 			System.out.println("Rows affected: " + result);
 			
 			    	
        	
        	
        } catch(Exception e) {
        	e.printStackTrace();
        } finally {
        	session.close();        	
        }
	}
	
	/**
	 * DELETE
	 */
	public void removeProdus(Produs produs) {
		Session session = null;	
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery("DELETE FROM Produs " +
											"WHERE id = :id");
            query.setParameter("id", produs.getId());
            int result = query.executeUpdate();
			transaction.commit();
			session.flush();
			System.out.println("Rows affected: " + result);
        	
        } catch(Exception e) {
        	e.printStackTrace();
        } finally {
        	session.close();  
        }
	}
}
