package ui;

import java.util.ArrayList;
import java.util.List;

import biz.HouseBizImpl;
import biz.HouseBizInf;
import vo.House;
import vo.Qu;

public class HouseUI {
	private HouseBizInf biz = new HouseBizImpl();

	public void addQuAndHouse() {
		Qu qu = new Qu();
		qu.setId(4);
		qu.setName("夜尽小区");

		House h1 = new House();
		h1.setHname("1栋");
		h1.setQid(qu.getId());

		House h2 = new House();
		h2.setHname("2栋");
		h2.setQid(qu.getId());

		List<House> list = new ArrayList<House>();
		list.add(h1);
		list.add(h2);

		biz.addQuAndHouse(qu, list);
	}

	public void addHouse() {
		House house = new House();
		// house.setHid(3);
		house.setHname("精品房");
		biz.addHouse(house);
	}

	public void deleteHouse() {
		House house = new House();
		house.setHid(11);
		// biz.deleteHouse(house);
		biz.deleteHouseById(house.getHid());
	}

	public void updateHouse() {
		House house = new House();
		house.setHid(3);
		house.setHname("海景房");
		biz.updateHouse(house);
	}

	public void selectHouse() {
		List<House> list = biz.selectHouse("精品房");
		for (House house : list) {
			System.out.println(house.getHid() + "," + house.getHname());
		}
	}

	public void selectHouse2() {
		List<House> list = biz.selectHouse2(5, "精品房");
		for (House house : list) {
			System.out.println(house.getHid() + "," + house.getHname());
		}
	}

	public void selectHousemohu() {
		List<House> list = biz.selectHousemohu("%精%");
		for (House house : list) {
			System.out.println(house.getHid() + "," + house.getHname());
		}
	}

	public static void main(String[] args) {
		HouseUI ui = new HouseUI();
		// ui.addHouse();
		// ui.deleteHouse();
		// ui.updateHouse();
		// ui.selectHouse();
		// ui.selectHousemohu();
		// ui.selectHouse2();
		 ui.addQuAndHouse();
	}
}
