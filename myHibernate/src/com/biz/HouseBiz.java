package com.biz;

import java.util.List;
import java.util.Set;

import com.dao.HouseDao;
import com.vo.Jiedao;
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

	public List<Qu> selectAllQu() {
		return dao.selectAllQu();
	}

	public Qu selectQuByIdGet(String dno) {
		return dao.selectQuByIdGet(dno);
	}

	public Qu selectQuByIdLoad(String dno) {
		return dao.selectQuByIdLoad(dno);
	}

	public void addQuAndJiedao(Qu qu, Set<Jiedao> jiedaos) {
		dao.addQuAndJiedao(qu, jiedaos);
	}
}
