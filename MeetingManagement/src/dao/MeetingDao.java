package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import util.CommonConstant;
import util.DataBaseFactory;
import vo.Meeting;
import vo.MeetingRoom;
import vo.MyMeeting;

public class MeetingDao extends DataBaseFactory {

	/**
	 * 根据查找出数据的总条数
	 * 
	 * @param meetingname
	 *            会议名称
	 * @param roomname
	 *            会议室名称
	 * @param reservername
	 *            会议预定人
	 * @param reservefromdate
	 *            预定日期范围起
	 * @param reservetodate
	 *            预定日期范围止
	 * @param meetingfromdate
	 *            会议日期起
	 * @param meetingtodate
	 *            会议日期止
	 * @return 返回数据总数，失败返回-1
	 */
	public int getCount(String meetingname, String roomname,
			String reservername, String reservefromdate, String reservetodate,
			String meetingfromdate, String meetingtodate) {
		StringBuffer sb = new StringBuffer(
				"SELECT count(*) FROM meeting m,employee e,meetingroom mr WHERE m.roomid=mr.roomid AND m.reserveuserid=e.employeeid");
		if (meetingname != null && !"".equals(meetingname)) {
			sb.append(" and meetingname=?");
		}
		if (roomname != null && !"".equals(roomname)) {
			sb.append(" and roomname=?");
		}
		if (reservername != null && !"".equals(reservername)) {
			sb.append(" and realname=?");
		}
		if (reservefromdate != null && !"".equals(reservefromdate)
				&& reservetodate != null && !"".equals(reservetodate)) {
			sb.append(" and reservetime > ? and reservetime<?");
		}
		if (meetingfromdate != null && !"".equals(meetingfromdate)
				&& meetingtodate != null && !"".equals(meetingtodate)) {
			sb.append(" and meetingstarttime>? and meetingendtime<?");
		}
		String sql = sb.toString();
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = null;
		try {
			int index = 1;
			if (meetingname != null && !"".equals(meetingname)) {
				ps.setString(index++, meetingname);
			}
			if (roomname != null && !"".equals(roomname)) {
				ps.setString(index++, roomname);
			}
			if (reservername != null && !"".equals(reservername)) {
				ps.setString(index++, reservername);
			}
			if (reservefromdate != null && !"".equals(reservefromdate)
					&& reservetodate != null && !"".equals(reservetodate)) {
				ps.setTimestamp(index++, Timestamp.valueOf(reservefromdate));
				ps.setTimestamp(index++, Timestamp.valueOf(reservetodate));
			}
			if (meetingfromdate != null && !"".equals(meetingfromdate)
					&& meetingtodate != null && !"".equals(meetingtodate)) {
				ps.setTimestamp(index++, Timestamp.valueOf(meetingfromdate));
				ps.setTimestamp(index++, Timestamp.valueOf(meetingtodate));
			}
			rs = executeQuery(ps);
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return -1;
	}

	/**
	 * 查询会议
	 * 
	 * @param meetingname
	 * @param roomname
	 * @param reservername
	 * @param reservefromdate
	 * @param reservetodate
	 * @param meetingfromdate
	 * @param meetingtodate
	 * @param startrow
	 * @param endrow
	 * @return List<Meeting>
	 */
	public List<Meeting> searchMeeting(String meetingname, String roomname,
			String reservername, String reservefromdate, String reservetodate,
			String meetingfromdate, String meetingtodate, int startrow,
			int endrow) {

		StringBuffer sb = new StringBuffer(
				"select * from ("
						+ " select rownum rn,tb.* from ("
						+ "SELECT m.*,e.realname AS realname,mr.roomname AS roomname FROM meeting m,employee e,meetingroom mr WHERE m.roomid=mr.roomid AND m.reserveuserid=e.employeeid");
		if (meetingname != null && !"".equals(meetingname)) {
			sb.append(" and meetingname=?");
		}
		if (roomname != null && !"".equals(roomname)) {
			sb.append(" and roomname=?");
		}
		if (reservername != null && !"".equals(reservername)) {
			sb.append(" and realname=?");
		}
		if (reservefromdate != null && !"".equals(reservefromdate)
				&& reservetodate != null && !"".equals(reservetodate)) {
			sb.append(" and reservetime > ? and reservetime<?");
		}
		if (meetingfromdate != null && !"".equals(meetingfromdate)
				&& meetingtodate != null && !"".equals(meetingtodate)) {
			sb.append(" and meetingstarttime>? and meetingendtime<?");
		}
		sb.append(" order by meetingid )tb )a where rn between ? and ?");
		String sql = sb.toString();
		List<Meeting> list = new ArrayList<Meeting>();
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = null;
		try {
			int index = 1;
			if (meetingname != null && !"".equals(meetingname)) {
				ps.setString(index++, meetingname);
			}
			if (roomname != null && !"".equals(roomname)) {
				ps.setString(index++, roomname);
			}
			if (reservername != null && !"".equals(reservername)) {
				ps.setString(index++, reservername);
			}
			if (reservefromdate != null && !"".equals(reservefromdate)
					&& reservetodate != null && !"".equals(reservetodate)) {
				ps.setTimestamp(index++, Timestamp.valueOf(reservefromdate));
				ps.setTimestamp(index++, Timestamp.valueOf(reservetodate));
			}
			if (meetingfromdate != null && !"".equals(meetingfromdate)
					&& meetingtodate != null && !"".equals(meetingtodate)) {
				ps.setTimestamp(index++, Timestamp.valueOf(meetingfromdate));
				ps.setTimestamp(index++, Timestamp.valueOf(meetingtodate));
			}
			ps.setInt(index++, startrow);
			ps.setInt(index++, endrow);
			rs = ps.executeQuery();
			while (rs.next()) {
				int meetingid = rs.getInt("meetingid");
				String meetingname1 = rs.getString("meetingname");
				int roomid = rs.getInt("roomid");
				int reserveuserid = rs.getInt("reserveuserid");
				int meetingpersonnum = rs.getInt("meetingpersonnum");
				Timestamp meetingstarttime = rs
						.getTimestamp("meetingstarttime");
				Timestamp meetingendtime = rs.getTimestamp("meetingendtime");
				Timestamp reservetime = rs.getTimestamp("reservetime");
				Timestamp canceledtime = rs.getTimestamp("canceledtime");
				String meetingremark = rs.getString("meetingremark");
				int meetingstatus = rs.getInt("meetingstatus");
				String realname = rs.getString("realname");
				String roomname1 = rs.getString("roomname");
				Meeting meeting = new Meeting(meetingid, meetingname1,
						meetingpersonnum, meetingstarttime, meetingendtime,
						reservetime, roomid, meetingremark, reserveuserid,
						meetingstatus, canceledtime, roomname1, realname);
				list.add(meeting);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}

	/**
	 * 根据开始时间和结束时间，查询出适合我的会议室
	 * 
	 * @param meetingpersonnum
	 *            参会人数
	 * @param meetingstarttime
	 *            开始时间
	 * @param meetingendtime
	 *            结束时间
	 * @return list 会议室对象list
	 */
	public List<MeetingRoom> selectMeetingRoomsByTime(int meetingpersonnum,
			Timestamp meetingstarttime, Timestamp meetingendtime) {
		Connection conn = getConnection();
		List<MeetingRoom> list = new ArrayList<MeetingRoom>();
		//String start = meetingstarttime.toString();
		//String end = meetingendtime.toString();
		PreparedStatement ps = null;
		ResultSet rs = null;
		MeetingRoom meetingroom = null;
		try {
			String sql = "select *  from meetingroom "
					+ "where  capacity >= ? and meetingroom.roomid not in"
					+ " (select roomid  from meeting "
					+ "where (meetingstarttime<?" // start
					+ " and meetingendtime > ?)"//end 
					+ " or (meetingstarttime> ?" // start
					+ " and meetingstarttime < ?)"//end
					+ "or(meetingendtime> ? and meetingendtime < ?"//start
					+ ") and status=?)";//end //CommonConstant.MEETINGROOMSTATUS0
			System.out.println("sql=" + sql);
			ps = getPS(conn, sql);
			ps.setInt(1, meetingpersonnum);
			ps.setTimestamp(2, meetingstarttime);
			ps.setTimestamp(3, meetingendtime);
			ps.setTimestamp(4, meetingstarttime);
			ps.setTimestamp(5, meetingendtime);
			ps.setTimestamp(6, meetingstarttime);
			ps.setTimestamp(7, meetingendtime);
			ps.setInt(8, Integer.parseInt(CommonConstant.MEETINGROOMSTATUS0));
			rs = executeQuery(ps);
			while (rs.next()) {
				meetingroom = new MeetingRoom();
				meetingroom.setRoomid(Integer.parseInt(rs.getString("roomid")));
				meetingroom.setRoomnum(rs.getString("roomnum"));
				meetingroom.setRoomname(rs.getString("roomname"));
				meetingroom.setCapacity(Integer.parseInt(rs
						.getString("capacity")));
				meetingroom.setStatus(Integer.parseInt(rs.getString("status")));
				meetingroom.setRemark(rs.getString("remark"));

				list.add(meetingroom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}

	// /**
	// * 未来7天的会议
	// *
	// * @param empid
	// * @return
	// */
	// public List<Meeting> getMeeting7Days(int empid) {
	// String sql =
	// "SELECT m.*,mr.`roomname` AS roomname FROM meeting m,meetingroom mr WHERE meetingid IN(SELECT meetingid FROM meetingparticipants WHERE employeeid=?) AND m.`roomid`=mr.`roomid` AND starttime<? AND starttime>?";
	// List<Meeting> list = new ArrayList<Meeting>();
	// Connection conn = getConnection();
	// PreparedStatement ps = getPS(conn, sql);
	// ResultSet rs = null;
	// try {
	// ps.setInt(1, empid);
	// ps.setTimestamp(2, new Timestamp(System.currentTimeMillis() + 7
	// * 24 * 60 * 60 * 1000));
	// ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
	// rs = ps.executeQuery();
	// while (rs.next()) {
	// int meetingid = rs.getInt("meetingid");
	// String meetingname1 = rs.getString("meetingname");
	// int roomid = rs.getInt("roomid");
	// int reservationistid = rs.getInt("reservationistid");
	// int numberofparticipants = rs.getInt("numberofparticipants");
	// Timestamp starttime = rs.getTimestamp("starttime");
	// Timestamp endtime = rs.getTimestamp("endtime");
	// Timestamp reservationtime = rs.getTimestamp("reservationtime");
	// Timestamp canceledtime = rs.getTimestamp("canceledtime");
	// String description = rs.getString("description");
	// int status = rs.getInt("status");
	// String roomname1 = rs.getString("roomname");
	// Meeting meeting = new Meeting(meetingid, meetingname1, roomid,
	// reservationistid, numberofparticipants, starttime,
	// endtime, reservationtime, canceledtime, description,
	// status);
	// meeting.setRoomname(roomname1);
	// list.add(meeting);
	// }
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// close(rs, ps, conn);
	// }
	// return list;
	// }

	/**
	 * 查询某员工最近七天参加的所有会议
	 * 
	 * @param employeeid
	 *            员工id
	 * @return list 要参与的会议信息list
	 */
	public List<MyMeeting> selectMyNewMeeting(int employeeid) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MyMeeting> list = new ArrayList<MyMeeting>();
		MyMeeting meeting = null;
		try {
			Timestamp now = new Timestamp(System.currentTimeMillis());
			Timestamp sevenDays = new Timestamp(System.currentTimeMillis() + 7
					* 24 * 3600 * 1000);
			// 当前时间
			//String nowTime = now.toString();
			// 7天后的时间
			//String sevenDaysTime = sevenDays.toString();
			String sql = " select a.meetingname,a.meetingstarttime,a.meetingendtime,a.reservetime,b.roomname,a.meetingid,a.meetingremark,a.meetingstatus "
					+ " from meeting a,meetingroom b,meetinguser c "
					+ " where a.roomid=b.roomid and a.meetingid=c.meetingid  and c.employeeid= ? "
					//employeeid
					+ " and a.meetingstatus=? "
					//CommonConstant.MEETINGSTATUS0
					+ " and  a.meetingstarttime>? "
					//nowTime
					+ " and  a.meetingendtime< ?";//sevenDaysTime
			//System.out.println("要参加的会议sql===" + sql);
			ps = getPS(conn, sql);
			ps.setInt(1, employeeid);
			ps.setInt(2, Integer.parseInt(CommonConstant.MEETINGSTATUS0));
			ps.setTimestamp(3, now);
			ps.setTimestamp(4, sevenDays);
			rs = executeQuery(ps);
			while (rs.next()) {
				meeting = new MyMeeting();
				meeting.setMeetingname(rs.getString("meetingname"));
				meeting
						.setMeetingstarttime(rs
								.getTimestamp("meetingstarttime"));
				meeting.setMeetingendtime(rs.getTimestamp("meetingendtime"));
				meeting.setReservetime(rs.getTimestamp("reservetime"));
				meeting.setRoomname(rs.getString("roomname"));
				meeting.setMeetingid(rs.getInt("meetingid"));
				meeting.setMeetingremark(rs.getString("meetingremark"));
				meeting.setMeetingstatus(rs.getInt("meetingstatus"));
				list.add(meeting);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}

	/**
	 * 我预定的会议
	 * 
	 * @param empid
	 * @return List<MyMeeting>
	 */
	public List<MyMeeting> selectMyBookingMeeting(int empid) {
		String sql = "SELECT m.*,mr.roomname AS roomname" +
				" FROM meeting m,meetingroom mr" +
				" WHERE m.reserveuserid=?" +
				" AND m.meetingstatus=0 AND m.roomid=mr.roomid";
		List<MyMeeting> list = new ArrayList<MyMeeting>();
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = null;
		try {
			ps.setInt(1, empid);
			rs = ps.executeQuery();
			while (rs.next()) {
				int meetingid = rs.getInt("meetingid");
				String meetingname = rs.getString("meetingname");
				int roomid = rs.getInt("roomid");
				int reserveuserid = rs.getInt("reserveuserid");
				int meetingpersonnum = rs.getInt("meetingpersonnum");
				Timestamp meetingstarttime = rs
						.getTimestamp("meetingstarttime");
				Timestamp meetingendtime = rs.getTimestamp("meetingendtime");
				Timestamp reservetime = rs.getTimestamp("reservetime");
				Timestamp canceledtime = rs.getTimestamp("canceledtime");
				String meetingremark = rs.getString("meetingremark");
				int meetingstatus = rs.getInt("meetingstatus");
				String roomname = rs.getString("roomname");
				MyMeeting meeting = new MyMeeting(meetingid, meetingname,
						meetingpersonnum, meetingstarttime, meetingendtime,
						reservetime, roomid, meetingremark, reserveuserid,
						meetingstatus, roomname, canceledtime);
				list.add(meeting);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}

	// /**
	// * 根据员工Id查询已取消的会议
	// *
	// * @param empid
	// * @return
	// */
	// public List<Meeting> selectCanceledMeeting(int empid) {
	// String sql =
	// "SELECT m.*,mr.`roomname` AS roomname FROM meeting m,meetingroom mr WHERE meetingid IN(SELECT meetingid FROM meetingparticipants WHERE employeeid=?) AND m.`roomid`=mr.`roomid` AND m.status=1";
	// List<Meeting> list = new ArrayList<Meeting>();
	// Connection conn = getConnection();
	// PreparedStatement ps = getPS(conn, sql);
	// ResultSet rs = null;
	// try {
	// ps.setInt(1, empid);
	// rs = ps.executeQuery();
	// while (rs.next()) {
	// int meetingid = rs.getInt("meetingid");
	// String meetingname1 = rs.getString("meetingname");
	// int roomid = rs.getInt("roomid");
	// int reservationistid = rs.getInt("reservationistid");
	// int numberofparticipants = rs.getInt("numberofparticipants");
	// Timestamp starttime = rs.getTimestamp("starttime");
	// Timestamp endtime = rs.getTimestamp("endtime");
	// Timestamp reservationtime = rs.getTimestamp("reservationtime");
	// Timestamp canceledtime = rs.getTimestamp("canceledtime");
	// String description = rs.getString("description");
	// int status = rs.getInt("status");
	// String roomname1 = rs.getString("roomname");
	// String canceledreason = rs.getString("canceledreason");
	// Meeting meeting = new Meeting(meetingid, meetingname1, roomid,
	// reservationistid, numberofparticipants, starttime,
	// endtime, reservationtime, canceledtime, description,
	// status);
	// meeting.setCanceledreason(canceledreason);
	// meeting.setRoomname(roomname1);
	// list.add(meeting);
	// }
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// close(rs, ps, conn);
	// }
	// return list;
	// }

	/**
	 * 查询某员工查询某员工被要求参加，但是又取消的会议
	 * 
	 * @param employeeid
	 *            员工id
	 * @return list 要参与的会议信息list
	 */
	public List<MyMeeting> selectMycanceledMeeting(int employeeid) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MyMeeting> list = new ArrayList<MyMeeting>();
		MyMeeting meeting = null;
		try {

			Timestamp now = new Timestamp(System.currentTimeMillis());
			//Timestamp sevenDays = new Timestamp(System.currentTimeMillis() + 7
			//					* 24 * 3600 * 1000);

			// 当前时间
			//String nowTime = now.toString();

			String sql = " select a.meetingname,a.meetingstarttime,a.meetingendtime,a.reservetime,b.roomname,a.meetingid,a.meetingremark,a.meetingstatus,a.canceledreason "
					+ " from meeting a,meetingroom b,meetinguser c "
					+ " where a.roomid=b.roomid and a.meetingid=c.meetingid  and c.employeeid= ? "
					//+ employeeid
					+ " and a.meetingstatus= ? "
					//+ CommonConstant.MEETINGSTATUS1
					+ " and  a.meetingstarttime>? ";
					//+ nowTime + "'";
					//+ "' and a.meetingstarttime < '" + sevenDays

			//System.out.println("取消的会议sql===" + sql);
			ps = getPS(conn, sql);
			ps.setInt(1, employeeid);
			ps.setInt(2, Integer.parseInt(CommonConstant.MEETINGSTATUS1));
			ps.setTimestamp(3, now);
			rs = executeQuery(ps);
			while (rs.next()) {
				meeting = new MyMeeting();
				meeting.setMeetingname(rs.getString("meetingname"));
				meeting
						.setMeetingstarttime(rs
								.getTimestamp("meetingstarttime"));
				meeting.setMeetingendtime(rs.getTimestamp("meetingendtime"));
				meeting.setReservetime(rs.getTimestamp("reservetime"));
				meeting.setRoomname(rs.getString("roomname"));
				meeting.setMeetingid(rs.getInt("meetingid"));
				meeting.setMeetingremark(rs.getString("meetingremark"));
				meeting.setMeetingstatus(rs.getInt("meetingstatus"));
				meeting.setCanceledreason(rs.getString("canceledreason"));
				list.add(meeting);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}

	/**
	 * 根据员工Id查询我的会议
	 * 
	 * @param empid
	 * @return List<MyMeeting>
	 */
	public List<MyMeeting> selectMyMeeting(int empid) {
		String sql = "SELECT m.*,e.realname,mr.roomname FROM"
				+ " meeting m,employee e,meetingroom mr WHERE m.meetingid "
				+ " IN(SELECT mu.meetingid FROM meetinguser mu WHERE mu.employeeid=?)"
				+ " AND m.roomid=mr.roomid AND m.reserveuserid =e.employeeid and m.meetingstatus=0"
				+ " AND m.meetingstarttime >?";
		List<MyMeeting> list = new ArrayList<MyMeeting>();
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = null;
		try {
			ps.setInt(1, empid);
			ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			rs = executeQuery(ps);
			while (rs.next()) {
				int meetingid = rs.getInt("meetingid");
				String meetingname = rs.getString("meetingname");
				int roomid = rs.getInt("roomid");
				int reserveuserid = rs.getInt("reserveuserid");
				int meetingpersonnum = rs.getInt("meetingpersonnum");
				Timestamp meetingstarttime = rs
						.getTimestamp("meetingstarttime");
				Timestamp meetingendtime = rs.getTimestamp("meetingendtime");
				Timestamp reservetime = rs.getTimestamp("reservetime");
				Timestamp canceledtime = rs.getTimestamp("canceledtime");
				String meetingremark = rs.getString("meetingremark");
				int meetingstatus = rs.getInt("meetingstatus");
				String roomname = rs.getString("roomname");
				String realname = rs.getString("realname");
				String canceledreason = rs.getString("canceledreason");
				MyMeeting meeting = new MyMeeting(meetingid, meetingname,
						meetingpersonnum, meetingstarttime, meetingendtime,
						reservetime, roomid, meetingremark, reserveuserid,
						meetingstatus, roomname, realname, canceledtime,
						canceledreason);
				list.add(meeting);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}

	/**
	 * 添加一条会议记录 String MEETINGSTATUS0="0"; //正常
	 * 
	 * @param meeting
	 * @return 返回值为插入会议的id，失败返回-1
	 */
	public int addMeeting(Meeting meeting) {
		String sql = "insert into meeting "
				+ " (meetingid,meetingname,meetingpersonnum,meetingstarttime,meetingendtime,reservetime,roomid,meetingremark,reserveuserid,meetingstatus   ) values "
				+ " (seq_meetingid.nextval,?,?,?,?,?,?,?,?,?)";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = null;
		try {
			ps.setString(1, meeting.getMeetingname());
			ps.setInt(2, meeting.getMeetingpersonnum());
			ps.setTimestamp(3, meeting.getMeetingstarttime());
			ps.setTimestamp(4, meeting.getMeetingendtime());
			ps.setTimestamp(5, meeting.getReservetime());
			ps.setInt(6, meeting.getRoomid());
			ps.setString(7, meeting.getMeetingremark());
			ps.setInt(8, meeting.getReserveuserid());
			ps.setInt(9, Integer.parseInt(CommonConstant.MEETINGSTATUS0));
			int i = ps.executeUpdate();
			if (i != 0) {
				return getMeetingidByAdd(conn, rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return -1;
	}

	/**
	 * 获得当前插入后的meetingid
	 * 
	 * @param conn
	 * @param rs
	 * @return 成功返回meetingid，不成功返回-1
	 * @throws SQLException
	 */
	public int getMeetingidByAdd(Connection conn, ResultSet rs)
			throws SQLException {
		String sql = "select seq_meetingid.currval from dual";
		PreparedStatement ps = getPS(conn, sql);
		rs = executeQuery(ps);
		if (rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}

	/**
	 * 根据会议Id查询会议信息
	 * 
	 * @param mid
	 * @return Meeting
	 */
	public Meeting selectMeetingById(int mid) {
		String sql = "select * from meeting where meetingid=?";
		Meeting meeting = null;
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = null;
		try {
			ps.setInt(1, mid);
			rs = ps.executeQuery();
			if (rs.next()) {
				int meetingid = rs.getInt("meetingid");
				String meetingname = rs.getString("meetingname");
				int meetingpersonnum = rs.getInt("meetingpersonnum");
				Timestamp meetingstarttime = rs
						.getTimestamp("meetingstarttime");
				Timestamp meetingendtime = rs.getTimestamp("meetingendtime");
				Timestamp reservetime = rs.getTimestamp("reservetime");
				int roomid = rs.getInt("roomid");
				String meetingremark = rs.getString("meetingremark");
				int reserveuserid = rs.getInt("reserveuserid");
				int meetingstatus = rs.getInt("meetingstatus");
				Timestamp canceledtime = rs.getTimestamp("canceledtime");
				meeting = new Meeting(meetingid, meetingname, meetingpersonnum,
						meetingstarttime, meetingendtime, reservetime, roomid,
						meetingremark, reserveuserid, meetingstatus,
						canceledtime);
				return meeting;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return null;
	}

	/**
	 * 取消会议，更改会议状态，取消时间，取消原因 String MEETINGSTATUS1="1"; //撤销
	 * 
	 * @param meetingid
	 * @param reason
	 * @return 成功返回1，不成功返回-1
	 */
	public int cancelMeeting(int meetingid, String reason) {
		String sql = "update meeting  set meetingstatus=?,canceledtime=?,canceledreason=? where meetingid=?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		try {
			ps.setInt(1, Integer.parseInt(CommonConstant.MEETINGSTATUS1));
			ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			ps.setString(3, reason);
			ps.setInt(4, meetingid);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}
		return -1;
	}
}
