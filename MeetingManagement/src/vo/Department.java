package vo;
/**
 * 部门实体类
 * @author seirin
 *
 */
public class Department {

    private Integer departmentid;//部门id 
    private String departmentname;//部门名称
    private Integer departmentstatus;//部门状态    0 正  1 非
    
	public Integer getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public Integer getDepartmentstatus() {
		return departmentstatus;
	}
	public void setDepartmentstatus(Integer departmentstatus) {
		this.departmentstatus = departmentstatus;
	}
    
    
}
