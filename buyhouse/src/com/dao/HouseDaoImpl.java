package com.dao;

import java.util.List;

import com.mybatis.HouseDaoMapperImpl;
import com.mybatis.HouseDaoMapperInf;
import com.vo.House;
import com.vo.Orderdetail;
import com.vo.Orders;

public class HouseDaoImpl extends BaseDao implements HouseDaoInf {

	public int getCountTiao() {
		HouseDaoMapperInf dao = new HouseDaoMapperImpl(super.getSession());
		return dao.getCountTiao();
	}

	public byte[] getHouseImg(int id) {
		HouseDaoMapperInf dao = new HouseDaoMapperImpl(super.getSession());
		House house = dao.getHouseImg(id);
		return house.getPic();
	}

	public List<House> getHousePage(int start, int end) {
		HouseDaoMapperInf dao = new HouseDaoMapperImpl(super.getSession());
		return dao.getHousePage(start, end);
	}

	public List<House> listHouse() {
		HouseDaoMapperInf dao = new HouseDaoMapperImpl(super.getSession());
		return dao.listHouse();
	}

	public void saveHouse(House house) {
		HouseDaoMapperInf dao = new HouseDaoMapperImpl(super.getSession());
		dao.saveHouse(house);
	}

	public void saveOrderdetail(Orderdetail orderdetail) {
		HouseDaoMapperInf dao = new HouseDaoMapperImpl(super.getSession(false));
		dao.saveOrderdetail(orderdetail);
	}

	public void saveOrders(Orders order) {
		HouseDaoMapperInf dao = new HouseDaoMapperImpl(super.getSession(false));
		dao.saveOrders(order);
	}

	public void setStatus(int id) {
		HouseDaoMapperInf dao = new HouseDaoMapperImpl(super.getSession());
		dao.setStatus(id);
	}

}
