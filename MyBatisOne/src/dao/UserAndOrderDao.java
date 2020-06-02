package dao;

import mybatis.UserAndOrderDaoImpl;
import mybatis.UserAndOrderDaoInf;
import vo.Orders;

public class UserAndOrderDao extends BaseDao {
	private UserAndOrderDaoInf dao = new UserAndOrderDaoImpl(getSession());

	public Orders selectUserAndOrder(int id) {
		return dao.selectUserAndOrder(id);
	}
}
