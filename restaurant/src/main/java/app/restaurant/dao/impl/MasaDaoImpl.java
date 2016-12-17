package app.restaurant.dao.impl;

import java.awt.print.Book;
import java.text.Annotation;
import java.util.List;

import org.hibernate.Hibernate;
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

	public Masa addTable(Masa masa) {
        Session session = null;
        Transaction transaction = null;
        Masa newMasa = null;
        try {
            session = HibernateUtil.getInstance().getSession();
            transaction = session.beginTransaction();
            Integer masaId = (Integer) session.save(masa);
            newMasa = (Masa) session.get(Masa.class, masaId);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newMasa;
	}
	
	public void updateTable(Masa masa) {
		Session session = null;
        try {
            session = HibernateUtil.getInstance().getSession();
            session.saveOrUpdate(masa);
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}
}
