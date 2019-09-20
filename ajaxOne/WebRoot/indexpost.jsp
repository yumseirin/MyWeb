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

		<title>My JSP 'indexpost.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="js/jquery-1.8.3.min.js">
</script>
		<script type="text/javascript">
function resetShiQu() {
	$("#shi").html("<option value=\"-1\">请选择市</option>");
	$("#qu").html("<option value=\"-1\">请选择区</option>");
}
function resetQu() {
	$("#qu").html("<option value=\"-1\">请选择区</option>");
}
$(function() {
	$("#sheng").ready(function() {
		sheng();
	});
});

function sheng() {
	$.post("ShengServlet", {}, callBackShengSuccess);
}

function callBackShengSuccess(data) {

	var str = "<option value=\"-1\">请选择省</option>";
	if (data != null && data != "") {
		for ( var i = 0; i < data.length; i++) {
			str += "<option value=\"" + data[i].id + "\">" + data[i].name
					+ "</option>"
		}
		$("#sheng").html("");
		$("#sheng").append(str);
		resetShiQu();
	}
}

$(function() {
	$("#sheng").change(function() {
		shi();
	});
});

function shi() {

	//ajax  ----json---市长叶子
	var sheng = $("#sheng").val();
	if (sheng == -1) {
		resetShiQu();
	} else {
		$.post("ShiServlet", {
			sheng : sheng
		}, callBackShiSuccess);
	}
}

/*
 [
 {"id":1,"name":"a1shi","pid":0,"status":0},
 {"id":1,"name":"a2shi","pid":0,"status":0}
 ]
 */
function callBackShiSuccess(data) {
	/*
	 <option value="">
	 请选择省
	 </option>
	 <option value="">
	 请选择省
	 </option>
	 */
	var str = "<option value=\"-1\">请选择市</option>";
	if (data != null && data != "") {
		for ( var i = 0; i < data.length; i++) {
			str += "<option value=\"" + data[i].id + "\">" + data[i].name
					+ "</option>"
		}
		$("#shi").html("");
		$("#shi").append(str);
		resetQu();
	}
}

$(function() {
	$("#shi").change(function() {
		qu();
	});
});

function qu() {

	var shi = $("#shi").val();
	if (shi == -1) {
		resetQu();
	} else {
		$.post("QuServlet", {
			shi : shi
		}, callBackQuSuccess);
	}
}

function callBackQuSuccess(data) {

	var str = "<option value=\"-1\">请选择区</option>";
	if (data != null && data != "") {
		for ( var i = 0; i < data.length; i++) {
			str += "<option value=\"" + data[i].id + "\">" + data[i].name
					+ "</option>"
		}
		$("#qu").html("");
		$("#qu").append(str);
	}
}
</script>

	</head>

	<body>
		<form>
			省：
			<select id="sheng">

			</select>
			<br />
			市：
			<select id="shi">

			</select>
			<br />
			区：
			<select id="qu">

			</select>
			<br />
		</form>
	</body>
</html>
