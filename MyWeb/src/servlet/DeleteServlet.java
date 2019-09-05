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
			// List<Person> list = biz.selectAllPerson();
			// request.setAttribute("msg", list);
			// request.getRequestDispatcher("success.jsp").forward(request,
			// response);

			// ============分页start=======================================

			int page = Integer.parseInt(request.getParameter("p"));

			// 2.如果 当前页<1 ，那么当前页=第1页

			if (page < 1) {
				page = 1;
			}

			// 3.总记录数 : select count(*) from 表名
			int zongtiao = biz.selectZongtiao();

			// 4.每页显示多少条 ： 给定一个值就可能
			int tiao = 4;

			// 5.返回总页数=（总记录数-1）/一页显示多少行+1

			int zongyeshu = (zongtiao - 1) / tiao + 1;
			// 6.如果当前页数>总页数，那么当前页=总页数
			if (page > zongyeshu) {
				page = zongyeshu;
			}

			// 7.起始条数=（当前页数-1）*每页要显示的记录数+1
			int starttiao = (page - 1) * tiao + 1;

			// 8.结束条数=起始条数+每页要显示的记录数-1
			int endtiao = starttiao + tiao - 1;

			// 分页后的数据带到页面显示
			List<Person> list = biz.selectPersonByFenYe(starttiao, endtiao);
			// ============分页end=======================================

			// 分页后数据
			request.setAttribute("msg", list);
			// 当前页
			request.setAttribute("page", page);
			// 末页
			request.setAttribute("zongyeshu", zongyeshu);
			// 请求转发
			request.getRequestDispatcher("success.jsp").forward(request,
					response);
		} else {
			response.sendRedirect("success.jsp");
		}

	}

}
