<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<title>预定会议</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="styles/common.css" />
		<script language="javascript" type="text/javascript"
			src="./My97DatePicker/WdatePicker.js">
</script>
		<style type="text/css">
#divfrom {
	float: left;
	width: 150px;
}

#divto {
	float: left;
	width: 150px;
}

#divoperator {
	float: left;
	width: 50px;
	padding: 60px 5px;
}

#divoperator input[type="button"] {
	margin: 10px 0;
}

#selDepartments {
	display: block;
	width: 100%;
}

#selEmployees {
	display: block;
	width: 100%;
	height: 200px;
}

#selSelectedEmployees {
	display: block;
	width: 100%;
	height: 225px;
}
</style>
		<script type="text/javascript" src="js/bookmeeting.js">
</script>
		<script type="text/javascript" src="js/jquery-1.8.3.min.js">
</script>
		<script type="text/javascript">
$(function() {
	$("#selDepartments").ready(function() {
		department();
	});
});
function department() {
	$.post("GetDepServlet", {}, callBackDepartmentSuccess);
}
function callBackDepartmentSuccess(data) {
	var str = "<option value=\"-1\">请选择部门</option>";
	if (data != null && data != "") {
		for ( var i = 0; i < data.length; i++) {
			str += "<option value=\"" + data[i].departmentid + "\">"
					+ data[i].departmentname + "</option>"
		}
		$("#selDepartments").html("");
		$("#selDepartments").append(str);
	}
}
</script>
	</head>

	<body>
		<div class="page-content">
			<div class="content-nav">
				会议预定 > 预定会议
			</div>
			<form onsubmit="return validate()" action="BookMeetingServlet">

				<fieldset>
					<legend>
						会议信息
					</legend>
					<font color="red">${requestScope.msg}</font>
					<table class="formtable">
						<tr>
							<td>
								会议名称：
							</td>
							<td>
								<input type="text" name="meetingname" id="meetingname"
									maxlength="20" />
							</td>
						</tr>
						<tr>
							<td>
								预计参加人数：
							</td>
							<td>
								<input type="text" name="meetingpersonnum" id="meetingpersonnum" />
							</td>
						</tr>
						<tr>
							<td>
								预计开始时间：
							</td>
							<td>
								<input class="Wdate" type="text" name="meetingstarttime"
									id="meetingstarttime"
									onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />

							</td>
						</tr>
						<tr>
							<td>
								预计结束时间：
							</td>
							<td>
								<input class="Wdate" type="text" name="meetingendtime"
									id="meetingendtime"
									onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />

							</td>
						</tr>
						<tr>
							<td>
								选择会议室：
							</td>
							<td>
								<select id="roomid" name="roomid" onfocus="chooseMeetingRooms()">
									<option value="-1">
										请选择会议室
									</option>

								</select>
							</td>
						</tr>
						<tr>
							<td>
								会议说明：
							</td>
							<td>
								<textarea name="meetingremark" id="meetingremark" rows="5"></textarea>
							</td>
						</tr>
						<tr>
							<td>
								选择参会人员：
							</td>
							<td>
								<div id="divfrom">
									<select id="selDepartments" name="selDepartments"
										onchange="showEmployees()">
										<option>
											请选择部门
										</option>
									</select>
									<select id="selEmployees" name="selEmployees" multiple="true">
									</select>
								</div>
								<div id="divoperator">
									<input type="button" class="clickbutton" value="&gt;"
										onclick="selectEmployees()" />
									<input type="button" class="clickbutton" value="&lt;"
										onclick="deSelectEmployees()" />
								</div>
								<div id="divto">
									<select id="selSelectedEmployees" name="selSelectedEmployees"
										multiple="true">
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<td class="command" colspan="2">
								<input type="submit" class="clickbutton" value="预定会议" />
								<input type="reset" class="clickbutton" value="重置" />
							</td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
	</body>
</html>
