package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MeetingService;

@SuppressWarnings("serial")
public class DoCancelMeetingServlet extends HttpServlet {
	private MeetingService meetingService = new MeetingService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String canceledreason = request.getParameter("canceledreason");
		int i = meetingService.cancelMeeting(Integer.parseInt(mid),
				canceledreason);
		if (i == 1) {
			// 取消成功
			response.sendRedirect(request.getContextPath() + "/MyBookingServlet");
		}
	}

}
