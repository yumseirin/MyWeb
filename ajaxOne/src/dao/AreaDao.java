package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DataBaseFactory;
import vo.Area;

public class AreaDao extends DataBaseFactory {
	/**
	 * 数据库中查询省
	 * 
	 * @return
	 */
	public List<Area> getSheng() {
		List<Area> list = new ArrayList<Area>();
		String sql = "select * from area where status=1";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = executeQuery(ps);
		try {
			while (rs.next()) {
				Area a = new Area();
				a.setId(rs.getInt("id"));
				a.setName(rs.getString("name"));
				a.setStatus(rs.getInt("status"));
				a.setPid(rs.getInt("pid"));
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}

	/**
	 * 根据省在数据库中查询市
	 * 
	 * @return
	 */
	public List<Area> getShiById(int id) {
		List<Area> list = new ArrayList<Area>();
		String sql = "select * from area where status=2 and pid = ?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = null;
		try {
			ps.setInt(1, id);
			rs = executeQuery(ps);
			while (rs.next()) {
				Area a = new Area();
				a.setId(rs.getInt("id"));
				a.setName(rs.getString("name"));
				a.setStatus(rs.getInt("status"));
				a.setPid(rs.getInt("pid"));
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}

	/**
	 * 根据市在数据库中查询区
	 * 
	 * @return
	 */
	public List<Area> getQuById(int id) {
		List<Area> list = new ArrayList<Area>();
		String sql = "select * from area where status=3 and pid = ?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = null;
		try {
			ps.setInt(1, id);
			rs = executeQuery(ps);
			while (rs.next()) {
				Area a = new Area();
				a.setId(rs.getInt("id"));
				a.setName(rs.getString("name"));
				a.setStatus(rs.getInt("status"));
				a.setPid(rs.getInt("pid"));
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}
}
