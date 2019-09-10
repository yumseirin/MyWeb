package servlet;

import java.io.IOException; 
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
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
		//
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60);
		session.setAttribute("person", p);
		//
		// Person p1 = new Person();
		// p1.setUname("aa");
		// p1.setPwd("123");
		// p1.setCall("130-0010-2577");
		// p1.setBir(new Date());
		// Person p2 = new Person();
		// p2.setUname("bb");
		// p2.setPwd("456");
		// p2.setCall("188-0223-4588");
		// p2.setBir(new Date());
		//
		// List<Person> list = new ArrayList<Person>();
		// list.add(p1);
		// list.add(p2);
		//
		// request.setAttribute("list", list);

		// Cookie c1 = new Cookie("uname", uname);
		// Cookie c2 = new Cookie("pwd", pwd);
		// c1.setMaxAge(30);
		// c2.setMaxAge(30);
		// response.addCookie(c1);
		// response.addCookie(c2);

		request.getRequestDispatcher("login/admin.jsp").forward(request,
				response);
	}

}
