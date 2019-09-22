<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="vo.Department"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

		<title>部门管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="styles/common03.css" />
		<script src="js/jquery-1.8.3.min.js" type="text/javascript">
</script>
		<script>
function departmentbyid(depid) {
	$.post("SelectDepByIdServlet", {
		id : depid
	}, callBackDepartmentByIdSuccess);
}
function callBackDepartmentByIdSuccess(data) {
	if (data != null && data != "") {
		$("#depname" + data.departmentid).html(data.departmentname);
	}
}
function cancelEdit(depid) {//取消编辑
	var cancelBtn = $("#cancel" + depid);//取消按钮
	var editBtn = $("#edit" + depid);//编辑按钮
	//var dep = $("#depname" + depid);//部门名称
	cancelBtn.css("display", "none");
	editBtn.html("编辑");
	departmentbyid(depid);
}
function editDep(depid) {
	var cancelBtn = $("#cancel" + depid);//取消按钮id
	var editBtn = $("#edit" + depid);//编辑按钮id
	var dep = $("#depname" + depid);//部门名称id
	if (cancelBtn.css("display") == 'none') {
		cancelBtn.css("display", "inline")//显示取消按钮
		editBtn.html("确定");//将编辑改为确定
		var depName = dep.text();
		dep.html("<input type='text' value='" + depName + "'/>");
	} else {//再次点击editBtn（已由编辑变为确定）
		//提交修改
		var children = dep.children("input");
		var val = children.val();
		$.post("UpdateDepServlet", {
			id : depid,
			depName : val
		}, function(msg) {
			alert(msg);
			cancelBtn.css("display", "none")//隐藏取消按钮
				editBtn.html("编辑");//将确定变回编辑
				//dep.html(val);//部门名称
			});
		departmentbyid(depid);
	}

}
</script>
	</head>

	<body>
		<div class="page-content">
			<div class="content-nav">
				人员管理 > 部门管理
			</div>
			<form action="AddDepServlet" method="post">
				<input type="hidden" name="code" value="add">
				<fieldset>
					<legend>
						添加部门
					</legend>
					${error} 部门名称:
					<input type="text" id="departmentname" name="departmentname"
						maxlength="20" />
					<input type="submit" class="clickbutton" value="添加" />
				</fieldset>
			</form>

			<table class="listtable">
				<caption>
					所有部门:
				</caption>
				<tr class="listheader">
					<th>
						部门编号
					</th>
					<th>
						部门名称
					</th>
					<th>
						操作
					</th>
				</tr>
				<c:if test="${error!=null}">
					<tr>
						<td colspan="3">
							${error}
						</td>
					</tr>
				</c:if>
				<c:forEach items="${list}" var="dep">
					<tr id="tr${dep.departmentid}">
						<td>${dep.departmentid}</td>
						<td id="depname${dep.departmentid}">${dep.departmentname}</td>
						<td>
							<a class="clickbutton" id="edit${dep.departmentid}"
								onclick="editDep(${dep.departmentid})">编辑</a>
							<a class="clickbutton" style="display: none"
								id="cancel${dep.departmentid}"
								onclick="cancelEdit(${dep.departmentid})">取消</a>
							<a class="clickbutton"
								href="DeleteDepSerlvet?depid=${dep.departmentid}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
