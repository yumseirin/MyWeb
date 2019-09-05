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
public class DeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String pid = request.getParameter("pid");
		Person p = new Person();
		p.setPid(Integer.parseInt(pid));

		PersonBiz biz = new PersonBiz();
		int count = biz.deletePerson(p);
		if (count != 0) {
			List<Person> list = biz.selectAllPerson();
			request.setAttribute("msg", list);
			request.getRequestDispatcher("success.jsp").forward(request,
					response);
		} else {
			response.sendRedirect("success.jsp");
		}

	}

}
