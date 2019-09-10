package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DataBaseFactory;

public class CountsDao extends DataBaseFactory {

	public void addCounts(int count) {
		String sql = "update counts set counts=?";
		Connection conn = this.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, count);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int selectCounts() {
		int count = 0;
		String sql = "select counts from counts";
		Connection conn = this.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt("counts");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}
