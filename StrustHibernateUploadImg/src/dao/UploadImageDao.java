package dao;

import hib.HibernateSessionFactory;

import org.hibernate.Session;

import vo.Tu;

public class UploadImageDao {
	// 存图片
	public void saveImg(Tu tu) {

		Session session = HibernateSessionFactory.getSession();

		try {
			// 向库中添加信息
			session.save(tu);
			session.flush();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
