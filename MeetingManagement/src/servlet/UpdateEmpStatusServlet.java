package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;

@SuppressWarnings("serial")
public class UpdateEmpStatusServlet extends HttpServlet {
	private EmployeeService employeeService = new EmployeeService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status = request.getParameter("status");
		String empid = request.getParameter("empid");
		int i = employeeService.updateEmpStatusById(Integer.parseInt(status),
				Integer.parseInt(empid));
		if (i == 1) {
			response.sendRedirect(request.getContextPath() + "/ApproveAccountServlet");
		} else {
			request.setAttribute("error", "审批失败");
			request.getRequestDispatcher("/ApproveAccountServlet").forward(request,
					response);
		}
	}

}
