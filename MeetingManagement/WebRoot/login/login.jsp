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

		<title>CoolMeeting会议管理系统</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="styles/common.css" />
		<script src="js/jquery-1.8.3.min.js" type="text/javascript">
</script>
		<script type="text/javascript">
if (window != top)
	top.location.href = location.href;
</script>

	</head>

	<body>
		<div class="page-header">
			<div class="header-banner">
				<img src="images/header.png" alt="CoolMeeting" />
			</div>
			<div class="header-title">
				欢迎访问Cool-Meeting会议管理系统
			</div>
		</div>
		<form action="login" method="post">
			<fieldset>
				<legend>
					登录信息
				</legend>
				<br>
				<table class="formtable" style="width: 50%" border="0">
					<c:if test="${error!=null}">
						<tr>
							<td colspan="2">
								<font color="red">${error}</font>
							</td>
						</tr>
					</c:if>
					<tr>
						<td align="center">
						</td>
						<td align="left">
						</td>
					</tr>
					<tr>
						<td align="center">
							用户名:
						</td>
						<td align="left">
							<input type="text" name="username" id="username" />
						</td>
					</tr>
					<tr>
						<td align="center">
							密&nbsp;&nbsp;&nbsp;&nbsp;码:
						</td>
						<td align="left">
							<input type="password" name="password" id="password" />
						</td>
					</tr>
					<tr>
						<td align="center">
						</td>
						<td align="left">
						</td>
					</tr>
					<tr align="center">
						<td></td>
						<td align="left">
							<input type="submit" value="登录" class="clickbutton" />
							<input type="button" value="注册" class="clickbutton"
								onclick="window.location.href='<%=basePath%>login/register.jsp'" />
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
		<div class="page-footer">
			<hr />
			更多问题，欢迎联系
			<a href="mailto:seirin@seirin.com">管理员</a>
			<img src="images/footer.png" alt="CoolMeeting" />
		</div>
	</body>
</html>
