package dao;

import java.util.List;

import mybatis.HouseDaoImpl;
import mybatis.HouseDaoInf;
import vo.House;
import vo.Qu;

public class HouseDao extends BaseDao {

	public void addQu(Qu qu) {
		/**
		 * 为mybatis层创建对象，传递数据库连接
		 */
		HouseDaoInf manualdao = new HouseDaoImpl(getSession(false));
		manualdao.addQu(qu);
	}

	public void addHouse(House house) {
		HouseDaoInf manualdao = new HouseDaoImpl(getSession(false));
		manualdao.addHouse(house);
	}

	public void deleteHouse(House house) {
		/**
		 * 为mybatis层创建对象，传递数据库连接
		 */
		HouseDaoInf dao = new HouseDaoImpl(getSession());
		dao.deleteHouse(house);
	}

	public void deleteHouseById(int hid) {
		HouseDaoInf dao = new HouseDaoImpl(getSession());
		dao.deleteHouseById(hid);
	}

	public void updateHouse(House house) {
		HouseDaoInf dao = new HouseDaoImpl(getSession());
		dao.updateHouse(house);
	}

	public List<House> selectHouse(String hname) {
		HouseDaoInf dao = new HouseDaoImpl(getSession());
		return dao.selectHouse(hname);
	}

	public List<House> selectHouse2(int hid, String hname) {
		HouseDaoInf dao = new HouseDaoImpl(getSession());
		return dao.selectHouse2(hid, hname);
	}

	public List<House> selectHousemohu(String hnane) {
		HouseDaoInf dao = new HouseDaoImpl(getSession());
		return dao.selectHousemohu(hnane);
	}
}
