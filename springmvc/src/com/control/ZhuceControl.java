package com.control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.biz.UserBizImpl;
import com.vo.User;

@Controller
@RequestMapping("zhuceControl")
public class ZhuceControl {
	private UserBizImpl biz = new UserBizImpl();

	/**
	 * 前往注册页面
	 * 
	 * @param request
	 * @return "zhuce"
	 */
	@RequestMapping("gotozhuce")
	public String gotozhuce(HttpServletRequest request) {
		return "zhuce";
	}

	/**
	 * 注册
	 * 
	 * @param user
	 * @param pic2
	 * @param model
	 * @param likes
	 * @param session
	 * @return 成功"forward:/login.jsp"，失败"/zhuce"
	 */
	@RequestMapping(value = "zhuce", method = RequestMethod.POST)
	public String zhuce(User user, @RequestParam MultipartFile pic2,
			Model model,
			@RequestParam(value = "likes", required = false) String likes,
			HttpSession session) {
		String str = "";
		if (likes != null) {
			String like[] = likes.split(",");
			for (int i = 0; i < like.length; i++) {
				if ("eat".endsWith(like[i])) {
					like[i] = "吃 ";
				}
				if ("sleep".endsWith(like[i])) {
					like[i] = "睡 ";
				}
				if ("game".endsWith(like[i])) {
					like[i] = "打游戏 ";
				}
			}

			for (String s : like) {
				str += s;
			}
		}
		if (user != null) {
			try {
				user.setPic(pic2.getBytes());
				user.setLikes(str);
				biz.addUser(user);
				model.addAttribute("msg", "注册成功！");
				return "forward:/login.jsp";
			} catch (IOException e) {
				e.printStackTrace();
				model.addAttribute("msg", "注册失败！");
				return "/zhuce";
			}
		} else {
			model.addAttribute("msg", "注册失败！");
			return "/zhuce";
		}

	}

}
