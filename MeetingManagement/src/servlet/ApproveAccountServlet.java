package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;
import vo.Employee;
/**
 * 获得未审批的用户
 * @author seirin
 *
 */
@SuppressWarnings("serial")
public class ApproveAccountServlet extends HttpServlet {
	private EmployeeService employeeService = new EmployeeService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Employee> list = employeeService.selectUnApprovedAccount();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/employeeManagement/approveaccount.jsp").forward(request,
				response);
	}

}
