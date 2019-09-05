<%@ page language="java" import="java.util.*,vo.Person"
	pageEncoding="utf-8"%>
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
		<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js">
</script>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		<h2>
			修改
		</h2>
		<%
			Person p = (Person) request.getAttribute("msg");
			String sex = p.getSex();
			String sex1 = "";
			String sex2 = "";
			if (sex.equals("nan")) {
				sex1 = "checked";
			}
			if (sex.equals("nv")) {
				sex2 = "checked";
			}
			String[] like = p.getLikes().split(",");
			String like1 = "";
			String like2 = "";
			String like3 = "";
			for (String l : like) {
				if (l.equals("huihua")) {
					like1 = "checked";
				}
				if (l.equals("yinyue")) {
					like2 = "checked";
				}
				if (l.equals("tiaowu")) {
					like3 = "checked";
				}
			}
		%>
		<form action="update" method="post">
			<input type="hidden" name="pid" value="<%=p.getPid()%>">
			用户名：
			<input type="text" name="uname" value="<%=p.getUname()%>" />
			<br>
			密码：
			<input type="password" name="pwd" value="<%=p.getPwd()%>" />
			<br>
			性别：
			<input type="radio" value="nan" name="sex" <%=sex1%> />
			男
			<input type="radio" value="nv" name="sex" <%=sex2%> />
			女
			<br>
			爱好：
			<input type="checkbox" value="huihua" name="like" <%=like1%> />
			绘画
			<input type="checkbox" value="yinyue" name="like" <%=like2%> />
			音乐
			<input type="checkbox" value="tiaowu" name="like" <%=like3%> />
			跳舞
			<br>
			生日：
			<input type="text" name="bir" value="<%=p.getBir()%>"
				onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
			<br>
			<input type="submit" value="更改" />
		</form>
	</body>
</html>
