<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>登录</title>

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
		<center>
			<h4>
				登录
			</h4>
			${requestScope.msg }
			<form action="loginControl/login.action" method="post">
				用户名：
				<input type="text" name="uname">
				<br>
				密&emsp;码：
				<input type="password" name="pwd">
				<br>
				<input type="submit" value="登录">
				<a href="zhuceControl/gotozhuce.action">注册</a>
			</form>
		</center>
	</body>
</html>
