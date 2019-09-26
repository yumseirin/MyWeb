package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DataBaseFactory;

public class MeetingUserDao extends DataBaseFactory {
	/**
	 * 将数据添加到会议参与人表中
	 * 
	 * @param meetingid
	 *            会议id
	 * @param empids
	 *            参会人员工Id集合
	 * @return int 成功返回1，不成功返回-1
	 */
	public int addMeetingUser(int meetingid, String[] empids) {
		String sql = "insert into meetinguser (meetinguserid,meetingid,employeeid) values (seq_meetinguserid.nextval,?,?)";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		try {
			for (String empid : empids) {
				ps.setInt(1, meetingid);
				ps.setInt(2, Integer.parseInt(empid));
				ps.addBatch();// 把这条执行语句加到PreparedStatement对象的批处理命令中
			}
			ps.executeBatch();// 批量执行此列表中的命令
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}
		return -1;
	}
}
