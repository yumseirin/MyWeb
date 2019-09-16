package service;

import java.util.List;

import vo.Department;
import dao.DepartmentDao;

public class DepartmentService {

	private DepartmentDao dao = new DepartmentDao();

	/**
	 * 向数据库中添加部门，默认状态0（正常）
	 * 
	 * @param departmentname
	 * @return int 是否添加成功，失败为-1，成功为返回更新条数
	 */
	public int addDepartment(String departmentname) {
		return dao.addDepartment(departmentname);
	}

	/**
	 * 根据部门Id删除部门，但不直接删除，置部门状态为1（不正常），使该部门不可用
	 * 
	 * @param id
	 * @return 是否删除成功，失败为-1，成功为返回更新条数
	 */
	public int deleteDepartmentById(Integer departmentid) {
		return dao.deleteDepartmentById(departmentid);
	}

	/**
	 * 根据部门Id更改部门名name
	 * 
	 * @param name
	 * @param id
	 * @return int 是否更改成功，失败为-1，成功为返回更新条数
	 */
	public int updateDepartmentById(String departmentname, Integer departmentid) {
		return dao.updateDepartmentById(departmentname, departmentid);
	}

	/**
	 * 查询所有部门信息
	 * 
	 * @return List<Department> 返回数据集合list
	 */
	public List<Department> selectAllDepartment() {
		return dao.selectAllDepartment();
	}
}
