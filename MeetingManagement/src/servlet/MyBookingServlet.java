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
public class MyBookingServlet extends HttpServlet {
	private MeetingService meetingService = new MeetingService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost( request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int loginEmpId = ((Employee) request.getSession().getAttribute("loginedEmployee")).getEmployeeid();
        List<MyMeeting> mrs = meetingService.selectMyBookingMeeting(loginEmpId);
        request.setAttribute("mrs", mrs);
        request.getRequestDispatcher("/personalCenter/mybookings.jsp").forward(request, response);
	}

}
