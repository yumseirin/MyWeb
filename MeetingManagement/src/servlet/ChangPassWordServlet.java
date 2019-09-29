package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EmployeeService;
import vo.Employee;

@SuppressWarnings("serial")
public class ChangPassWordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("loginedEmployee");
		int employeeid = employee.getEmployeeid();
		String password = employee.getPassword();
		// System.out.println("123456!!!" + employeeid);
		// System.out.println(password);
		String originpassword = request.getParameter("origin");

		if (password.equals(originpassword)) {

			String newpassword = request.getParameter("new");

			EmployeeService service = new EmployeeService();
			int count = service.updatPasswordByID(employeeid, newpassword);
			if (count != 0) {
				response.sendRedirect(request.getContextPath()
						+ "/login/login.jsp");
			} else {
				request.setAttribute("error", "修改失败");
				request.getRequestDispatcher(
						"/personalCenter/changepassword.jsp").forward(request,
						response);
			}
		}else {
			request.setAttribute("error", "原密码错误");
			request.getRequestDispatcher(
					"/personalCenter/changepassword.jsp").forward(request,
					response);
		}
	}

}
