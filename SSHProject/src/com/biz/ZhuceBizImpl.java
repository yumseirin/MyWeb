package com.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ZhuceDaoInf;
import com.vo.Person;

@Service("zhuceBizImpl")
public class ZhuceBizImpl implements ZhuceBizInf {
	@Autowired
	private ZhuceDaoInf zhuceDaoInf;

	public int zhuce(Person person) {
		return zhuceDaoInf.zhuce(person);
	}

}
