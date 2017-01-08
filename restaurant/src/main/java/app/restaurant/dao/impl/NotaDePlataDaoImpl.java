package app.restaurant.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import app.restaurant.dao.NotaDePlataDao;
import app.restaurant.model.Comanda;
import app.restaurant.model.Masa;
import app.restaurant.model.NotaDePlata;
import app.restaurant.util.HibernateUtil;

public class NotaDePlataDaoImpl implements NotaDePlataDao {
	
	/**
	 * AFISARE
	 */
	public List<NotaDePlata> getChitante() {
		
		List<NotaDePlata> chitante = null;
		Session session = null;
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            chitante = session.createCriteria(NotaDePlata.class).list();
            transaction.commit();
        	
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        return chitante;
	}
	
	/**
	 * INSERT
	 */
	
	public void addNota(NotaDePlata nota) {
		Session session = null;
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery("INSERT INTO nota_de_plata(nr_masa, gramaj_total, pret_total) "
					+ "VALUES(:nrMasa, :gramajTotal, :pretTotal)");
            query.setParameter("nrMasa", nota.getNrMasa());
            query.setParameter("gramajTotal", nota.getGramajTotal());
            query.setParameter("pretTotal", nota.getPretTotal());
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
	public void updateNota(NotaDePlata nota) {
		Session session = null;
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery("UPDATE nota_de_plata SET pret_total = :pretTotal, gramaj_total = :gramajTotal "
													+ "WHERE id = :id");
            query.setParameter("gramajTotal", nota.getGramajTotal());
            query.setParameter("pretTotal", nota.getPretTotal());
            query.setParameter("id", nota.getId());
            
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
	public void removeNota(NotaDePlata nota) {
		Session session = null;
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery("DELETE FROM nota_de_plata " +
											"WHERE id = :id");
            query.setParameter("id", nota.getId());
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
	 * Interogare simpla
	 */
	public List<Object[]> simpleQuery(NotaDePlata nota, Masa masa) {
		
		Session session = null;
		Transaction transaction = null;
		List<Object[]> result = null;
		
		try {
			session = HibernateUtil.getInstance().getSession();
			
			Query query = session.createSQLQuery("SELECT A.nr_masa, A.gramaj_total, A.pret_total "
					+ "FROM nota_de_plata A "
					+ "INNER JOIN masa B ON A.nr_masa = B.id "
					+ "WHERE A.nr_masa = :nrMasa "
					+ "AND B.id = :id ");
			
			query.setParameter("nrMasa", nota.getNrMasa());
			query.setParameter("id", masa.getId());
			result = query.list();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return result;
	}
	
	/** 
	 * Interogare COMPLEXA
	 */
	public List<Object[]> complexQuery(Comanda comanda) {
		
		Session session = null;
		Transaction transaction = null;
		List<Object[]> result = null;
		
		try {
			session = HibernateUtil.getInstance().getSession();
			
			Query query = session.createSQLQuery("SELECT nr_masa, gramaj_total, pret_total "
					+ "FROM nota_de_plata "
					+ "WHERE id IN (SELECT id "
					+ 			   "FROM comanda "
					+ 			   "WHERE data = :data) ");
			
			query.setParameter("data", comanda.getData());
			result = query.list();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return result;
	}
}
