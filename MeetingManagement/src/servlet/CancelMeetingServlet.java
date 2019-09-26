package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MeetingService;
import vo.Meeting;

@SuppressWarnings("serial")
public class CancelMeetingServlet extends HttpServlet {
    private MeetingService meetingService = new MeetingService();
    
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost( request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
        Meeting meeting = meetingService.getMeetingDetailsByMeetingId(Integer.parseInt(mid));
        request.setAttribute("m", meeting);
        request.getRequestDispatcher("/personalCenter/cancelmeeting.jsp").forward(request, response);
	}

}
