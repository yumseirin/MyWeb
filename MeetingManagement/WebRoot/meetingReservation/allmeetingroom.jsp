<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<title>查看会议室</title>

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
				会议预定 > 查看会议室
			</div>
			<table class="listtable">
				<caption>
					所有会议室:
				</caption>
				<tr class="listheader">
					<th>
						门牌编号
					</th>
					<th>
						会议室名称
					</th>
					<th>
						容纳人数
					</th>
					<th>
						当前状态
					</th>
					<th>
						操作
					</th>
				</tr>

				<c:forEach items="${list}" var="mr">
					<tr>
						<td>${mr.roomnum}</td>
						<td>${mr.roomname}</td>
						<td>${mr.capacity}</td>
						<td>
							<c:choose>
								<c:when test="${mr.status==0}">启用</c:when>
								<c:when test="${mr.status==1}">停用</c:when>
							</c:choose>
						</td>
						<td>
							<a class="clickbutton"
								href="MeetingRoomDetails?roomid=${mr.roomid}">查看详情</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
