package app.restaurant.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import app.restaurant.dao.ComandaDao;
import app.restaurant.model.Comanda;
import app.restaurant.model.IstoricComenzi;
import app.restaurant.util.HibernateUtil;

public class ComandaDaoImpl implements ComandaDao {
	
	/**
	 * AFISARE
	 */
	public List<Comanda> getComenzi() {
		
		List<Comanda> comenzi = null;
		Session session = null;
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            comenzi = session.createCriteria(Comanda.class).list();
            transaction.commit();
        	
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        return comenzi;
	}
	
	/**
	 * INSERT
	 */
	
	public void addComanda(Comanda comanda) {
		Session session = null;
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery("INSERT INTO Comanda(customer_id, data) "
												+ "VALUES(:clientId, :data)");
            
            query.setParameter("clientId",comanda.getClientId());
            query.setParameter("data",comanda.getData());
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
	
	public void updateComanda(Comanda comanda){
		Session session = null;
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery("UPDATE Comanda SET data = :data " +
					 "WHERE id = :id");
            query.setParameter("id", comanda.getId());
            query.setParameter("data",comanda.getData());
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
	public void removeComanda(Comanda comanda){
		Session session = null;
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery("DELETE FROM Comanda " +
					"WHERE id = :id");
            query.setParameter("id", comanda.getId());
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
	public List<Object[]> simpleQuery(Comanda comanda, IstoricComenzi istoric) {
		
		Session session = null;
		Transaction transaction = null;
		List<Object[]> result = null;
		
		try {
			session = HibernateUtil.getInstance().getSession();
			
			Query query = session.createSQLQuery("SELECT A.data "
					+ "FROM comanda A "
					+ "INNER JOIN istoric_comenzi B ON A.id = B.comanda_id "
					+ "WHERE A.id = :id "
					+ "AND B.comanda_id = :comandaId");
			
			query.setParameter("id", comanda.getId());
			query.setParameter("comandaId", istoric.getComandaId());
			result = query.list();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return result;
	}
}
