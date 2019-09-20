package service;

import java.util.List;

import dao.AreaDao;

import vo.Area;

public class AreaService {
	private AreaDao dao = new AreaDao();

	public List<Area> getSheng() {
		return dao.getSheng();
	}

	public List<Area> getShiById(int id) {
		return dao.getShiById(id);
	}

	public List<Area> getQuById(int id) {
		return dao.getQuById(id);
	}
}
