package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vo.User;

public class UserDaoImpl extends DataBaseFactory {

	/**
	 * 注册（添加）用户
	 * 
	 * @param user
	 * @throws SQLException
	 */
	public void addUser(User user) throws SQLException {
		Connection conn = getConnection();
		String sql = "insert into suser(uname,pwd,likes,pic) values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getPwd());
		ps.setString(3, user.getLikes());
		ps.setBytes(4, user.getPic());
		ps.executeUpdate();
	}

	/**
	 * 登录
	 * 
	 * @param user
	 * @return 登录成功返回true，失败返回false
	 * @throws SQLException
	 */
	public boolean login(User user) throws SQLException {
		boolean b = false;
		Connection conn = getConnection();
		String sql = "select * from suser where uname = ? and pwd = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getPwd());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			b = true;
		}
		return b;
	}

	/**
	 * 获得所有用户信息
	 * 
	 * @return 返回用户集合
	 * @throws SQLException
	 */
	public List<User> getUser() throws SQLException {
		Connection conn = getConnection();
		String sql = "select uname,pwd,likes,pic from suser";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<User> list = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setUname(rs.getString("uname"));
			user.setPwd(rs.getString("pwd"));
			user.setLikes(rs.getString("likes"));
			user.setPic(rs.getBytes("pic"));
			list.add(user);
		}
		return list;
	}

	/**
	 * 获得图片
	 * 
	 * @param uname
	 * @return 返回图片
	 * @throws SQLException
	 */
	public byte[] getImg(String uname) throws SQLException {
		Connection conn = getConnection();
		String sql = "select pic from suser where uname = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uname);
		ResultSet rs = ps.executeQuery();
		byte[] b = null;
		while (rs.next()) {
			b = rs.getBytes("pic");
		}
		return b;
	}
}
