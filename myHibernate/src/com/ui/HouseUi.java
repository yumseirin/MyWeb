package com.ui;

import com.biz.HouseBiz;
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

	public static void main(String[] args) {
		// new HouseUi().addQu();
		// new HouseUi().deleteQu();
		new HouseUi().updateQu();
	}
}
