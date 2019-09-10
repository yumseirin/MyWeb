<%@ page language="java" import="java.util.*,java.net.URLDecoder"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	//从Cookie中取用户信息
	String username = null;
	String password = null;
	String call = null;
	String bir = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("uname")) {
				username = cookie.getValue();
				username = URLDecoder.decode(username, "utf-8");
			}
			if (cookie.getName().equals("pwd")) {
				password = cookie.getValue();
			}
			if (cookie.getName().equals("bir")) {
				bir = cookie.getValue();
			}

			if (cookie.getName().equals("call")) {
				call = cookie.getValue();
			}
		}
	}

	if (username != null && password != null && bir != null
			&& call != null) {
		request.getRequestDispatcher(
				"LoginServlet?uname=" + username + "&pwd=" + password
						+ "&bir=" + bir + "&call=" + call).forward(
				request, response);
	}
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
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js">
</script>

	</head>

	<body>
		<center>
			<h1>
				登录
			</h1>
			<form action="login" method="post">
				<br />
				用户名：
				<input type="text" name="uname">
				<br />
				<br />
				密&emsp;码：
				<input type="password" name="pwd">
				<br />
				<br />
				生&emsp;日：
				<input type="text" name="bir"
					onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
				<br />
				<br />
				电&emsp;话：
				<input type="text" name="call">
				<br />
				<br />
				<input type="submit" name="sub" value="登录">
				&emsp;&emsp;&emsp;
				<input type="reset" name="reset" value="取消">
				<br />
			</form>
		</center>
	</body>
</html>
