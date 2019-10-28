package com.dao;

import com.mybatis.UserDaoMapperImpl;
import com.mybatis.UserDaoMapperInf;
import com.vo.User;

public class UserDaoImpl extends BaseDao implements UserDaoInf {

	public int getID(String uname) {
		UserDaoMapperInf dao = new UserDaoMapperImpl(super.getSession());
		return dao.getID(uname);
	}

	public User login(User user) {
		UserDaoMapperInf dao = new UserDaoMapperImpl(super.getSession());
		return dao.login(user);
	}

	public void zhuce(User user) {
		UserDaoMapperInf dao = new UserDaoMapperImpl(super.getSession());
		dao.zhuce(user);
	}

}
