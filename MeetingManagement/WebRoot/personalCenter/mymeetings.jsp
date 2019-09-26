<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>我的会议</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="styles/common.css">


	</head>

	<body>
		<div class="page-content">
			<div class="content-nav">
				个人中心 > 我的会议
			</div>
			<table class="listtable">
				<caption>
					我将参加的会议：
				</caption>
				<tr class="listheader">
					<th>
						会议名称
					</th>
					<th>
						会议室名称
					</th>
					<th>
						会议开始时间
					</th>
					<th>
						会议结束时间
					</th>
					<th>
						会议预定时间
					</th>
					<th>
						预定者
					</th>
					<th>
						操作
					</th>
				</tr>
				<c:forEach items="${mrs}" var="mr">
					<tr>
						<td>
							${mr.meetingname}
						</td>
						<td>
							${mr.roomname}
						</td>
						<td>
							<fmt:formatDate value="${mr.meetingstarttime}"
								pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
						</td>
						<td>
							<fmt:formatDate value="${mr.meetingendtime}"
								pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
						</td>
						<td>
							<fmt:formatDate value="${mr.reservetime}"
								pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
						</td>
						<td>
							${mr.realname}
						</td>
						<td>
							<a class="clickbutton"
								href="MeetingDetailsServlet?mid=${mr.meetingid}">查看详情</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
