package servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MeetingService;
import vo.Employee;
import vo.Meeting;

@SuppressWarnings("serial")
public class BookMeetingServlet extends HttpServlet {
	private MeetingService meetingService = new MeetingService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String meetingname = request.getParameter("meetingname");// 会议名称
		String meetingpersonnum = request.getParameter("meetingpersonnum");// 会议参加人数
		String meetingstarttime = request.getParameter("meetingstarttime");// 会议开始时间
		String meetingendtime = request.getParameter("meetingendtime");// 会议结束时间
		String roomid = request.getParameter("roomid");// 会议室id
		String meetingremark = request.getParameter("meetingremark");// 会议说明
		String[] selSelectedEmployees = request
				.getParameterValues("selSelectedEmployees");// 所有参会人员Id
		// 获取当前登录的用户对象
		Employee loginedEmployee = (Employee) request.getSession()
				.getAttribute("loginedEmployee");
		Meeting meeting = new Meeting(meetingname, Integer
				.parseInt(meetingpersonnum), Timestamp
				.valueOf(meetingstarttime), Timestamp.valueOf(meetingendtime),
				new Timestamp(System.currentTimeMillis()), Integer
						.parseInt(roomid), meetingremark, loginedEmployee
						.getEmployeeid());
		int flag = meetingService.addMeeting(meeting, selSelectedEmployees);
		if (flag != -1) {
			response.sendRedirect(request.getContextPath()
					+ "/SearchMeetingServlet");
		}else{
			request.setAttribute("error", "添加会议失败");
			request.getRequestDispatcher("/meetingReservation/bookmeeting.jsp").forward(request, response);
		}
	}

}
