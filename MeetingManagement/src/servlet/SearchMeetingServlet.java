package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MeetingService;
import util.CommonConstant;
import vo.Meeting;

@SuppressWarnings("serial")
public class SearchMeetingServlet extends HttpServlet {
	private MeetingService meetingService = new MeetingService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String meetingname = request.getParameter("meetingname");// 会议名称
		String roomname = request.getParameter("roomname");// 会议室名称
		String reservername = request.getParameter("reservername");// 会议预定人
		String reservefromdate = request.getParameter("reservefromdate");// 预定日期范围起
		String reservetodate = request.getParameter("reservetodate");// 预定日期范围止
		String meetingfromdate = request.getParameter("meetingfromdate");// 会议日期起
		String meetingtodate = request.getParameter("meetingtodate");// 会议日期止

		// =============================================
		// 1.当前页： 前台JSP上传过来的页数
		String spage = request.getParameter("page");
		// 2.如果 当前页<1 ，那么当前页=第1页
		if (spage == null || "".equals(spage)) {
			spage = "1";// 获取不到页数就为1
		}
		int page = Integer.parseInt(spage);
		// 3.总记录数 : select count(*) from 表名
		int totalCount = 0;
		totalCount = meetingService.getCount(meetingname, roomname,
				reservername, reservefromdate, reservetodate, meetingfromdate,
				meetingtodate);
		// 4.每页显示多少条 ： 给定一个值就可能
		int count = Integer.parseInt(CommonConstant.pagesize);
		// 5.返回总页数=（总记录数-1）/一页显示多少行+1
		int totalPage = (totalCount - 1) / count + 1;
		// 6.如果当前页数>总页数，那么当前页=总页数
		if (page > totalPage) {
			page = totalPage;
		}
		// 7.起始条数=（当前页数-1）*每页要显示的记录数+1
		int startrow = (page - 1) * count + 1;
		// 8.结束条数=起始条数+每页要显示的记录数
		int endrow = startrow + count - 1;
		// 分页后的数据带到页面显示
		// =============================================
		List<Meeting> list = meetingService.searchMeeting(meetingname, roomname, reservername,
				reservefromdate, reservetodate, meetingfromdate, meetingtodate,
				startrow, endrow);

		request.setAttribute("list", list);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("page", page);
		request.setAttribute("meetingname", meetingname);
		request.setAttribute("roomname", roomname);
		request.setAttribute("reservername", reservername);
		request.setAttribute("reservefromdate", reservefromdate);
		request.setAttribute("reservetodate", reservetodate);
		request.setAttribute("meetingfromdate", meetingfromdate);
		request.setAttribute("meetingtodate", meetingtodate);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/meetingReservation/searchmeetings.jsp").forward(request,
				response);
	}
}
