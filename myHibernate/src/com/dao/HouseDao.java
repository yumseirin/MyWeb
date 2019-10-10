package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.HibernateSessionFactory;
import com.vo.Qu;

public class HouseDao {
	/**
	 * 添加区（事务手动提交）
	 * 
	 * @param qu
	 */
	public void addQu(Qu qu) {
		// 得到session，相当于得到数据库连接
		Session session = HibernateSessionFactory.getSession();
		// 开启事务
		Transaction tr = session.beginTransaction();

		// String dno =(String) session.save(qu);
		try {
			session.save(qu);// 保存
			tr.commit();// 事务提交
		} catch (Exception e) {
			tr.rollback();// 事务回滚
			e.printStackTrace();
		} finally {
			// 关闭session，关闭数据库连接
			HibernateSessionFactory.closeSession();
		}
	}

	/**
	 * 添加区（自动提交）
	 * 
	 * @param qu
	 */
	public void addQuAutocommit(Qu qu) {
		Session session = HibernateSessionFactory.getSession();
		// String dno =(String) session.save(qu);
		try {
			session.save(qu);
			session.flush();// 让缓存和数据库中的数据同步
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	public void deleteQu(Qu qu) {
		Session session = HibernateSessionFactory.getSession();

		try {
			session.delete(qu);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	public void updateQu(Qu qu) {
		Session session = HibernateSessionFactory.getSession();

		try {
			session.update(qu);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

}
