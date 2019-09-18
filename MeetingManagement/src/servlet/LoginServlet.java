package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;
import util.CommonConstant;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	private EmployeeService employeeService = new EmployeeService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int flag = employeeService.login(username, password);
		if (flag == Integer.parseInt(CommonConstant.STATUS1)) {
			//String STATUS1="0"; //正在审核，登录失败
			request.setAttribute("error", "用户待审批，请稍候");
			request.getRequestDispatcher("/login/login.jsp").forward(request,
					response);
		} else if (flag == Integer.parseInt(CommonConstant.STATUS2)) {
			//String STATUS2="1"; //审核通过，登录成功
			// 获取上下文
			ServletContext sc = this.getServletContext();
			// 从上下文中取出visitcount访问人数
			Object visitcount = sc.getAttribute("visitcount");
			if (visitcount == null) {
				visitcount = "0";
			}
			int vc = Integer.parseInt(visitcount.toString()) + 1;
			// 将访问人数visitcount放入上下文中
			sc.setAttribute("visitcount", vc);
			request.getSession().setAttribute("loginedEmployee",
					employeeService.getLoginedEmployee());
			response.sendRedirect(request.getContextPath() + "/layout/index.jsp");
		} else if (flag == Integer.parseInt(CommonConstant.STATUS3)) {
			//String STATUS3="2"; //审核未通过，登录失败
			request.setAttribute("error", "用户审批未通过，请重新注册");
			request.getRequestDispatcher("/login/login.jsp").forward(request,
					response);
		} else if (flag == Integer.parseInt(CommonConstant.STATUS4)) {
			//String STATUS4="3"; //用户名或密码错误，登录失败
			request.setAttribute("error", "用户名或者密码输入错误，请重新登录");
			request.getRequestDispatcher("/login/login.jsp").forward(request,
					response);
		} else if (flag == Integer.parseInt(CommonConstant.STATUS5)) {
			//String STATUS5="4"; //账号关闭
			request.setAttribute("error", "账号已关闭，登陆失败，请联系管理员");
			request.getRequestDispatcher("/login/login.jsp").forward(request,
					response);
		}
	}

}
