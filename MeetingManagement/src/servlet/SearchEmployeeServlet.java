package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;
import util.CommonConstant;
import vo.Employee;
/**
 * 查询员工信息
 * @author seirin
 *
 */
@SuppressWarnings("serial")
public class SearchEmployeeServlet extends HttpServlet {
	private EmployeeService employeeService = new EmployeeService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 更改状态
		String updateStatus = request.getParameter("updateStatus");
		if (updateStatus != null) {
			String empid = request.getParameter("empid");
			employeeService.updateEmpStatusById(Integer.parseInt(updateStatus),
					Integer.parseInt(empid));
		}
		String realname = request.getParameter("realname");
		String username = request.getParameter("username");
		String status = request.getParameter("status");
		if (status == null || "".equals(status)) {
			status = "1";// 获取不到状态就为1
		}
		// =============================================
		// 1.当前页： 前台JSP上传过来的页数
		String spage = request.getParameter("page");
		// 2.如果 当前页<1 ，那么当前页=第1页
		if (spage == null || "".equals(spage)) {
			spage = "1";// 获取不到页数就为1
		}
		int page = Integer.parseInt(spage);
		// 3.总记录数 : select count(*) from 表名
		int totalCount = 0;
		if ("5".equals(status)) {
			totalCount = employeeService.selectAllRowCount(realname, username);
		} else {
			totalCount = employeeService.selectRowCount(realname, username,
					Integer.parseInt(status));
		}
		// 4.每页显示多少条 ： 给定一个值就可能
		int count = Integer.parseInt(CommonConstant.pagesize);
		// 5.返回总页数=（总记录数-1）/一页显示多少行+1
		int totalPage = (totalCount - 1) / count + 1;
		// 6.如果当前页数>总页数，那么当前页=总页数
		if (page > totalPage) {
			page = totalPage;
		}
		// 7.起始条数=（当前页数-1）*每页要显示的记录数+1
		int startrow = (page - 1) * count + 1;
		// 8.结束条数=起始条数+每页要显示的记录数
		int endrow = startrow + count - 1;
		// 分页后的数据带到页面显示
		// =============================================
		List<Employee> list = null;
		if ("5".equals(status)) {
			list = employeeService.searchAllEmp(realname, username, startrow,
					endrow);
		} else {
			list = employeeService.searchEmp(realname, username, Integer
					.parseInt(status), startrow, endrow);
		}
		request.setAttribute("list", list);
		request.setAttribute("totalCount", totalCount);// 总条数
		request.setAttribute("totalPage", totalPage);// 总页数
		request.setAttribute("page", page);// 第几页
		request.setAttribute("realname", realname);
		request.setAttribute("username", username);
		request.setAttribute("status", status);
		request.getRequestDispatcher("/employeeManagement/searchemployees.jsp")
				.forward(request, response);
	}

}
