package com.mybatis;

import com.vo.User;

public interface UserDaoMapperInf {
	User login(User user);

	int getID(String uname);

	void zhuce(User user);
}
