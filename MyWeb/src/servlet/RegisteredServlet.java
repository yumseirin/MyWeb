package servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import biz.PersonBiz;

//import util.DateUtil;
import util.DateUtil;
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
		// ===========附件的URL==================================================
		String path = this.getServletContext().getRealPath("\\img\\");

		MultipartRequest res = new MultipartRequest(request, path,
				50 * 1024 * 1024, "utf-8");
		// 得到request里的表单控件
		Enumeration er = res.getFileNames();
		String filename = "";
		while (er.hasMoreElements()) {
			// 上传文件文本框的名字
			String kuangname = (String) er.nextElement();
			// 获得图片的名字
			filename = res.getFilesystemName(kuangname);
		}

		String uname = res.getParameter("uname");
		String pwd = res.getParameter("pwd");
		String sex = res.getParameter("sex");
		String[] likes = res.getParameterValues("like");
		String bir = res.getParameter("bir");

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
		p.setBir(DateUtil.stringToDate(bir));
		p.setPicname(filename);

		PersonBiz biz = new PersonBiz();
		int count = biz.addPerson(p);

		if (count != 0) {// 成功
			// 注册成功后直接进入不需重新登录
			List<Person> list = biz.selectAllPerson();
			request.setAttribute("msg", list);
			request.setAttribute("tu", filename);
			// 请求转发
			request.getRequestDispatcher("success.jsp").forward(request,
					response);

			// //注册成功后返回登录
			// response.sendRedirect("login.jsp");

			// // 注册成功后返回登录，并提示请登录
			// request.setAttribute("msg", "请登录！");
			// request.getRequestDispatcher("login.jsp")
			// .forward(request, response);

		} else {
			// 响应定向
			response.sendRedirect("register.jsp");
		}

	}

}
