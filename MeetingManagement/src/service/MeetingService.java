package service;

import java.sql.Timestamp;
import java.util.List;

import vo.Employee;
import vo.Meeting;
import vo.MeetingRoom;
import vo.MyMeeting;
import dao.EmployeeDao;
import dao.MeetingDao;
import dao.MeetingUserDao;

public class MeetingService {
	private MeetingDao meetingDao = new MeetingDao();
	private EmployeeDao employeeDao = new EmployeeDao();
	private MeetingUserDao meetingMeetingUserDao = new MeetingUserDao();

	private List<Employee> emps;

	public List<Employee> getEmps() {
		return emps;
	}

	/**
	 * 将数据添加到会议与会议参与人表中
	 * 
	 * @param meetingid
	 * @param empids
	 */
	public int addMeeting(Meeting meeting, String[] empids) {
		int meetingid = meetingDao.addMeeting(meeting);
		if (meetingid != -1) {
			return meetingMeetingUserDao.addMeetingUser(meetingid, empids);
		} else {
			return -1;
		}
	}

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
		return meetingDao.getCount(meetingname, roomname, reservername,
				reservefromdate, reservetodate, meetingfromdate, meetingtodate);
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
		return meetingDao.searchMeeting(meetingname, roomname, reservername,
				reservefromdate, reservetodate, meetingfromdate, meetingtodate,
				startrow, endrow);
	}

	public Meeting getMeetingDetailsByMeetingId(int mid) {
		Meeting meeting = meetingDao.selectMeetingById(mid);

		this.emps = employeeDao.selectEmpByMeetingId(meeting.getMeetingid());
		return meeting;
	}

	/**
	 * 查询某员工最近七天参加的所有会议
	 * 
	 * @param employeeid
	 *            员工id
	 * @return list 要参与的会议信息list
	 */
	public List<MyMeeting> selectMyNewMeeting(int employeeid) {
		return meetingDao.selectMyNewMeeting(employeeid);
	}

	/**
	 * 查询某员工查询某员工被要求参加，但是又取消的会议
	 * 
	 * @param employeeid
	 *            员工id
	 * @return list 要参与的会议信息list
	 */
	public List<MyMeeting> selectMycanceledMeeting(int employeeid) {
		return meetingDao.selectMycanceledMeeting(employeeid);
	}

	/**
	 * 我预定的会议
	 * 
	 * @param empid
	 * @return List<MyMeeting>
	 */
	public List<MyMeeting> selectMyBookingMeeting(int empid) {
		return meetingDao.selectMyBookingMeeting(empid);
	}

	/**
	 * 根据员工Id查询我的会议
	 * 
	 * @param empid
	 * @return List<MyMeeting>
	 */
	public List<MyMeeting> selectMyMeeting(int empid) {
		return meetingDao.selectMyMeeting(empid);
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
		return meetingDao.selectMeetingRoomsByTime(meetingpersonnum,
				meetingstarttime, meetingendtime);
	}
	
	/**
	 * 取消会议，更改会议状态，取消时间，取消原因 String MEETINGSTATUS1="1"; //撤销
	 * 
	 * @param meetingid
	 * @param reason
	 * @return 成功返回1，不成功返回-1
	 */
	public int cancelMeeting(int meetingid, String reason) {
		return meetingDao.cancelMeeting(meetingid, reason);
	}
}
