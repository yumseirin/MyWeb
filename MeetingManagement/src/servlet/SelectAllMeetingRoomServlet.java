package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MeetingRoomService;
import vo.MeetingRoom;
/**
 * 查询所有会议室
 * @author seirin
 *
 */
@SuppressWarnings("serial")
public class SelectAllMeetingRoomServlet extends HttpServlet {
	private MeetingRoomService meetingRoomService = new MeetingRoomService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<MeetingRoom> allMeetingRoom = meetingRoomService
				.selectAllMeetingRoom();
		request.setAttribute("list", allMeetingRoom);
		request.getRequestDispatcher("/meetingReservation/allmeetingroom.jsp")
				.forward(request, response);
	}

}
