package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DataBaseFactory;

public class CountDao extends DataBaseFactory {

	/**
	 * 向数据库中传访问人数
	 * 
	 * @param count
	 */
	public void updateCount(int count) {
		String sql = "update counter set visitcount=? where counterid = 1";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		try {
			ps.setInt(1, count);
			exceuteUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}
	}

	/**
	 * 从数据库中取访问人数
	 * 
	 * @return int 访问人数count
	 */
	public int getCount() {
		int count = 0;
		String sql = "select visitcount from counter where counterid = 1";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = exceuteQuery(ps);
		try {
			if (rs.next()) {
				count = rs.getInt("visitcount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return count;
	}
}
