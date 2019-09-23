package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MeetingRoomService;
import vo.MeetingRoom;
/**
 * 根据ID获得会议室信息
 * @author seirin
 *
 */
@SuppressWarnings("serial")
public class MeetingRoomDetails extends HttpServlet {
	private MeetingRoomService meetingRoomService = new MeetingRoomService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String roomid = request.getParameter("roomid");
        MeetingRoom meetingRoom = meetingRoomService.selectMeetingRoomById(Integer.parseInt(roomid));
        request.setAttribute("mr", meetingRoom);
        request.getRequestDispatcher("/meetingReservation/meetingroomedit.jsp").forward(request, response);
	}

}
