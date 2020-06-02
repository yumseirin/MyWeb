package mybatis;

import org.apache.ibatis.session.SqlSession;

import vo.Orders;

public class UserAndOrderDaoImpl implements UserAndOrderDaoInf {

	// =========接受Dao层传来的数据库连接=========
	private SqlSession session;

	public UserAndOrderDaoImpl(SqlSession session) {
		this.session = session;
	}

	// ======================================

	@Override
	public Orders selectUserAndOrder(int id) {
		return session.getMapper(UserAndOrderDaoInf.class).selectUserAndOrder(
				id);
	}

}
