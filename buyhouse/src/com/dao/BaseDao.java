package com.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseDao {
	private static SqlSessionFactory factory; // 读取mybatis.xml单例的工厂

	private SqlSession session; // 非单例，每个client都有自己的connection

	// -------------------读取mybatis.xml文件的工厂-------------------------
	// 静态工厂给静态代码块赋值
	static {
		// src目录是根目录，直接从根目录读取就可以
		String resource = "mybatis.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(inputStream); // 创建一个单例的SqlSessionFactory
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// -------------------通过工厂得到session 的二种方式-------------------------
	/**
	 *读取mybatis.xml配置文件后，利用返回值，建立与数据库的连接 session 设置为true，为自动提交模式
	 */
	public SqlSession getSession() {

		if (this.session == null) {
			if (BaseDao.factory != null) {
				session = BaseDao.factory.openSession(true);// 设置自动提交模式为true
			}
		}
		return session;

	}

	/**
	 * 默认为false，非自动提交模式
	 * 
	 * @param autocommit
	 *            当给autocommit传参为false时，就得开启事务了，要手动提交了
	 *            当给autocommit传参为true时，不用手动提交了
	 *            (手动提交需要事务管理，其实mybatis.xml配置文件已经设置JDBC的事务了)
	 * @return
	 */
	public SqlSession getSession(boolean autocommit) {
		if (this.session == null) {
			session = factory.openSession(autocommit);
		}
		return session;
	}

	// -------------------关闭session-------------------------

	public void closeSession() {
		if (this.session != null)
			session.close();
		session = null;

	}

	// --------------------事务提交-----------------------------

	public void commit() {
		if (session != null) {
			session.commit();
		}
	}

	// --------------------事务回滚-----------------------------

	public void rollback() {
		if (session != null) {
			session.rollback();
		}
	}
}
