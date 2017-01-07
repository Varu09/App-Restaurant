package app.restaurant.dao.impl;

import java.awt.print.Book;
import java.text.Annotation;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import app.restaurant.dao.MasaDao;
import app.restaurant.model.Masa;
import app.restaurant.util.HibernateUtil;

public class MasaDaoImpl implements MasaDao{
	
	public List<Masa> getTables() {
		List<Masa> mese = null;		
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
    		mese = session.createCriteria(Masa.class).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return mese;
	}

	/**
	 * INSERT
	 */
	
	public void addTable(Masa masa) {
        Session session = null;
        Transaction transaction = null;
       // Masa newMasa = null;
        try {
            session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery("INSERT INTO Masa(nr_locuri) "
            										+ "VALUES(:nrLocuri)");
           
            query.setParameter("nrLocuri", masa.getNrLocuri());
            
            int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
            
            /*
            Integer masaId = (Integer) session.save(masa);
            newMasa = (Masa) session.get(Masa.class, masaId);
            */
            
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
       // return newMasa;
	}
	
	/**
	 * UPDATE
	 */
	
	public void updateTable(Masa masa) {
		Session session = null;
		Transaction transaction = null;
		
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery("UPDATE Masa SET nr_locuri = :nrLocuri " +
					 "WHERE id = :id");
			query.setParameter("nrLocuri", masa.getNrLocuri());
			query.setParameter("id", masa.getId());           
			int result = query.executeUpdate();
			transaction.commit();
			session.flush();
			System.out.println("Rows affected: " + result);
            
            
            /*
            session.saveOrUpdate(masa);
            session.flush();
            */
            
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}
	
	/** 
	 * DELETE
	 */
	public void removeTable(Masa masa) {
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery("DELETE FROM Masa " +
					"WHERE id = :id");		
			query.setParameter("id", masa.getId());           
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
	 * Interogare COMPLEXA
	 */
	
	public List<Object[]> complexQuery(Masa masa) {
		Session session = null;
		Transaction transaction = null;
		List<Object[]> result = null;
		
		try {
			session = HibernateUtil.getInstance().getSession();
			
			Query query = session.createSQLQuery("SELECT M.id, P.nume, P.gramaj "
					+ "FROM masa M "
					+ "INNER JOIN customer C ON C.nr_masa = M.id "
					+ "INNER JOIN comanda CM ON C.id = CM.customer_id "
					+ "INNER JOIN istoric_comenzi IC ON CM.id = IC.comanda_id "
					+ "INNER JOIN  produs P ON IC.produs_id = P.id "
					+ "WHERE M.id = :id ");
			
			query.setParameter("id", masa.getId());
			result = query.list();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return result;
	}
}
