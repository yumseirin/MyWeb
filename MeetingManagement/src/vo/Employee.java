package vo;

/**
 * 员工实体类
 * 
 * @author seirin
 * 
 */
public class Employee {
	private Integer employeeid; // 员工id
	private String realname; // 员工真实姓名
	private String username; // 用户名
	private String password; // 密码
	private String phone; // 联系电话
	private String email; // 电子邮箱
	private Integer departmentid; // 所属部门
	private Integer status; // status表示员工的状态，0表示正在审核，1表示审核通过，2表示审核未通过，默认为正在审核
	private String remark; // 备注
	private Integer role; // role表示员工的角色，1表示为管理员，2表示为员工,默认为员工

	public Employee() {
		super();
	}

	public Employee(Integer employeeid, String realname, String username,
			String password, String phone, String email, Integer departmentid,
			Integer status, String remark, Integer role) {
		super();
		this.employeeid = employeeid;
		this.realname = realname;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.departmentid = departmentid;
		this.status = status;
		this.remark = remark;
		this.role = role;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

}
