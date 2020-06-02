package com.biz;

import java.sql.SQLException;
import java.util.List;

import com.dao.UserDaoImpl;
import com.vo.User;

public class UserBizImpl {
	private UserDaoImpl dao = new UserDaoImpl();

	/**
	 * 注册（添加）用户
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		try {
			dao.addUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 登录
	 * 
	 * @param user
	 * @return 登录成功返回true，失败返回false
	 */
	public boolean login(User user) {
		boolean b = false;
		try {
			b = dao.login(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * 获得所有用户信息
	 * 
	 * @return 返回用户集合
	 */
	public List<User> getUser() {
		List<User> list = null;
		try {
			list = dao.getUser();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 获得图片
	 * 
	 * @param uname
	 * @return 返回图片
	 */
	public byte[] getImg(String uname) {
		byte[] b = null;
		try {
			b = dao.getImg(uname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
}
