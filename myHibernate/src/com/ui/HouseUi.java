package com.ui;

import java.util.List;

import com.biz.HouseBiz;
import com.hib.HibernateSessionFactory;
import com.vo.Qu;

public class HouseUi {

	private HouseBiz biz = new HouseBiz();

	public void addQu() {
		Qu qu = new Qu();
		// qu.setDno("changchun_chaoyang");
		// qu.setName("朝阳区");

		qu.setDno("changchun_lvyuan");
		qu.setName("绿园区");

		biz.addQu(qu);
	}

	public void deleteQu() {
		Qu qu = new Qu();
		qu.setDno("changchun_lvyuan");
		biz.deleteQu(qu);
	}

	public void updateQu() {
		Qu qu = new Qu();
		qu.setDno("changchun_lvyuan");
		qu.setName("新绿园区");
		biz.updateQu(qu);
	}

	public void selectAllQu() {
		List<Qu> quList = biz.selectAllQu();
		for (Qu qu : quList) {
			System.out.println(qu.getDno() + "," + qu.getName());
		}
	}

	public void selectQuByIdGet() {
		String dno = "changchun_lvyuan";
		Qu qu = biz.selectQuByIdGet(dno);
		System.out.println(qu.getDno() + "," + qu.getName());
	}

	public void selectQuByIdLoad() {
		String dno = "changchun_lvyuan";
		Qu qu = biz.selectQuByIdLoad(dno);
		System.out.println(qu.getDno() + "," + qu.getName());
		// 用load要拿完值后关闭数据库
		HibernateSessionFactory.closeSession();
	}

	public static void main(String[] args) {
		// new HouseUi().addQu();
		// new HouseUi().deleteQu();
		// new HouseUi().updateQu();
		// new HouseUi().selectAllQu();
		// new HouseUi().selectQuByIdGet();
		// new HouseUi().selectQuByIdLoad();
	}
}
