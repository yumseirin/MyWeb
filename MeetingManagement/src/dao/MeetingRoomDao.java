package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DataBaseFactory;
import vo.MeetingRoom;

public class MeetingRoomDao extends DataBaseFactory {
	/**
	 * 查询所有会议室
	 * 
	 * @return List<MeetingRoom> 返回所有会议室信息
	 */
	public List<MeetingRoom> selectAllMeetingRoom() {
		List<MeetingRoom> list = new ArrayList<MeetingRoom>();
		String sql = "select * from meetingroom order by roomid";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = executeQuery(ps);
		try {
			while (rs.next()) {
				MeetingRoom meetingRoom = new MeetingRoom(rs.getInt("roomid"),
						rs.getString("roomnum"), rs.getString("roomname"), rs
								.getInt("capacity"), rs.getInt("status"), rs
								.getString("remark"));
				list.add(meetingRoom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return list;
	}

	/**
	 * 根据会议室Id查询会议室信息
	 * 
	 * @param id
	 * @return MeetingRoom 返回会议室信息
	 */
	public MeetingRoom selectMeetingRoomById(int id) {
		String sql = "select * from meetingroom WHERE roomid=?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = null;
		try {
			ps.setInt(1, id);
			rs = executeQuery(ps);
			while (rs.next()) {
				MeetingRoom meetingRoom = new MeetingRoom(rs.getInt("roomid"),
						rs.getString("roomnum"), rs.getString("roomname"), rs
								.getInt("capacity"), rs.getInt("status"), rs
								.getString("remark"));
				return meetingRoom;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return null;
	}

	/**
	 * 添加会议室
	 * 
	 * @param meetingRoom
	 * @return int 成功返回1，不成功返回-1
	 */
	public int addMeetingRoom(MeetingRoom meetingRoom) {
		String sql = "INSERT INTO meetingroom(roomid,roomnum,roomname,capacity,status,remark) VALUES (seq_roomid.nextval,?,?,?,?,?)";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		try {
			ps.setString(1, meetingRoom.getRoomnum());
			ps.setString(2, meetingRoom.getRoomname());
			ps.setInt(3, meetingRoom.getCapacity());
			ps.setInt(4, meetingRoom.getStatus());
			ps.setString(5, meetingRoom.getRemark());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}
		return -1;
	}

	/**
	 * 更改会议室信息
	 * 
	 * @param meetingRoom
	 * @return int 成功返回1，不成功返回-1
	 */
	public int updateMeetingRoom(MeetingRoom meetingRoom) {
		String sql = "UPDATE meetingroom set roomnum=?,roomname=?,capacity=?,status=?,remark=? WHERE roomid=?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		try {
			ps.setString(1, meetingRoom.getRoomnum());
			ps.setString(2, meetingRoom.getRoomname());
			ps.setInt(3, meetingRoom.getCapacity());
			ps.setInt(4, meetingRoom.getStatus());
			ps.setString(5, meetingRoom.getRemark());
			ps.setInt(6, meetingRoom.getRoomid());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}
		return -1;
	}
}
