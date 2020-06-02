package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.House;
import vo.Qu;

public class HouseDaoImpl implements HouseDaoInf {
	// =========接受Dao层传来的数据库连接=========
	private SqlSession session;

	public HouseDaoImpl(SqlSession session) {
		this.session = session;
	}

	// ======================================
	public void addQu(Qu qu) {
		session.getMapper(HouseDaoInf.class).addQu(qu);
	}

	public void addHouse(House house) {
		session.getMapper(HouseDaoInf.class).addHouse(house);
	}

	public void deleteHouse(House house) {
		session.getMapper(HouseDaoInf.class).deleteHouse(house);
	}

	public void updateHouse(House house) {
		session.getMapper(HouseDaoInf.class).updateHouse(house);
	}

	public void deleteHouseById(int hid) {
		session.getMapper(HouseDaoInf.class).deleteHouseById(hid);
	}

	public List<House> selectHouse(String hname) {
		return session.getMapper(HouseDaoInf.class).selectHouse(hname);
	}

	public List<House> selectHouse2(int hid, String hname) {
		return session.getMapper(HouseDaoInf.class).selectHouse2(hid, hname);
	}

	public List<House> selectHousemohu(String hnane) {
		return session.getMapper(HouseDaoInf.class).selectHousemohu(hnane);
	}

}
