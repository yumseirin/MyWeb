package com.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.HibernateSessionFactory;
import com.vo.Jiedao;
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

	/**
	 * 删除区
	 * 
	 * @param qu
	 */
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

	/**
	 * 更改区（根据主键所有属性都更新，如果有点属性没set，那么就会为空，这是整体的更新）
	 * 
	 * @param qu
	 */
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

	/**
	 * 查询区的所有数据
	 * 
	 * @return List<Qu>
	 */
	@SuppressWarnings("unchecked")
	public List<Qu> selectAllQu() {
		List<Qu> quList = null;
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Qu";
		// String hql = "from Qu q where q.dno = 'changchun_lvyuan'";
		try {
			Query query = session.createQuery(hql);
			quList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return quList;
	}

	/**
	 * 根据dno查询区的数据（用get方法立即加载）
	 * 
	 * @param dno
	 * @return Qu
	 */
	public Qu selectQuByIdGet(String dno) {
		Session session = HibernateSessionFactory.getSession();
		Qu qu = null;
		try {
			qu = (Qu) session.get(Qu.class, dno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return qu;
	}

	/**
	 * 根据dno查询区的数据（用load方法延迟加载）
	 * 
	 * @param dno
	 * @return Qu
	 */
	public Qu selectQuByIdLoad(String dno) {
		Session session = HibernateSessionFactory.getSession();
		Qu qu = null;
		try {
			// 调用load()方法时会返回一个目标对象的代理对象，在这个代理对象中只储存了目标对象的ID值
			qu = (Qu) session.load(Qu.class, dno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qu;
	}

	/**
	 * 同时添加区和街道
	 * 
	 * @param qu
	 * @param jiedaos
	 */
	public void addQuAndJiedao(Qu qu, Set<Jiedao> jiedaos) {
		Session session = HibernateSessionFactory.getSession();
		try {
			// 添加区
			session.save(qu);
			// 添加街道
			for (Jiedao j : jiedaos) {
				session.save(j);
			}
			session.flush();// 让缓存和数据库中的数据同步
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
}
