package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.PersonBiz;

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
		Person p = new Person();
		p.setUname(uname);
		p.setPwd(pwd);

		PersonBiz biz = new PersonBiz();
		boolean b = biz.login(p);

		if (b == true) {
			List<Person> list = biz.selectAllPerson();
			request.setAttribute("msg", list);
			// 请求转发
			request.getRequestDispatcher("success.jsp").forward(request,
					response);
		} else {
			request.setAttribute("msg", "用户名或密码出错，请重新登录！");
			// 请求转发
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}

	}

}
