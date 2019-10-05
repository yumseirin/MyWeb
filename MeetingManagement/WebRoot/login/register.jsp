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

		<title>员工注册</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="styles/common03.css" />
		<script type="text/javascript" src="js/jquery-1.8.3.min.js">
</script>
		<script type="text/javascript">
$(function() {
	$("#departmentid").ready(function() {
		departmentid();
	});
});
function departmentid() {
	$.post("GetDepServlet", {}, callBackRegdepartmentidSuccess);
}
function callBackRegdepartmentidSuccess(data) {
	var str = "";
	if (data != null && data != "") {
		for ( var i = 0; i < data.length; i++) {
			str += "<option value=\"" + data[i].departmentid + "\">"
					+ data[i].departmentname + "</option>"
		}
		$("#departmentid").html("");
		$("#departmentid").append(str);
	}
}
</script>
		<script type="text/javascript">

function realnamecheck() {
	$("#frealname").html("*");
	var user = $("#realname").val();
	if (user == "") {
		$("#frealname").html("真实姓名不能为空");
		return false;
	}
	if (!/^([\u4e00-\u9fa5]{1,20}|[a-zA-Z\\.\\s]{1,20})$/.test(user)) {
		$("#frealname").html("请输入纯英文或中文，不得超过20位");
		return false;
	}
}
function usernamecheck() {
	$("#fusername").html("*");
	var user = $("#username").val();
	if (user == "") {
		$("#fusername").html("用户名不能为空");
		return false;
	}
	if (!/[a-zA-Z]\w{4,16}/.test(user)) {
		$("#fusername").html("4-16位由英文开头，英文和数字组成");
		return false;
	}
}
function passwordcheck() {
	$("#fpassword").html("*");
	var password = $("#password").val();
	if (password == "") {
		$("#fpassword").html("密码不能为空");
		return false;
	}
	if (!/\w{4,16}/.test(password)) {
		$("#fpassword").html("4-16位由英文和数字组成");
		return false;
	}
}
function repasswordcheck() {
	$("#frepassword").html("*");
	var password = $("#password").val();
	var repassword = $("#repassword").val();
	if (password != repassword) {
		$("#frepassword").html("密码不一致！");
		return false;
	}
}
function phonecheck() {
	$("#fphone").html("");
	var phone = $("#phone").val();
	if (phone == "") {
		$("#fphone").html("电话不能为空!");
		return false;
	}
	if (!/^1(3|4|5|7|8)\d{9}$/.test(phone)) {
		$("#fphone").html("请输入13、14、15、17、18开头的11位数字！");
		return false;
	}
}
function emailcheck() {
	$("#femail").html("");
	var email = $("#email").val();
	if (email == "") {
		$("#femail").html("邮箱不能为空!");
		return false;
	}
	if (!/^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4})*$/.test(email)) {
		$("#femail").html("邮箱格式不对！");
		return false;
	}
}
function registervalidate() {
	$("#frealname").html("*");
	var user = $("#realname").val();
	if (user == "") {
		$("#frealname").html("真实姓名不能为空");
		return false;
	}
	if (!/^([\u4e00-\u9fa5]{1,20}|[a-zA-Z\\.\\s]{1,20})$/.test(user)) {
		$("#frealname").html("请输入纯英文或中文，不得超过20位");
		return false;
	}
	
	$("#fusername").html("*");
	var user = $("#username").val();
	if (user == "") {
		$("#fusername").html("用户名不能为空");
		return false;
	}
	if (!/[a-zA-Z]\w{4,16}/.test(user)) {
		$("#fusername").html("4-16位由英文开头，英文和数字组成");
		return false;
	}
	
	$("#fpassword").html("*");
	var password = $("#password").val();
	if (password == "") {
		$("#fpassword").html("密码不能为空");
		return false;
	}
	if (!/\w{4,16}/.test(password)) {
		$("#fpassword").html("4-16位由英文和数字组成");
		return false;
	}
	
	$("#frepassword").html("*");
	var repassword = $("#repassword").val();
	if (password != repassword) {
		$("#frepassword").html("密码不一致！");
		return false;
	}
	
	$("#fphone").html("");
	var phone = $("#phone").val();
	if (phone == "") {
		$("#fphone").html("电话不能为空!");
		return false;
	}
	if (!/^1(3|4|5|7|8)\d{9}$/.test(phone)) {
		$("#fphone").html("请输入13、14、15、17、18开头的11位数字！");
		return false;
	}
	
	$("#femail").html("");
	var email = $("#email").val();
	if (email == "") {
		$("#femail").html("邮箱不能为空!");
		return false;
	}
	if (!/^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4})*$/.test(email)) {
		$("#femail").html("邮箱格式不对！");
		return false;
	}
}
</script>
	</head>
	<body>
		<div class="page-content">
			<div class="content-nav">
				人员管理 &gt; 员工注册
			</div>
			<form onsubmit="return registervalidate()" action="register"
				name="register" method="post">
				<fieldset>
					<legend>
						员工信息
					</legend>
					<table class="formtable" style="width: 70%" border="0">
						<c:if test="${error!=null}">
							<tr>
								<td colspan="2">
									<font color="red">${error}</font>
								</td>
							</tr>
						</c:if>
						<tr>
							<td>
								真实姓名：
							</td>

							<td>
								<input type="text" onblur="realnamecheck()" name="realname"
									id="realname" maxlength="20" value="" />
								&nbsp;&nbsp;
								<font id="frealname" color="red">*</font>
							</td>
						</tr>
						<tr>
							<td>
								用户名：
							</td>

							<td>
								<input type="text" onblur="usernamecheck()" name="username"
									id="username" maxlength="20" />
								&nbsp;&nbsp;
								<font id="fusername" color="red">*</font>
							</td>
						</tr>
						<tr>
							<td>
								密码：
							</td>
							<td>
								<input type="password" onblur="passwordcheck()" name="password"
									id="password" maxlength="20" />
								&nbsp;&nbsp;
								<font id="fpassword" color="red">*</font>
							</td>
						</tr>
						<tr>
							<td>
								确认密码：
							</td>
							<td>
								<input type="password" onblur="repasswordcheck()"
									name="repassword" id="repassword" maxlength="20" />
								&nbsp;&nbsp;
								<font id="frepassword" color="red">*</font>
							</td>
						</tr>
						<tr>
							<td>
								联系电话：
							</td>
							<td>
								<input type="text" onblur="phonecheck()" name="phone" id="phone"
									maxlength="20" value="" />
								<font id="fphone" color="red"></font>
							</td>
						</tr>
						<tr>
							<td>
								电子邮件：
							</td>
							<td>
								<input type="text" onblur="emailcheck()" name="email" id="email"
									maxlength="20" value="" />
								<font id="femail" color="red"></font>
							</td>
						</tr>
						<tr>
							<td>
								所属部门：
							</td>
							<td>
								<select name="departmentid" id="departmentid">

								</select>
								&nbsp;&nbsp;
								<font color="red">*</font>
							</td>
						</tr>
						<tr>
							<td colspan="6" class="command">
								<input type="submit" class="clickbutton" value="注册" />
								<input type="reset" class="clickbutton" value="重置" />
								<input type="button" value="返回" class="clickbutton"
									onclick="window.history.back();" />
							</td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
	</body>
</html>
