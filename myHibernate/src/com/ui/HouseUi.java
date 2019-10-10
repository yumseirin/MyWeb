package com.ui;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.biz.HouseBiz;
import com.hib.HibernateSessionFactory;
import com.vo.Jiedao;
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

	@SuppressWarnings("unchecked")
	public void selectQuByIdLoad() {
		String dno = "changchun_lvyuan";
		Qu qu = biz.selectQuByIdLoad(dno);
		System.out.println(qu.getDno() + "," + qu.getName());
		Set<Jiedao> set = qu.getJiedaos();// 返回区对应的街道
		for (Jiedao j : set) {
			System.out.println(j.getSno() + "," + j.getName());
		}
		// 用load要拿完值后关闭数据库
		HibernateSessionFactory.closeSession();
	}

	public void addQuAndJiedao() {
		Qu qu = new Qu();
		qu.setDno("changchun_nanguan");
		qu.setName("南关区");

		Jiedao jiedao1 = new Jiedao();
		Jiedao jiedao2 = new Jiedao();
		Jiedao jiedao3 = new Jiedao();

		jiedao1.setSno("nan1");
		jiedao1.setName("南关路");
		jiedao1.setQu(qu);

		jiedao2.setSno("nan2");
		jiedao2.setName("南关大街");
		jiedao2.setQu(qu);

		jiedao3.setSno("nan3");
		jiedao3.setName("红旗街");
		jiedao3.setQu(qu);// 表示多个街道对应一个区

		Set<Jiedao> jiedaos = new HashSet<Jiedao>();
		jiedaos.add(jiedao1);
		jiedaos.add(jiedao2);
		jiedaos.add(jiedao3);

		biz.addQuAndJiedao(qu, jiedaos);

	}

	public static void main(String[] args) {
		// new HouseUi().addQu();
		// new HouseUi().deleteQu();
		// new HouseUi().updateQu();
		// new HouseUi().selectAllQu();
		// new HouseUi().selectQuByIdGet();
		// new HouseUi().selectQuByIdLoad();
		new HouseUi().addQuAndJiedao();
	}
}
