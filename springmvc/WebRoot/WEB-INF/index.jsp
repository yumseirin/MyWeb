<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<title>主页</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		Hello &nbsp;&nbsp;${sessionScope.user.uname}&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%=basePath%>loginControl/logOff.action">退出</a>
		<table width="70%" border="2px" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">
					用户名
				</td>
				<td align="center">
					密码
				</td>
				<td align="center">
					图片
				</td>
				<td align="center">
					爱好
				</td>
			</tr>
			<c:forEach var="user" items="${requestScope.list}">
				<tr>
					<td align="center">
						${user.uname }
					</td>
					<td align="center">
						${user.pwd }
					</td>
					<td align="center">
						<img
							src="<%=basePath%>loginControl/img.action?uname=${user.uname}"
							width="100" height="100">
					</td>
					<td align="center">
						${user.likes }
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
