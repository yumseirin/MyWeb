<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
/*
	//从cookie里拿用户名和密码自动进行登录
	String username = null;
	String password = null;

	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("uname")) {
				username = cookie.getValue();
			}
			if (cookie.getName().equals("pwd")) {
				username = cookie.getValue();
			}
		}
	}

	if (username != null && password != null) {
		request.getRequestDispatcher(
				"login?uname=" + username + "&pwd=" + password)
				.forward(request, response);
	}
*/
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
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
		${requestScope.msg }
		<form action="login" method="post">
			用户名：
			<input type="text" name="uname" />
			<br />
			密码：
			<input type="password" name="pwd" />

			<br />
			<input type="submit" value="登录">
		</form>
	</body>
</html>
