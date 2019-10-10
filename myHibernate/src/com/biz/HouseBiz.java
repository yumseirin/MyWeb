package com.biz;

import com.dao.HouseDao;
import com.vo.Qu;

public class HouseBiz {
	private HouseDao dao = new HouseDao();

	public void addQu(Qu qu) {
		dao.addQuAutocommit(qu);
	}

	public void deleteQu(Qu qu) {
		dao.deleteQu(qu);
	}

	public void updateQu(Qu qu) {
		dao.updateQu(qu);
	}
}
