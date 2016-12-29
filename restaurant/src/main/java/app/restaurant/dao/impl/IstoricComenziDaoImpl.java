package app.restaurant.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import app.restaurant.dao.IstoricComenziDao;
import app.restaurant.model.IstoricComenzi;
import app.restaurant.util.HibernateUtil;

public class IstoricComenziDaoImpl implements IstoricComenziDao{
	
	/**
	 * AFISARE
	 */
	
	public List<IstoricComenzi> getIstoricComenzi() {
		
		List<IstoricComenzi> istorice = null;
		Session session = null;
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            istorice = session.createCriteria(IstoricComenzi.class).list();
            transaction.commit();
        	
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        return istorice;
	}
	
	/**
	 * INSERT
	 */
	
	public void addIstoricComenzi(IstoricComenzi istoric) {
		Session session = null;
        Transaction transaction = null;
        
        try {
        	session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            
            Query query = session.createSQLQuery("INSERT INTO istoric_comenzi(comanda_id, produs_id) "
											+ "VALUES(:comandaId, :produsId)");
            query.setParameter("comandaId", istoric.getComandaId());
            query.setParameter("produsId", istoric.getProdusId());
            int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			transaction.commit();
        	
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	//public void updateIstoricComenzi(IstoricComenzi istoric) {} nu stiu daca imi trebuie neaparat
	
	
	/**
	 * DELETE
	 */
	public void removeIstoricComenzi(IstoricComenzi istoric) {
		Session session = null;
        Transaction transaction = null;
        
        try {
        	
        	session = HibernateUtil.getInstance().getSession();
        	transaction = session.beginTransaction();
        	
        	 Query query = session.createSQLQuery("DELETE FROM istoric_comenzi " +
						"WHERE id = :id");        	 
        	 query.setParameter("id",istoric.getId());
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
