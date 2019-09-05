package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DataBaseFactory;
import vo.Person;

public class PersonDao extends DataBaseFactory {

	/**
	 * 通过用户名密码向数据库中查询数据是否存在
	 * 
	 * @param p
	 * @param conn
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean login(Person p, Connection conn) throws SQLException {
		String sql = "select * from person where uname=? and pwd=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, p.getUname());
		ps.setString(2, p.getPwd());
		ResultSet rs = ps.executeQuery();
		boolean b = rs.next();
		return b;
	}

	/**
	 * 向数据库中添加数据
	 * 
	 * @param p
	 * @param conn
	 * @return int
	 * @throws SQLException
	 */
	public int addPerson(Person p, Connection conn) throws SQLException {
		String sql = "insert into person values(seq_personid.nextval,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, p.getUname());
		ps.setString(2, p.getPwd());
		ps.setString(3, p.getSex());
		ps.setString(4, p.getLikes());
		ps.setDate(5, new Date(p.getBir().getTime()));
		ps.setString(6, p.getPicname());
		int count = ps.executeUpdate();
		return count;
	}

	/**
	 * 查询数据库中所有数据
	 * 
	 * @param conn
	 * @return List<Person>
	 * @throws SQLException
	 */
	public List<Person> selectAllPerson(Connection conn) throws SQLException {
		List<Person> list = new ArrayList<Person>();
		String sql = "select * from person order by pid";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Person p = new Person();
			p.setPid(rs.getInt("pid"));
			p.setUname(rs.getString("uname"));
			p.setPwd(rs.getString("pwd"));
			p.setSex(rs.getString("sex"));
			p.setLikes(rs.getString("likes"));
			p.setBir((java.util.Date) rs.getDate("bir"));
			p.setPicname(rs.getString("picname"));
			list.add(p);
		}
		return list;
	}

	/**
	 * 根据pid查询 该用户信息
	 * 
	 * @param conn
	 * @param p
	 * @return Person
	 * @throws SQLException
	 */
	public Person selectPersonByPid(Person p, Connection conn)
			throws SQLException {
		Person person = new Person();
		String sql = "select * from person where pid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, p.getPid());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			person.setPid(rs.getInt("pid"));
			person.setUname(rs.getString("uname"));
			person.setPwd(rs.getString("pwd"));
			person.setSex(rs.getString("sex"));
			person.setLikes(rs.getString("likes"));
			person.setBir((java.util.Date) rs.getDate("bir"));
			person.setPicname(rs.getString("picname"));
		}
		return person;
	}

	/**
	 * 根据pid更改用户信息
	 * 
	 * @param conn
	 * @param p
	 * @return int
	 * @throws SQLException
	 */
	public int updatePerson(Person p, Connection conn) throws SQLException {
		String sql = "update person set uname=?,pwd=?,sex=?,likes=?,bir=?,picname=? where pid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, p.getUname());
		ps.setString(2, p.getPwd());
		ps.setString(3, p.getSex());
		ps.setString(4, p.getLikes());
		ps.setDate(5, new Date(p.getBir().getTime()));
		ps.setString(6, p.getPicname());
		ps.setInt(7, p.getPid());
		int count = ps.executeUpdate();
		return count;
	}

	/**
	 * 根据pid删除用户信息
	 * 
	 * @param p
	 * @param conn
	 * @return int
	 * @throws SQLException
	 */
	public int deletePerson(Person p, Connection conn) throws SQLException {
		String sql = "delete from person where pid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, p.getPid());
		int count = ps.executeUpdate();
		return count;
	}

	/**
	 * 查询数据库中的总条数
	 * 
	 * @param conn
	 * @return int
	 * @throws SQLException
	 */
	public int selectZongtiao(Connection conn) throws SQLException {
		String sql = "select count(*) from person";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		return count;
	}

	/**
	 * 根据开始条数，结束条数分页查询
	 * 
	 * @param starttiao
	 * @param endtiao
	 * @param conn
	 * @return List<Person>
	 * @throws SQLException
	 */
	public List<Person> selectPersonByFenYe(int starttiao, int endtiao,
			Connection conn) throws SQLException {
		List<Person> list = new ArrayList<Person>();
		String sql = "select * from" + " (select tb.*,rownum rn"
				+ " from(select *from person order by pid)tb)a"
				+ " where rn>=? and rn<=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, starttiao);
		ps.setInt(2, endtiao);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Person p = new Person();
			p.setPid(rs.getInt("pid"));
			p.setUname(rs.getString("uname"));
			p.setPwd(rs.getString("pwd"));
			p.setSex(rs.getString("sex"));
			p.setLikes(rs.getString("likes"));
			p.setBir((java.util.Date) rs.getDate("bir"));
			p.setPicname(rs.getString("picname"));
			list.add(p);
		}
		return list;
	}
}
