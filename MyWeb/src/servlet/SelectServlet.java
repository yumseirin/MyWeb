package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.PersonBiz;

import vo.Person;

@SuppressWarnings("serial")
public class SelectServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String pid = request.getParameter("pid");
		String page = request.getParameter("page");

		Person p = new Person();
		p.setPid(Integer.parseInt(pid));

		PersonBiz biz = new PersonBiz();
		Person person = biz.selectPersonByPid(p);

		if (person != null) {
			request.setAttribute("msg", person);
			request.setAttribute("page", page);
			// 请求转发
			request.getRequestDispatcher("update.jsp").forward(request,
					response);
		} else {
			// 响应重定向
			response.sendRedirect("error.jsp");
		}

	}

}
