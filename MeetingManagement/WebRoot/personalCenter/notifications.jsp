<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

		<title>最新通知</title>

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
				个人中心 >
				<a href="notifications">最新通知</a>
			</div>
			<table class="listtable">
				<caption>
					未来7天我要参加的会议:
				</caption>
				<tr class="listheader">
					<th style="width: 300px">
						会议名称
					</th>
					<th>
						会议室
					</th>
					<th>
						起始时间
					</th>
					<th>
						结束时间
					</th>
					<th style="width: 100px">
						操作
					</th>
				</tr>
				<c:forEach items="${mt7}" var="mt">
					<tr>
						<td>
							${mt.meetingname}
						</td>
						<td>
							${mt.roomname}
						</td>
						<td>
							<fmt:formatDate value="${mt.meetingstarttime}"
								pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
						</td>
						<td>
							<fmt:formatDate value="${mt.meetingendtime}"
								pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
						</td>
						<td>
							<a class="clickbutton"
								href="MeetingDetailsServlet?mid=${mt.meetingid}">查看详情</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<table class="listtable">
				<caption>
					已取消的会议:
				</caption>
				<tr class="listheader">
					<th style="width: 300px">
						会议名称
					</th>
					<th>
						会议室
					</th>
					<th>
						起始时间
					</th>
					<th>
						结束时间
					</th>
					<th>
						取消原因
					</th>
					<th style="width: 100px">
						操作
					</th>
				</tr>
				<c:forEach items="${cm}" var="m">
					<tr>
						<td>
							${m.meetingname}
						</td>
						<td>
							${m.roomname}
						</td>
						<td>
							<fmt:formatDate value="${m.meetingstarttime}"
								pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
						</td>
						<td>
							<fmt:formatDate value="${m.meetingendtime}"
								pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
						</td>
						<td>
							${m.canceledreason}
						</td>
						<td>
							<a class="clickbutton"
								href="MeetingDetailsServlet?mid=${m.meetingid}">查看详情</a>
						</td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</body>
</html>
