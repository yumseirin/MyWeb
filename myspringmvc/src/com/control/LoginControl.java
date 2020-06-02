package com.control;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vo.User;

@Controller
@RequestMapping("loginControl")
public class LoginControl {
	@RequestMapping("login")
	public String login(HttpServletRequest request) {
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");

		return "index";
	}

	@RequestMapping(value = "login2", method = RequestMethod.POST)
	public String login2(String uname, String pwd, HttpServletRequest request) {
		System.out.println(uname + "," + pwd);
		return "forward:/login4.action";
	}

	@RequestMapping(value = "login3")
	public String login2(User user, Model model,
			@RequestParam(value = "like", required = false) String like,
			HttpSession session) {
		System.out.println(like);
		model.addAttribute("msg", "holle:");
		// ===session======================
		session.setAttribute("user", user);

		// ==========上下文=====
		ServletContext sc = session.getServletContext();
		sc.setAttribute("count", 10);

		return "index";
		// return "redirect:/login.jsp";
	}

}
