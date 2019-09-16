package vo;

import java.util.List;
/**
 * 控制分页实体类
 * @author seirin
 *
 */
public class Page {
	private int pageSize; // 每页显示多少条记录
	private int pageNow; // 默认显示第几页
	private int pageCount; // 一共有多少页
	private int rowCount; // 一共多少条记录
	private List<Employee> list; // 员工list

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}

}
