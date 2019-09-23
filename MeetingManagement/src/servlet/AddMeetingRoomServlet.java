package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MeetingRoomService;
import vo.MeetingRoom;
/**
 * 添加会议室
 * @author seirin
 *
 */
@SuppressWarnings("serial")
public class AddMeetingRoomServlet extends HttpServlet {
	private MeetingRoomService meetingRoomService = new MeetingRoomService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String roomnum = request.getParameter("roomnum");// 门牌号
		String roomname = request.getParameter("roomname");
		String capacity = request.getParameter("capacity");// 最多容纳人数
		String status = request.getParameter("status");
		String remark = request.getParameter("remark");
		MeetingRoom meetingRoom = new MeetingRoom();
		meetingRoom.setRoomnum(roomnum);
		meetingRoom.setRoomname(roomname);
		meetingRoom.setCapacity(Integer.parseInt(capacity));
		meetingRoom.setStatus(Integer.parseInt(status));
		meetingRoom.setRemark(remark);

		// 添加会议室
		int result = meetingRoomService.addMeetingRoom(meetingRoom);
		if (result == 1) {
			// 去查看会议室页面
			response.sendRedirect(request.getContextPath()
					+ "/SelectAllMeetingRoomServlet");
		} else {
			request.setAttribute("error", "添加失败");
			request.getRequestDispatcher(
					"/meetingReservation/addmeetingroom.jsp").forward(request,
					response);
		}
	}

}
