package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.CommonConstant;
import util.DataBaseFactory;
import vo.Employee;

public class EmployeeDao extends DataBaseFactory {

	/**
	 * 根据用户名密码验证登录 
	 * 
	 * @param username
	 * @param password
	 * @return Employee 返回员工信息
	 *         0表示正在审核，登录失败，1表示审核通过，登录成功，2表示审核未通过，3用户名或密码错误，登录失败，4关闭，登录失败
	 */
	public Employee login(String username, String password) {
		String sql = "select * from employee where username=? and password=?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = null;
		try {
			ps.setString(1, username);
			ps.setString(2, password);
			rs = executeQuery(ps);
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
		} finally {
			close(rs, ps, conn);
		}
		return null;
	}

	/**
	 * 注册
	 * String STATUS1="0"; //正在审核 
	 * String ROLEEMPLOYEE="2"; //员工
	 * 
	 * @param employee
	 * @return int 返回-1用户名被占用注册失败，返回0不明原因注册失败，返回1注册成功
	 */
	public int register(Employee employee) {
		if (isUsernameExists(employee.getUsername())) {
			return -1;// 该用户名已被占用，注册失败
		}
		String sql = "insert into employee values (seq_employeeid.nextval,?,?,?,?,?,?,?,?,?)";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		try {
			ps.setString(1, employee.getRealname());
			ps.setString(2, employee.getUsername());
			ps.setString(3, employee.getPassword());
			ps.setString(4, employee.getPhone());
			ps.setString(5, employee.getEmail());
			ps.setInt(6, employee.getDepartmentid());
			ps.setInt(7, Integer.parseInt(CommonConstant.STATUS1));
			ps.setString(8, employee.getRemark());
			ps.setInt(9, Integer.parseInt(CommonConstant.ROLEEMPLOYEE));
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}
		return 0;// 注册失败
	}

	/**
	 * 判断数据库中是否有该用户名（用户名是否可用）
	 * 
	 * @param username
	 * @return boolean
	 */
	public boolean isUsernameExists(String username) {
		String sql = "select * from employee where username=?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = null;
		try {
			ps.setString(1, username);
			rs = executeQuery(ps);
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return false;
	}

	/**
	 * 根据员工Id查询员工信息（仅查询审核通过的员工） 
	 * String STATUS2="1"; //审核通过
	 * 
	 * @param employeeid
	 * @return Employee 返回员工信息
	 */
	public Employee selectEmployeeById(int employeeid) {
		String sql = "select * from employee where status=? and employeeid=?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = null;
		try {
			ps.setInt(1, Integer.parseInt(CommonConstant.STATUS2));
			ps.setInt(2, employeeid);
			rs = executeQuery(ps);
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
		} finally {
			close(rs, ps, conn);
		}
		return null;
	}

	/**
	 * 根据员工Id更改员工状态status
	 * 0表示正在审核，登录失败，1表示审核通过，登录成功，2表示审核未通过，3用户名或密码错误，登录失败，4关闭，登录失败
	 * 
	 * @param status
	 * @param employeeid
	 * @return int 是否更改成功，失败为-1，成功为返回更新条数
	 */
	public int updateEmpStatusById(int status, int employeeid) {
		String sql = "update employee set status=? where employeeid=?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		try {
			ps.setInt(1, status);
			ps.setInt(2, employeeid);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}
		return -1;
	}

