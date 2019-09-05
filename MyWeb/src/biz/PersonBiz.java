package biz;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.PersonDao;
import vo.Person;

public class PersonBiz {
	/**
	 * 通过用户名密码向数据库中查询该用户是否存在
	 * 
	 * @param p
	 * @return boolean
	 */
	public boolean login(Person p) {
		PersonDao dao = new PersonDao();
		Connection conn = dao.getConnection();
		boolean b = false;
		try {
			b = dao.login(p, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * 调用DAO层addPerson方法，将用户信息添加数据库中
	 * 
	 * @param p
	 * @return int
	 */
	public int addPerson(Person p) {
		PersonDao dao = new PersonDao();
		Connection conn = dao.getConnection();
		int count = 0;
		try {
			count = dao.addPerson(p, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 调用DAO层selectAllPerson方法，查询所有用户的信息
	 * 
	 * @return List<Person>
	 */
	public List<Person> selectAllPerson() {
		PersonDao dao = new PersonDao();
		Connection conn = dao.getConnection();
		List<Person> list = null;
		try {
			list = dao.selectAllPerson(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 调用DAO层selectPersonByPid方法，查询某用户的信息
	 * 
	 * @param p
	 * @return Person
	 */
	public Person selectPersonByPid(Person p) {
		PersonDao dao = new PersonDao();
		Connection conn = dao.getConnection();
		Person person = null;
		try {
			person = dao.selectPersonByPid(p, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
	}

	/**
	 * 调用DAO层updatePerson方法，更改指定用户的信息
	 * 
	 * @param p
	 * @return int
	 */
	public int updatePerson(Person p) {
		int count = 0;
		PersonDao dao = new PersonDao();
		Connection conn = dao.getConnection();
		try {
			count = dao.updatePerson(p, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 调用DAO层deletePerson方法，删除指定用户的信息
	 * 
	 * @param p
	 * @return int
	 */
	public int deletePerson(Person p) {
		int count = 0;
		PersonDao dao = new PersonDao();
		Connection conn = dao.getConnection();
		try {
			count = dao.deletePerson(p, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 查询数据库中的总条数
	 * 
	 * @return int
	 */
	public int selectZongtiao() {
		int count = 0;
		PersonDao dao = new PersonDao();
		Connection conn = dao.getConnection();
		try {
			count = dao.selectZongtiao(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 根据开始条数，结束条数分页查询
	 * 
	 * @param starttiao
	 * @param endtiao
	 * @return List<Person>
	 */
	public List<Person> selectPersonByFenYe(int starttiao, int endtiao) {
		PersonDao dao = new PersonDao();
		Connection conn = dao.getConnection();
		List<Person> list = null;
		try {
			list = dao.selectPersonByFenYe(starttiao, endtiao, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
