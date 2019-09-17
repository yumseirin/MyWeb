<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<frameset rows="100,*,80" cols="*" framespacing="0" frameborder="no"
		border="0">
		<frame src="top.jsp" name="topFrame" scrolling="No"
			noresize="noresize" id="topFrame" marginwidth="0" marginheight="0"
			frameborder="0" />

		<frameset cols="260,*" id="frame">
			<frame src="left.jsp" name="leftFrame" noresize="noresize"
				marginwidth="50px" marginheight="0" frameborder="0"
				scrolling="No"  />
			<frame src="mymeetingtongzhi.jsp" name="main" 
				 frameborder="0" scrolling="no"  />
		</frameset>
		<frame src="bottom.jsp" name="bottomFrame" scrolling="No"
			noresize="noresize" id="bottomFrame" marginwidth="0" marginheight="0" />

	</frameset>
</html>
