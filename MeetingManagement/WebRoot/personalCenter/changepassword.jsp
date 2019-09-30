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
    
    <title>My JSP 'changpassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="styles/common.css" />
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
function origincheck(){
	document.getElementById("sporigin").innerHTML = "";
	var origin = document.getElementById("origin").value;
	if (trim(origin) == "") {
		document.getElementById("sporigin").innerHTML = "原密码不能为空！";
		document.getElementById("origin").focus();
		return false;
	}
}
function newcheck(){
	document.getElementById("spnew").innerHTML = "";
	var newpass = document.getElementById("new").value;
	if (trim(newpass) == "") {
		document.getElementById("spnew").innerHTML = "新密码不能为空！";
		document.getElementById("new").focus();
		return false;
	}
	if(!/^(\w){6,20}$/.test(trim(newpass))){
		document.getElementById("spnew").innerHTML = "只能输入6-20个字母、数字、下划线！";
		document.getElementById("new").focus();
		return false;
	}
}
function confirmcheck(){
	document.getElementById("spconfirm").innerHTML = "";
	var newpass = document.getElementById("new").value;
	var confirm = document.getElementById("confirm").value;
	if (trim(confirm) == "") {
		document.getElementById("spconfirm").innerHTML = "确认密码不能为空！";
		document.getElementById("confirm").focus();
		return false;
	}
	if (trim(newpass)!=trim(confirm)) {
		document.getElementById("spconfirm").innerHTML = "密码不一致！";
		document.getElementById("confirm").focus();
		return false;
	}
}
function changPassWordvalidate(){
	document.getElementById("sporigin").innerHTML = "";
	document.getElementById("spnew").innerHTML = "";
	document.getElementById("spconfirm").innerHTML = "";

	var origin = document.getElementById("origin").value;
	var newpass = document.getElementById("new").value;
	var confirm = document.getElementById("confirm").value;

	if (trim(origin) == "") {
		document.getElementById("sporigin").innerHTML = "原密码不能为空！";
		document.getElementById("origin").focus();
		return false;
	}
	if (trim(newpass) == "") {
		document.getElementById("spnew").innerHTML = "新密码不能为空！";
		document.getElementById("new").focus();
		return false;
	}
	if(!/^(\w){6,20}$/.test(trim(newpass))){
		document.getElementById("spnew").innerHTML = "只能输入6-20个字母、数字、下划线！";
		document.getElementById("new").focus();
		return false;
	}
	if (trim(confirm) == "") {
		document.getElementById("spconfirm").innerHTML = "确认密码不能为空！";
		document.getElementById("confirm").focus();
		return false;
	}
	if (trim(newpass)!=trim(confirm)) {
		document.getElementById("spconfirm").innerHTML = "密码不一致！";
		document.getElementById("confirm").focus();
		return false;
	}
}
//去掉前后空格
function trim(str) {
	return str.replace(/(^\s+)|(\s+$)/g, "");//去除前后空格
}
	</script>

	</head>
	<body>
		<div class="page-content">
			<div class="content-nav">
				修改密码
			</div>
			<form onsubmit="return changPassWordvalidate();" action="ChangPassWordServlet" method="post">
				<fieldset>
					<legend>
						修改密码信息
					</legend>
					<table class="formtable" style="width: 50%">
						<c:if test="${error!=null}">
							<tr>
								<td colspan="2">
									<font color="red" >${error}</font>
								</td>
							</tr>
						</c:if>
						<tr>
							<td>
								原密码:
							</td>
							<td>
								<input id="origin" onblur="origincheck()" name="origin" type="password" />
								<span id="sporigin" style="color:red;"></span>
							</td>
						</tr>
						<tr>
							<td>
								新密码:
							</td>
							<td>
								<input id="new" onblur="newcheck()" name="new" type="password" placeholder="6-20个字母数字下划线"/>
								<span id="spnew" style="color:red;"></span>
							</td>
						</tr>
						<tr>
							<td>
								确认新密码：
							</td>
							<td>
								<input id="confirm" onblur="confirmcheck()" name="confirm" type="password" />
								<span id="spconfirm" style="color:red;"></span>
							</td>
						</tr>
						<tr>
							<td colspan="2" class="command">
								<input type="submit" value="确认修改" class="clickbutton" />
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