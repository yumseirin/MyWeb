package mybatis;

import java.util.List;

import vo.House;
import vo.Qu;

public interface HouseDaoInf {

	public void addQu(Qu qu);

	public void addHouse(House house);

	public void deleteHouse(House house);

	public void deleteHouseById(int hid);

	public void updateHouse(House house);

	public List<House> selectHouse(String hname);

	public List<House> selectHouse2(int hid, String hname);

	public List<House> selectHousemohu(String hnane);
}
