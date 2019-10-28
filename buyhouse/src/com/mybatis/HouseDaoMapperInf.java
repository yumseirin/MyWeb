package com.mybatis;

import java.util.List;

import com.vo.House;
import com.vo.Orderdetail;
import com.vo.Orders;

public interface HouseDaoMapperInf {
	void saveHouse(House house);

	List<House> listHouse();

	House getHouseImg(int id);

	void saveOrders(Orders orders);

	void saveOrderdetail(Orderdetail orderdetail);

	void setStatus(int id);

	int getCountTiao();

	List<House> getHousePage(int start, int end);
}
