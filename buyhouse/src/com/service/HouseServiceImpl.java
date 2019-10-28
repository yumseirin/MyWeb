package com.service;

import java.util.List;

import com.dao.HouseDaoImpl;
import com.dao.HouseDaoInf;
import com.vo.House;
import com.vo.Orderdetail;
import com.vo.Orders;

public class HouseServiceImpl implements HouseServiceInf {

	private HouseDaoInf dao = new HouseDaoImpl();

	public int getCountTiao() {
		return dao.getCountTiao();
	}

	public byte[] getHouseImg(int id) {
		return dao.getHouseImg(id);
	}

	public List<House> getHousePage(int start, int end) {
		return dao.getHousePage(start, end);
	}

	public List<House> listHouse() {
		return dao.listHouse();
	}

	public void order(Orders order, Orderdetail orderdetail) {
		HouseDaoImpl dao = new HouseDaoImpl();
		try {
			dao.saveOrders(order);
			dao.saveOrderdetail(orderdetail);
			dao.commit();
		} catch (Exception e) {
			dao.rollback();
			e.printStackTrace();
		}
	}

	public void saveHouse(House house) {
		dao.saveHouse(house);
	}

	public void setStatus(int id) {
		dao.setStatus(id);
	}

}
