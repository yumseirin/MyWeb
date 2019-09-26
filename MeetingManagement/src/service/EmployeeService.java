package service;

import java.util.List;

import util.CommonConstant;
import vo.Employee;
import dao.EmployeeDao;

public class EmployeeService {
	private EmployeeDao dao = new EmployeeDao();
	private Employee loginedEmployee;

	/**
	 * 根据用户名密码验证登录 String STATUS4="3"; //用户名或密码错误，登录失败
	 * 
	 * @param username
	 * @param password
	 * @return int 返回员工的状态，
	 *         0表示正在审核，登录失败，1表示审核通过，登录成功，2表示审核未通过，3用户名或密码错误，登录失败，4关闭，登录失败
	 */
	public int login(String username, String password) {

		/*
		 * int flag = Integer.parseInt(CommonConstant.STATUS4);//3登录失败 Employee
		 * employee = dao.login(username, password); if (employee != null) {
		 * loginedEmployee = employee; String status =
		 * employee.getStatus().toString(); //String STATUS1="0"; //正在审核，登录失败 if
		 * (status != null && status.equals(CommonConstant.STATUS1)) { flag =
		 * Integer.parseInt(CommonConstant.STATUS1); } //String STATUS2="1";
		 * //审核通过，登录成功 if (status != null &&
		 * status.equals(CommonConstant.STATUS2)) { flag =
		 * Integer.parseInt(CommonConstant.STATUS2); } //String STATUS3="2";
		 * //审核未通过，登录失败 if (status != null &&
		 * status.equals(CommonConstant.STATUS3)) { flag =
		 * Integer.parseInt(CommonConstant.STATUS3); } //String STATUS5="4";
		 * //账号关闭 if (status != null && status.equals(CommonConstant.STATUS5)) {
		 * flag = Integer.parseInt(CommonConstant.STATUS5); } } return flag;
		 */
		int flag = Integer.parseInt(CommonConstant.STATUS4);// 3登录失败
		Employee employee = dao.login(username, password);
		if (employee == null) {
			return flag;
		} else {
			this.loginedEmployee = employee;
			return employee.getStatus();
		}
	}

	/**
	 * 获得登录员工的信息
	 * 
	 * @return Employee 返回登录员工的信息
	 */
	public Employee getLoginedEmployee() {
		return loginedEmployee;
	}

	/**
	 * 注册 String STATUS1="0"; //正在审核 String ROLEEMPLOYEE="2"; //员工
	 * 
	 * @param employee
	 * @return int 返回-1用户名被占用注册失败，返回0不明原因注册失败，返回大于0注册成功
	 */
	public int register(Employee employee) {
		return dao.register(employee);
	}

	/**
	 * 判断数据库中是否有该用户名（用户名是否可用）
	 * 
	 * @param username
	 * @return boolean
	 */
	public boolean isUsernameExists(String username) {
		return dao.isUsernameExists(username);
	}

	/**
	 * 根据员工Id查询员工信息（仅查询审核通过的员工） String STATUS2="1"; //审核通过
	 * 
	 * @param employeeid
	 * @return Employee 返回员工信息
	 */
	public Employee selectEmployeeById(int employeeid) {
		return dao.selectEmployeeById(employeeid);
	}

	/**
	 * 根据员工Id更改员工状态status
	 * 0表示正在审核，登录失败，1表示审核通过，登录成功，2表示审核未通过，3用户名或密码错误，登录失败，4关闭，登录失败
	 * 
	 * @param status
	 * @param employeeid
	 * @return int 是否更改成功，失败为-1，成功为返回更新条数1
	 */
	public int updateEmpStatusById(int status, int employeeid) {
		return dao.updateEmpStatusById(status, employeeid);
	}

	/**
	 * 查询所有未审核员工 String STATUS1="0"; //正在审核 String ROLEEMPLOYEE="2"; //员工
	 * 
	 * @return List<Employee> 返回所有未审核员工集合
	 */
	public List<Employee> selectUnApprovedAccount() {
		return dao.selectUnApprovedAccount();
	}

	/**
	 * 获得根据员工状态status或者与员工姓名realname用户名username查找出数据的总条数 String
	 * ROLEEMPLOYEE="2"; //员工
	 * 
	 * @param realname
	 * @param username
	 * @param status
	 * @return 查询成功，返回查询条数，不成功返回-1
	 */
	public int selectRowCount(String realname, String username, int status) {
		return dao.selectRowCount(realname, username, status);
	}

	/**
	 * 根据员工状态status或者与员工姓名realname用户名username分页查询数据
	 * 
	 * @param realname
	 * @param username
	 * @param status
	 * @param startrow
	 * @param endrow
	 * @return List<Employee>返回当前页的员工的集合
	 */
	public List<Employee> searchEmp(String realname, String username,
			int status, int startrow, int endrow) {
		return dao.searchEmp(realname, username, status, startrow, endrow);
	}

	/**
	 * 根据部门Id查找员工
	 * 
	 * @param departmentid
	 * @return List<Employee>员工集合，不成功返回null
	 */
	public List<Employee> selectEmployeesOfDept(int departmentid) {
		return dao.selectEmployeesOfDept(departmentid);
	}

	/**
	 * 获得根据员工姓名realname用户名username查找或者查找全部数据的总条数
	 * 
	 * @param realname
	 * @param username
	 * @return 查询成功，返回查询条数，不成功返回-1
	 */
	public int selectAllRowCount(String realname, String username) {
		return dao.selectAllRowCount(realname, username);
	}

	/**
	 * 根据员工姓名realname用户名username分页查询数据或者分页查询所有数据
	 * 
	 * @param realname
	 * @param username
	 * @param startrow
	 * @param endrow
	 * @return List<Employee>返回当前页的员工的集合
	 */
	public List<Employee> searchAllEmp(String realname, String username,
			int startrow, int endrow) {
		return dao.searchAllEmp(realname, username, startrow, endrow);
	}
}
