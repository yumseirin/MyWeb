package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Person;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");

		// ================验证成功后，才把用户的信息放在会话============

		Person p = new Person();
		p.setUname(uname);
		p.setPwd(pwd);

		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(5);
		session.setAttribute("person", p);

		request.getRequestDispatcher("login/admin.jsp").forward(request,
				response);
	}

}
