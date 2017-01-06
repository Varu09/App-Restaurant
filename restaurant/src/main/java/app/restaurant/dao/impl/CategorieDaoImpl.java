package app.restaurant.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import app.restaurant.model.Categorie;
import app.restaurant.model.Produs;
import app.restaurant.util.HibernateUtil;
import app.restaurant.dao.CategorieDao;

public class CategorieDaoImpl implements CategorieDao {
		
	public List<Categorie> getCategorie() {
		
		List<Categorie> categorii = null;
		Session session = null;
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();            
            categorii = session.createCriteria(Categorie.class).list();
            transaction.commit();
        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        return categorii;
	}
	
	/**
	 * INSERT
	 */
	public void addCategorie(Categorie categorie) {
		Session session = null;
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction(); 
            
            Query query = session.createSQLQuery("INSERT INTO Categorie(denumire) "
					+ "VALUES(:denumire)");
			query.setParameter("denumire", categorie.getDenumire());
			
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			transaction.commit();
        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	/**
	 * UPDATE
	 */
	
	public void updateCategorie(Categorie categorie) {
		Session session = null;
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery("UPDATE Categorie set denumire = :denumire " +
					 "WHERE id = :id");
			query.setParameter("denumire", categorie.getDenumire());
			query.setParameter("id", categorie.getId());           
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
	 * DELETE
	 */
	public void removeCategorie(Categorie categorie) {
		Session session = null;
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery("DELETE FROM Categorie " +
					"WHERE id = :id");		
			query.setParameter("id", categorie.getId());           
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
	 * Interogare simpla
	 */
	
	public List<Object[]> simpleQuery(Categorie categorie, Produs produs) {
		Session session = null;
		Transaction transaction = null;
		List<Object[]> result = null;
		
		try {
			session = HibernateUtil.getInstance().getSession();
			Query query = session.createSQLQuery("SELECT C.denumire, P.nume "
					+ "FROM produs P "
					+ "INNER JOIN categorie C ON P.categorie_id = C.id "
					+ "WHERE P.categorie_id = :categorieId "
					+ "AND C.id = :id ");
			query.setParameter("categorieId", produs.getCategorieId());
			query.setParameter("id", categorie.getId());
			result = query.list();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return result;
	}
}
