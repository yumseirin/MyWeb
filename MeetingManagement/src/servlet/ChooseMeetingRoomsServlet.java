package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import service.MeetingService;
import vo.MeetingRoom;

@SuppressWarnings("serial")
public class ChooseMeetingRoomsServlet extends HttpServlet {
	private MeetingService meetingService = new MeetingService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String meetingpersonnum = request.getParameter("meetingpersonnum");
		String meetingstarttime = request.getParameter("meetingstarttime");
		String meetingendtime = request.getParameter("meetingendtime");

		List<MeetingRoom> list = meetingService.selectMeetingRoomsByTime(
				Integer.parseInt(meetingpersonnum),
				Timestamp.valueOf(meetingstarttime), 
				Timestamp.valueOf(meetingendtime));

		String str = JSON.toJSONString(list);
		System.out.println(str);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(str);
		out.flush();
		out.close();
	}

}
