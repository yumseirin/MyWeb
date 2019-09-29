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
		<title>CoolMeeting会议管理系统</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" href="styles/common.css" />
	</head>

	<body>
		<div class="page-header">
			<div class="header-banner">
				<img src="images/header.png" alt="CoolMeeting" />
			</div>
			<div class="header-title">
				欢迎访问Cool-Meeting会议管理系统
				<!-- target="_parent" 父窗口 "_self" 本页面 "_black" 新页面  -->
			</div>
			<div class="header-quicklink">
				欢迎您，
				<strong>${sessionScope.loginedEmployee.username }</strong>
				<a href="personalCenter/changepassword.jsp" target="main">[修改密码]</a>

				<div>
					目前网站访问次数：
					<font color='red'>${applicationScope.visitcount }</font>
					<a href="" target="_parent">退出</a>
				</div>

			</div>
		</div>
	</body>
</html>
