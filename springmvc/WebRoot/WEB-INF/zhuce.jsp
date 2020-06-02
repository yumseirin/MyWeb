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

		<title>注册</title>

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
				注册
			</h4>
			${requestScope.msg }
			<form action="zhuceControl/zhuce.action" method="post"
				enctype="multipart/form-data">
				用户名：
				<input type="text" name="uname">
				<br>
				密&emsp;码：
				<input type="password" name="pwd">
				<br>
				图&emsp;片：
				<input type="file" name="pic2">
				<br>
				爱&emsp;好：
				<input type="checkbox" name="likes" value="eat">
				吃&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" name="likes" value="sleep">
				睡&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" name="likes" value="game">
				打游戏
				<br>
				<input type="submit" value="提交">
				&nbsp;&nbsp;
				<a href="#">返回</a>
			</form>
		</center>
	</body>
</html>
