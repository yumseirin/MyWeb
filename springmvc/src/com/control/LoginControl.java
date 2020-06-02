package com.control;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.UserBizImpl;
import com.vo.User;

@Controller
@RequestMapping("loginControl")
public class LoginControl {
	private UserBizImpl biz = new UserBizImpl();

	/**
	 * 登录
	 * 
	 * @param user
	 * @param model
	 * @param session
	 * @return 成功"index"，失败"forward:/login.jsp"
	 */
	@RequestMapping("login")
	public String login(User user, Model model, HttpSession session) {
		if (biz.login(user)) {
			session.setAttribute("user", user);
			List<User> list = biz.getUser();
			model.addAttribute("list", list);
			return "index";
		} else {
			model.addAttribute("msg", "登录失败！");
			return "forward:/login.jsp";
		}
	}

	/**
	 * 退出
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/logOff")
	public String logOff(HttpSession session) {
		session.invalidate();
		return "redirect:/login.jsp";
	}

	@ResponseBody
	@RequestMapping("img")
	public byte[] getImg(String uname) {
		return biz.getImg(uname);
	}
}
