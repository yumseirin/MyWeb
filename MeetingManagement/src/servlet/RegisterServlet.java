package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;
import vo.Employee;
/**
 * 注册
 * @author seirin
 *
 */
@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
	private EmployeeService employeeService = new EmployeeService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String realname = request.getParameter("realname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String departmentid = request.getParameter("departmentid");
		Employee emp = new Employee();
		emp.setRealname(realname);
		emp.setUsername(username);
		emp.setPassword(password);
		emp.setPhone(phone);
		emp.setEmail(email);
		emp.setDepartmentid(Integer.parseInt(departmentid));
		int reg = employeeService.register(emp);
		if (reg == 1) {
			// 注册成功，跳转到登录页面
			response.sendRedirect(request.getContextPath() + "/login/login.jsp");
		} else if (reg == -1) {
			// 用户名重复，注册失败
			request.setAttribute("error", "用户名重复，注册失败");
			request.getRequestDispatcher("/login/register.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "不明原因，注册失败");
			request.getRequestDispatcher("/login/register.jsp").forward(request, response);
		}
	}

}
