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

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<script src="js/jquery-1.8.3.min.js" type="text/javascript">
</script>


		<script type="text/javascript">

function bb() {
	alert("sss");
	var uname = $("#uname").val();

	/*  $.ajax( {
		type : "GET",
		url : "ZyServlet?nn="+uname,
		dataType : "json",
		success : function(data) { //var  date={"msg":"用户名可以使用"};
		
		 $("#b").html(data.msg);
			
	},
	error : function(jqXHR) {
		alert("发生错误：" + jqXHR.status);
	}
	});*/

	$.ajax( {
		type : "POST",
		url : "ZyServlet",
		data : { //参数
			uname : uname
			
		},

		dataType : "json",
		success : function(data) { //var  date={"msg":"用户名可以使用"};

			$("#b").html(data.msg);

		},
		error : function(jqXHR) {
			alert("发生错误：" + jqXHR.status);
		}
	});

}
</script>

	</head>

	<body>
		<form onload="bb()">
			用户名：
			<input type="text" name="uname" id="uname" onblur="bb()" />
			<font color="red"><span id="b"></span> </font>

			<input type="button" value="xxx" onclick="bb()">

		</form>
	</body>
</html>
