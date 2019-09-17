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

				<tr>
					<td>
						年终总结
					</td>
					<td>
						1号会议室
					</td>
					<td>
						2019-10-1
					</td>
					<td>
						2019-10-6
					</td>

					<td>
						<a class="clickbutton" href="mymeetingdetail.jsp">查看详情</a>
					</td>
				</tr>

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

				<tr>
					<td>
						年中总结
					</td>
					<td>
						1号会议室
					</td>
					<td>
						2019-10-1
					</td>
					<td>
						2019-10-6
					</td>
					<td>
						员工出差
					</td>

					<td>
						<a class="clickbutton" href="mymeetingdetail.jsp">查看详情</a>
					</td>
				</tr>


			</table>

		</div>
	</body>
</html>
