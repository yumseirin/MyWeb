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

		<title>My JSP 'login.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js">
</script>

	</head>

	<body>
		<form action="loginControl/login2.action" method="post">
			注册
			<br>
			用户名：
			<input type="text" name="uname">
			<br>
			密&emsp;码：
			<input type="password" name="pwd">
			<br>
			生&emsp;日：
			<input type="text" name="bir"
				onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
			<br>
			爱&emsp;好：
			<input type="checkbox" name="like" value="eat">
			吃&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="checkbox" name="like" value="sleep">
			睡&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="checkbox" name="like" value="game">
			打游戏
			<br>
			<input type="submit" value="提交">
		</form>
	</body>
</html>
