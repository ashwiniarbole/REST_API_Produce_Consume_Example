package com.scp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static SessionFactory sessionFactory = null;
	Session session;
	Transaction tr ;	
		

	public static SessionFactory getSessionFactory(){
		if(sessionFactory == null)
			sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory;
	}




	public static void resourceCleanup(Session session , Transaction tr) {
		if(session !=null){
			session.flush();
			if(tr !=null)
				tr.commit();
			session.close();
		}
	}
			
	
}


