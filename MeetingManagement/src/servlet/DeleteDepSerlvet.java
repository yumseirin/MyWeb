package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DepartmentService;

@SuppressWarnings("serial")
public class DeleteDepSerlvet extends HttpServlet {
	private DepartmentService departmentService = new DepartmentService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String depid = request.getParameter("depid");
		int i = departmentService.deleteDepartmentById(Integer.parseInt(depid));
		if (i == 1) {
			response.sendRedirect(request.getContextPath() + "/DepartmentsServlet");
		} else {
			request.setAttribute("error", "删除失败");
			request.getRequestDispatcher("/DepartmentsServlet").forward(request,
					response);
		}
	}

}
