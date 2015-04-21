package com.example.fw;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hibernate Helper
 *  - to read, modify the data from database and map them to Data Ojbects
 *  
 * @version 0.1
 *
 */

public class HibernateHelper extends HelperBase {

	public HibernateHelper(ApplicationManager manager) {
	  super(manager);
	}


	public void deleteUser(User user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		String hql = "Delete from User where username= :username";
		try {
			Query query = session.createQuery(hql);
			query.setString("username", user.getLogin());
			query.executeUpdate();
			trans.commit();
		} catch (Throwable t) {
			trans.rollback();
			throw t;
		}
	}
	
}
