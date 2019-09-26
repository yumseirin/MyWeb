package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MeetingService;
import vo.Employee;
import vo.MyMeeting;

@SuppressWarnings("serial")
public class NotificationsServlet extends HttpServlet {
	private MeetingService meetingService = new MeetingService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int loginEmpId = ((Employee) request.getSession().getAttribute(
				"loginedEmployee")).getEmployeeid();
		List<MyMeeting> mt7 = meetingService.selectMyNewMeeting(loginEmpId);
		List<MyMeeting> cm = meetingService.selectMycanceledMeeting(loginEmpId);
		// for(MyMeeting i:cm){
		// System.out.println(i.getCanceledreason());
		// }
		request.setAttribute("mt7", mt7);
		request.setAttribute("cm", cm);
		request.getRequestDispatcher("/personalCenter/notifications.jsp")
				.forward(request, response);
	}

}
