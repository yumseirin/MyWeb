package com.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.biz.ZhuceBizInf;
import com.opensymphony.xwork2.ModelDriven;
import com.vo.Person;

@Controller("zhuceAction")
public class ZhuceAction implements ModelDriven<Person> {

	private Person person = new Person();

	public Person getModel() {

		return person;
	}

	@Autowired
	private ZhuceBizInf zhuceBizInf;

	public String zhuce() {
		zhuceBizInf.zhuce(person);
		return "success";
	}

}
