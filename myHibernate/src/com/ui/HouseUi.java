package com.ui;

import com.biz.HouseBiz;
import com.vo.Qu;

public class HouseUi {

	private HouseBiz biz = new HouseBiz();

	public void addQu() {
		Qu qu = new Qu();
		qu.setDno("changchun_chaoyang");
		qu.setName("朝阳区");

		biz.addQu(qu);
	}

	public static void main(String[] args) {
		new HouseUi().addQu();
	}
}
