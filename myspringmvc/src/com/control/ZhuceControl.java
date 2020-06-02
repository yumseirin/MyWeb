package com.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("zhuceControl")
public class ZhuceControl {
	@RequestMapping("gotozhuce")
	public String gotozhuce(HttpServletRequest request) {
		return "zhuce";
	}
	
}
