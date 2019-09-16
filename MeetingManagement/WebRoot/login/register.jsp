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

		<title>员工注册</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="styles/common03.css" />

	</head>
	<% %>
	<div class="page-content">
		<div class="content-nav">
			人员管理 > 员工注册
		</div>
		<form name="form1" method="post">
			<fieldset>
				<legend>
					员工信息
				</legend>
				<table class="formtable" style="width: 70%" border="0">
					<tr>
						<td>
							真实姓名：
						</td>

						<td>
							<input type="text" name="realname" id="realname" maxlength="20"
								value="" />
							&nbsp;&nbsp;
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td>
							用户名：
						</td>

						<td>
							<input type="text" name="username" id="username" maxlength="20" />
							&nbsp;&nbsp;
							<font color="red">*</font>
							<div id="message"></div>
						</td>
					</tr>
					<tr>
						<td>
							密码：
						</td>
						<td>
							<input type="password" name="password" id="password"
								maxlength="20" />
							&nbsp;&nbsp;
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td>
							确认密码：
						</td>
						<td>
							<input type="password" name="repassword" id="repassword"
								maxlength="20" />
							&nbsp;&nbsp;
							<font color="red">*</font>
							<div id="confirminfo"></div>
						</td>
					</tr>
					<tr>
						<td>
							联系电话：
						</td>
						<td>
							<input type="text" name="phone" id="phone" maxlength="20"
								value="" />
						</td>
					</tr>
					<tr>
						<td>
							电子邮件：
						</td>
						<td>
							<input type="text" name="email" id="email" maxlength="20"
								value="" />
						</td>
					</tr>
					<tr>
						<td>
							所属部门：
						</td>
						<td>
							<select name="departmentid" id="departmentid">
								<option value="">
									技术部
								</option>
								<option value="">
									产品部
								</option>
							</select>
							&nbsp;&nbsp;
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td colspan="6" class="command">
							<input type="button" class="clickbutton" value="注册"
								onclick="window.location.href='login.jsp';" />
							<input type="reset" class="clickbutton" value="重置" />
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
	</body>
</html>
