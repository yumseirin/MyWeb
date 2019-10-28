package com.service;

import com.dao.UserDaoImpl;
import com.dao.UserDaoInf;
import com.vo.User;

public class UserServiceImpl implements UserServiceInf {

	UserDaoInf dao = new UserDaoImpl();

	public int getID(String uname) {
		return dao.getID(uname);
	}

	public User login(User user) {
		return dao.login(user);
	}

	public void zhuce(User user) {
		dao.zhuce(user);
	}

}
