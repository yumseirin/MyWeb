<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

		<title>My JSP 'register.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js">
</script>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		<center>
			<h2>
				注册
			</h2>
			<form action="register" method="post" enctype="multipart/form-data">
				用户名：
				<input type="text" name="uname" />
				<br>
				密码：
				<input type="password" name="pwd" />
				<br>
				性别：
				<input type="radio" value="nan" name="sex" />
				男
				<input type="radio" value="nv" name="sex" />
				女
				<br>
				爱好：
				<input type="checkbox" value="huihua" name="like" />
				绘画
				<input type="checkbox" value="yinyue" name="like" />
				音乐
				<input type="checkbox" value="tiaowu" name="like" />
				跳舞
				<br>
				生日：
				<input type="text" name="bir"
					onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
				<br>
				相片：
				<input type="file" name="pic" />
				<br>
				<input type="submit" value="注册" />
			</form>
		</center>
	</body>
</html>
