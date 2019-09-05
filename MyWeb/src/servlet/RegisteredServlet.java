package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.PersonBiz;

//import util.DateUtil;
import vo.Person;

@SuppressWarnings("serial")
public class RegisteredServlet extends HttpServlet {

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
		String sex = request.getParameter("sex");
		String[] likes = request.getParameterValues("like");
		@SuppressWarnings("unused")
		String yue = request.getParameter("yue");

		Person p = new Person();
		p.setUname(uname);
		p.setPwd(pwd);
		p.setSex(sex);
		// String[]--->String
		String strs = "";
		for (String str : likes) {
			strs += str + ",";
		}
		p.setLikes(strs);
		// String--->Date
		// p.setYue(DateUtil.stringToDate(yue));

		PersonBiz biz = new PersonBiz();
		int count = biz.addPerson(p);

		if (count != 0) {// 成功
			List<Person> list = biz.selectAllPerson();
			request.setAttribute("msg", list);
			// 请求转发
			request.getRequestDispatcher("success.jsp").forward(request,
					response);
		} else {
			// 响应定向
			response.sendRedirect("register.jsp");
		}

	}

}