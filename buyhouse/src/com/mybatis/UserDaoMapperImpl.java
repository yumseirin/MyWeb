package com.mybatis;

import org.apache.ibatis.session.SqlSession;

import com.vo.User;

public class UserDaoMapperImpl implements UserDaoMapperInf {

	private SqlSession session;

	public UserDaoMapperImpl(SqlSession session) {
		super();
		this.session = session;
	}

	public int getID(String uname) {
		return session.getMapper(UserDaoMapperInf.class).getID(uname);
	}

	public User login(User user) {
		return session.getMapper(UserDaoMapperInf.class).login(user);
	}

	public void zhuce(User user) {
		session.getMapper(UserDaoMapperInf.class).zhuce(user);
	}

}
