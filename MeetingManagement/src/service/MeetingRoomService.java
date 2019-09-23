package service;

import java.util.List;

import vo.MeetingRoom;
import dao.MeetingRoomDao;

public class MeetingRoomService {
	private MeetingRoomDao meetingRoomDao = new MeetingRoomDao();

	/**
	 * 查询所有会议室
	 * 
	 * @return List<MeetingRoom> 返回所有会议室信息
	 */
	public List<MeetingRoom> selectAllMeetingRoom() {
		return meetingRoomDao.selectAllMeetingRoom();
	}

	/**
	 * 根据会议室Id查询会议室信息
	 * 
	 * @param id
	 * @return MeetingRoom 返回会议室信息
	 */
	public MeetingRoom selectMeetingRoomById(int id) {
		return meetingRoomDao.selectMeetingRoomById(id);
	}

	/**
	 * 添加会议室
	 * 
	 * @param meetingRoom
	 * @return int 成功返回1，不成功返回-1
	 */
	public int addMeetingRoom(MeetingRoom meetingRoom) {
		return meetingRoomDao.addMeetingRoom(meetingRoom);
	}

	/**
	 * 更改会议室信息
	 * 
	 * @param meetingRoom
	 * @return int 成功返回1，不成功返回-1
	 */
	public int updateMeetingRoom(MeetingRoom meetingRoom) {
		return meetingRoomDao.updateMeetingRoom(meetingRoom);
	}
}
