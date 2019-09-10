package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DateUtil;
import vo.Person;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.setCharacterEncoding("utf-8");// 设置编码为utf-8
		// response.setContentType("text/html;charset=utf-8");

		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String bir = request.getParameter("bir");
		String call = request.getParameter("call");

		System.out.println(uname);
		System.out.println(pwd);
		System.out.println(bir);
		System.out.println(call);

		Person p = new Person();
		p.setUname(uname);
		p.setPwd(pwd);
		p.setBir(DateUtil.stringToDate(bir));
		p.setCall(call);
		// //========试验品，显示用，假数据==========
		Person p2 = new Person();
		p2.setUname("abc");
		p2.setPwd("123");
		p2.setBir(DateUtil.stringToDate(bir));
		p2.setCall("188-8888-5948");
		Person p3 = new Person();
		p3.setUname("def");
		p3.setPwd("456");
		p3.setBir(DateUtil.stringToDate(bir));
		p3.setCall("166-6666-5266");

		List<Person> list = new ArrayList<Person>();
		list.add(p);
		list.add(p2);
		list.add(p3);

		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		session.setAttribute("person", p);
		session.setMaxInactiveInterval(100);// 秒

		Cookie cookie1 = new Cookie("uname", URLEncoder.encode(p.getUname(),
				"UTF-8"));
		Cookie cookie2 = new Cookie("pwd", p.getPwd());
		Cookie cookie3 = new Cookie("bir", bir);
		Cookie cookie4 = new Cookie("call", p.getCall());

		cookie1.setMaxAge(60);
		cookie2.setMaxAge(60);
		cookie3.setMaxAge(60);
		cookie4.setMaxAge(60);// 秒

		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		response.addCookie(cookie4);

		// =============上下文计数===================
		ServletContext sc = this.getServletContext();
		// 有没有count
		Object obj = sc.getAttribute("count");
		if (obj == null) {
			// 没有
			sc.setAttribute("count", 1);
		} else {
			// 有
			int count = Integer.parseInt(obj.toString());
			count++;
			sc.setAttribute("count", count);
		}

		request.getRequestDispatcher("one/index.jsp")
				.forward(request, response);
	}

}
