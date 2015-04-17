package com.example.fw;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

/**
 * Hibernate Helper
 *  - to read the data about groups,contacts from database and map them to GroupData, ContactData Ojbects
 *  
 * @version 0.1
 *
 */

public class HibernateHelper extends HelperBase {

	public HibernateHelper(ApplicationManager manager) {
	  super(manager);
	}

	@SuppressWarnings("unchecked")
	public SortedListOf<GroupData> listGroups() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
          return new SortedListOf<GroupData>(
              (List<GroupData>) session.createQuery("from GroupData").list());
		} finally {
          trans.commit();
		}
	}
	
	@SuppressWarnings("unchecked")
	public SortedListOf<ContactData> listContacts() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
          return new SortedListOf<ContactData>(
              (List<ContactData>) session.createQuery("from ContactData").list());
		} finally {
          trans.commit();
		}
	}
}