	/**
	 * 查询所有未审核员工
	 * String STATUS1="0"; //正在审核
	 * String ROLEEMPLOYEE="2"; //员工
	 * @return List<Employee> 返回所有未审核员工集合
	 */
	public List<Employee> selectUnApprovedAccount() {
        List<Employee> list = new ArrayList<Employee>();
        String sql = "select * from employee where status=? and role =?";
        Connection conn = getConnection();
        PreparedStatement ps = getPS(conn, sql);
        ResultSet rs = null;
        try {
        	ps.setInt(1, Integer.parseInt(CommonConstant.STATUS1));
			ps.setInt(2, Integer.parseInt(CommonConstant.ROLEEMPLOYEE));
            rs = executeQuery(ps);
            while (rs.next()) {
                list.add(new Employee(rs.getInt("employeeid"), rs
						.getString("realname"), rs.getString("username"), rs
						.getString("password"), rs.getString("phone"), rs
						.getString("email"), rs.getInt("departmentid"), rs
						.getInt("status"), rs.getString("remark"), rs
						.getInt("role")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, conn);
        }
        return list;
    }
	
	/**
	 * 获得根据员工状态status或者与员工姓名realname用户名username查找出数据的总条数
	 * String ROLEEMPLOYEE="2"; //员工
	 * @param realname
	 * @param username
	 * @param status
	 * @return 查询成功，返回查询条数，不成功返回-1
	 */
	public int selectRowCount(String realname, String username, int status) {
        StringBuffer sb = new StringBuffer("select count(*) from employee where status=? and role =?");
      //如果realname不为为空或空字符串，在sql语句中加上" and realname=?"
        if (realname != null && !"".equals(realname)) {
            sb.append(" and realname=?");
        }
        //如果username不为为空或空字符串，在sql语句中加上" and username=?"
        if (username != null && !"".equals(username)) {
            sb.append(" and username=?");
        }
        String sql = sb.toString();
        Connection conn = getConnection();
        PreparedStatement ps = getPS(conn, sql);
        ResultSet rs = null;
        try {
            ps.setInt(1, status);
            ps.setInt(2, Integer.parseInt(CommonConstant.ROLEEMPLOYEE));
            int index = 3;//?的位置
            if (realname != null && !"".equals(realname)) {
                ps.setString(index++, realname);
            }
            if (username != null && !"".equals(username)) {
                ps.setString(index++, username);
            }
            rs = executeQuery(ps);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, conn);
        }
        return -1;
    }
	
	/**
	 * 根据员工状态status或者与员工姓名realname用户名username分页查询数据
	 * @param realname
	 * @param username
	 * @param status
	 * @param startrow
	 * @param endrow
	 * @return List<Employee>返回当前页的员工的集合
	 */
	public List<Employee> searchEmp(String realname, String username, int status, int startrow, int endrow) {
        List<Employee> list = new ArrayList<Employee>();
        StringBuffer sb = new StringBuffer("select * from (" +
        								   " select rownum rn,tb.* from (" +
        								   " select * from employee where status=? AND role =?");
        //如果realname不为为空或空字符串，在sql语句中加上" and realname=?"
        if (realname != null && !"".equals(realname)) {
            sb.append(" and realname=?");
        }
        //如果username不为为空或空字符串，在sql语句中加上" and username=?"
        if (username != null && !"".equals(username)) {
            sb.append(" and username=?");
        }
        sb.append(" order by employeeid )tb )a where rn between ? and ?");
        String sql = sb.toString();
        Connection conn = getConnection();
        PreparedStatement ps = getPS(conn, sql);
        ResultSet rs = null;
        try {
        	ps.setInt(1, status);
            ps.setInt(2, Integer.parseInt(CommonConstant.ROLEEMPLOYEE));
            int index = 3;//?的位置
            if (realname != null && !"".equals(realname)) {
                ps.setString(index++, realname);
            }
            if (username != null && !"".equals(username)) {
                ps.setString(index++, username);
            }
            ps.setInt(index++, startrow);
            ps.setInt(index++, endrow);  
            rs = executeQuery(ps);
            while (rs.next()) {
                list.add(new Employee(rs.getInt("employeeid"), rs
						.getString("realname"), rs.getString("username"), rs
						.getString("password"), rs.getString("phone"), rs
						.getString("email"), rs.getInt("departmentid"), rs
						.getInt("status"), rs.getString("remark"), rs
						.getInt("role")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, conn);
        }
        return list;
    }
	
	
	/**
	 * 查询所有参加该会议的员工
	 * @param meetingid
	 * @return List<Employee> 返回所有参加该会议的员工的集合
	 */
	public List<Employee> selectEmpByMeetingId(int meetingid) {
        List<Employee> list = new ArrayList<Employee>();
        String sql = "select * from employee where employeeid in(select employeeid from meetinguser where meetingid = ?)";
        Connection conn = getConnection();
        PreparedStatement ps = getPS(conn, sql);
        ResultSet rs = null;
        try {
            ps.setInt(1,meetingid);
            rs = executeQuery(ps);
            while (rs.next()) {
                list.add(new Employee(rs.getInt("employeeid"), rs
						.getString("realname"), rs.getString("username"), rs
						.getString("password"), rs.getString("phone"), rs
						.getString("email"), rs.getInt("departmentid"), rs
						.getInt("status"), rs.getString("remark"), rs
						.getInt("role")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, conn);
        }
        return list;
    }
	
	
}
