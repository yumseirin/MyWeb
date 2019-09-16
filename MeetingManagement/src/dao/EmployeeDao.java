package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DataBaseFactory;
import vo.Employee;

public class EmployeeDao extends DataBaseFactory {

	public Employee login(String username, String password) {
		String sql = "select * from employee where username=? and password=?";
		Connection conn = getConnection();
		;
		PreparedStatement ps = getPS(conn, sql);

		try {
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = exceuteQuery(ps);
			if (rs.next()) {
				return new Employee(rs.getInt("employeeid"), rs
						.getString("realname"), rs.getString("username"), rs
						.getString("password"), rs.getString("phone"), rs
						.getString("email"), rs.getInt("departmentid"), rs
						.getInt("status"), rs.getString("remark"), rs
						.getInt("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
