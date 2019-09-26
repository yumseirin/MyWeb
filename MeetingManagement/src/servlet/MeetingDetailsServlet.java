package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MeetingService;
import vo.Employee;
import vo.Meeting;

@SuppressWarnings("serial")
public class MeetingDetailsServlet extends HttpServlet {
	private MeetingService meetingService = new MeetingService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		//稍后制作，如果是管理员或者预定会议的人有取消的资格，显示撤销会议按钮
		String type = request.getParameter("type");
		Meeting meeting = meetingService.getMeetingDetailsByMeetingId(Integer
				.parseInt(mid));
		List<Employee> emps = meetingService.getEmps();
		request.setAttribute("mt", meeting);
		request.setAttribute("emps", emps);
		request.setAttribute("type", type);
		request.getRequestDispatcher("/meetingReservation/meetingdetails.jsp").forward(request, response);
	}

}
