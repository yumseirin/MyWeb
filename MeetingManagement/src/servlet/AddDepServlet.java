package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DepartmentService;
/**
 * 添加部门
 * @author seirin
 *
 */
@SuppressWarnings("serial")
public class AddDepServlet extends HttpServlet {
	private DepartmentService departmentService = new DepartmentService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String departmentname = request.getParameter("departmentname");
		int add = departmentService.addDepartment(departmentname);
		if (add == 1) {
			response.sendRedirect(request.getContextPath() + "/DepartmentsServlet");
		} else {
			request.setAttribute("error", "添加失败");
			request.getRequestDispatcher("/DepartmentsServlet").forward(request,
					response);
		}
	}

}
