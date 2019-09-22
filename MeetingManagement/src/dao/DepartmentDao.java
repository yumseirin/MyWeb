package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.CommonConstant;
import util.DataBaseFactory;
import vo.Department;

public class DepartmentDao extends DataBaseFactory {

	/**
	 * 向数据库中添加部门，默认状态0（正常）
	 * String DEPARTMENTSTATUS1="0"; //有效
	 * @param departmentname
	 * @return int 是否添加成功，失败为-1，成功为返回更新条数
	 */
	public int addDepartment(String departmentname) {
		String sql = "insert into department values (seq_departmentid.nextval,?,?)";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		try {
			ps.setString(1, departmentname);
			ps.setInt(2, Integer.parseInt(CommonConstant.DEPARTMENTSTATUS1));
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}
		return -1;
	}

	/**
	 * 根据部门Id删除部门，但不直接删除，置部门状态为1（不正常），使该部门不可用
	 * String DEPARTMENTSTATUS2="1"; //无效
	 * @param id
	 * @return 是否删除成功，失败为-1，成功为返回更新条数
	 */
	public int deleteDepartmentById(int departmentid) {
		String sql = "update department set departmentstatus=?  where departmentid=?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		try {
			ps.setInt(1, Integer.parseInt(CommonConstant.DEPARTMENTSTATUS2));
			ps.setInt(2, departmentid);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}
		return -1;
	}

	/**
	 * 根据部门Id更改部门名name
	 * 
	 * @param name
	 * @param id
	 * @return int 是否更改成功，失败为-1，成功为返回更新条数
	 */
	public int updateDepartmentById(String departmentname, int departmentid) {
		String sql = "update department set departmentname=? where departmentid=?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		try {
			ps.setString(1, departmentname);
			ps.setInt(2, departmentid);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}
		return -1;
	}

	/**
	 * 查询所有部门信息
	 * 
	 * @return List<Department> 返回数据集合list
	 */
	public List<Department> selectAllDepartment() {
		List<Department> list = new ArrayList<Department>();
		String sql = "select * from department";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = executeQuery(ps);
		try {
			while (rs.next()) {
				Department dep = new Department();
				dep.setDepartmentid(rs.getInt("departmentid"));
				dep.setDepartmentname(rs.getString("departmentname"));
				dep.setDepartmentstatus(rs.getInt("departmentstatus"));
				list.add(dep);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs,ps, conn);
		}
		return list;
	}
	
	/**
	 * 查询所有可用部门信息
	 * String DEPARTMENTSTATUS1="0"; //有效
	 * @return List<Department> 返回数据集合list
	 */
	public List<Department> selectAllUsableDepartment() {
		List<Department> list = new ArrayList<Department>();
		String sql = "select * from department where departmentstatus=?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		
		ResultSet rs = null;
		try {
			ps.setInt(1, Integer.parseInt(CommonConstant.DEPARTMENTSTATUS1));
			rs = executeQuery(ps);
			while (rs.next()) {
				Department dep = new Department();
				dep.setDepartmentid(rs.getInt("departmentid"));
				dep.setDepartmentname(rs.getString("departmentname"));
				dep.setDepartmentstatus(rs.getInt("departmentstatus"));
				list.add(dep);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs,ps, conn);
		}
		return list;
	}
	
	/**
	 * 根据部门Id查询该部门信息
	 * 
	 * @return Department
	 */
	public Department selectDepartmentById(int id) {
		Department dep = new Department();
		String sql = "select * from department where departmentid=?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = null;
		try {
			ps.setInt(1, id);
			rs = executeQuery(ps);
			while (rs.next()) {
				dep.setDepartmentid(rs.getInt("departmentid"));
				dep.setDepartmentname(rs.getString("departmentname"));
				dep.setDepartmentstatus(rs.getInt("departmentstatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs,ps, conn);
		}
		return dep;
	}
}
