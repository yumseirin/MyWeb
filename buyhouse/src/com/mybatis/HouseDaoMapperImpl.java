package com.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.vo.House;
import com.vo.Orderdetail;
import com.vo.Orders;

public class HouseDaoMapperImpl implements HouseDaoMapperInf {

	private SqlSession session;

	public HouseDaoMapperImpl(SqlSession session) {
		super();
		this.session = session;
	}

	public int getCountTiao() {
		return session.getMapper(HouseDaoMapperInf.class).getCountTiao();
	}

	public House getHouseImg(int id) {
		return session.getMapper(HouseDaoMapperInf.class).getHouseImg(id);
	}

	public List<House> getHousePage(int start, int end) {
		return session.getMapper(HouseDaoMapperInf.class).getHousePage(start,
				end);
	}

	public List<House> listHouse() {
		return session.getMapper(HouseDaoMapperInf.class).listHouse();
	}

	public void saveHouse(House house) {
		session.getMapper(HouseDaoMapperInf.class).saveHouse(house);
	}

	public void saveOrderdetail(Orderdetail orderdetail) {
		session.getMapper(HouseDaoMapperInf.class).saveOrderdetail(orderdetail);
	}

	public void saveOrders(Orders orders) {
		session.getMapper(HouseDaoMapperInf.class).saveOrders(orders);
	}

	public void setStatus(int id) {
		session.getMapper(HouseDaoMapperInf.class).setStatus(id);
	}

}
