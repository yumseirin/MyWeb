package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库连接的工具类
 * @author seirin
 * @version v2.0
 *
 */
public class DataBaseFactory {
	// 声明一个静态连接对象，即ConnectionFactory每次获得的连接对象都是同一个对象
	private static Connection conn = null;

	/**
	 * 创建数据库连接
	 * @return 返回Connection对象
	 */
	public static Connection getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "meeting",
					"meeting");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 创建PreparedStatement对象
	 * @param conn 数据库连接
	 * @param sql sql语句
	 * @return 返回PreparedStatement对象
	 */
	public static PreparedStatement getPS(Connection conn, String sql) {
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ps;
	}

	/**
	 * 执行查询获得数据
	 * @param ps PreparedStatement对象
	 * @return 返回ResultSet结果集
	 */
	public static ResultSet exceuteQuery(PreparedStatement ps) {
		ResultSet rs = null;

		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 执行更新、修改
	 * @param ps PreparedStatement对象
	 * @return int 返回更新条数
	 */
	public static int exceuteUpdate(PreparedStatement ps) {
		int len = 0;
		try {
			len = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return len;
	}

	/**
	 * 关闭连接，释放内存
	 * @param rs ResultSet对象
	 * @param ps PreparedStatement对象
	 * @param conn Connection对象
	 */
	public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 关闭连接，释放内存
	 * @param ps PreparedStatement对象
	 * @param conn Connection对象
	 */
	public static void close(PreparedStatement ps, Connection conn) {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
