package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.HibernateSessionFactory;
import com.vo.Qu;

public class HouseDao {
	public void addQu(Qu qu) {

		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();

		// String dno =(String) session.save(qu);
		try {
			session.save(qu);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {

			HibernateSessionFactory.closeSession();
		}

	}

}
