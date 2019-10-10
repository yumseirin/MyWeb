package com.biz;

import com.dao.HouseDao;
import com.vo.Qu;

public class HouseBiz {
	private HouseDao dao = new HouseDao();

	public void addQu(Qu qu) {
		dao.addQu(qu);
	}
}
