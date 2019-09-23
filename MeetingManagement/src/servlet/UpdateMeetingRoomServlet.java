package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MeetingRoomService;
import vo.MeetingRoom;
/**
 * 更改会议室信息
 * @author seirin
 *
 */
@SuppressWarnings("serial")
public class UpdateMeetingRoomServlet extends HttpServlet {
	private MeetingRoomService meetingRoomService = new MeetingRoomService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String roomid = request.getParameter("roomid");
		String roomnum = request.getParameter("roomnum");// 门牌号
		String roomname = request.getParameter("roomname");
		String capacity = request.getParameter("capacity");// 最多容纳人数
		String status = request.getParameter("status");
		String remark = request.getParameter("remark");
		MeetingRoom meetingRoom = new MeetingRoom();
		meetingRoom.setRoomid(Integer.parseInt(roomid));
		meetingRoom.setRoomnum(roomnum);
		meetingRoom.setRoomname(roomname);
		meetingRoom.setCapacity(Integer.parseInt(capacity));
		meetingRoom.setStatus(Integer.parseInt(status));
		meetingRoom.setRemark(remark);

		// 修改会议室
		meetingRoom.setRoomid(Integer.parseInt(roomid));
		int update = meetingRoomService.updateMeetingRoom(meetingRoom);
		if (update == 1) {
			response.sendRedirect(request.getContextPath()
					+ "/SelectAllMeetingRoomServlet");
		} else {
			// 更新失败
			request.setAttribute("error", "修改失败");
			request.getRequestDispatcher(
					"/meetingReservation/meetingroomedit.jsp").forward(request,
					response);
		}
	}

}
