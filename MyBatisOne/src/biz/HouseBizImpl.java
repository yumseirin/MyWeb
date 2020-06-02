package biz;

import java.util.List;

import dao.HouseDao;
import vo.House;
import vo.Qu;

public class HouseBizImpl implements HouseBizInf {

	private HouseDao dao = new HouseDao();

	public void addQuAndHouse(Qu qu, List<House> list) {
		try {
			dao.addQu(qu);
			for (House house : list) {
				dao.addHouse(house);
				// int x = 10 / 0;
			}
			dao.commit();
			System.out.println("区和房屋添加成功！");
		} catch (Exception e) {
			dao.rollback();
			System.out.println("回滚");
			e.printStackTrace();
		}
	}

	public void addHouse(House house) {
		try {
			dao.addHouse(house);
			dao.commit();
		} catch (Exception e) {
			dao.rollback();
			System.out.println("回滚");
			e.printStackTrace();
		}

	}

	public void deleteHouse(House house) {
		dao.deleteHouse(house);
	}

	public void deleteHouseById(int hid) {
		dao.deleteHouseById(hid);
	}

	public void updateHouse(House house) {
		dao.updateHouse(house);
	}

	public List<House> selectHouse(String hname) {
		return dao.selectHouse(hname);
	}

	public List<House> selectHousemohu(String hnane) {
		return dao.selectHousemohu(hnane);
	}

	public List<House> selectHouse2(int hid, String hname) {
		return dao.selectHouse2(hid, hname);
	}

}
