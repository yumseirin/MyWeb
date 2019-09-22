package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DepartmentService;
import vo.Department;

@SuppressWarnings("serial")
public class DepartmentsServlet extends HttpServlet {
	private DepartmentService departmentService = new DepartmentService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Department> list = departmentService.selectAllUsableDepartment();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/employeeManagement/departments.jsp")
				.forward(request, response);
	}

}
