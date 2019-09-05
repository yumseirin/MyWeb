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

		<title>My JSP 'success.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<%
			List<Person> list = (List<Person>) request.getAttribute("msg");
		%>
		<TABLE width="80%" border="2" cellspacing="0">
			<TR>
				<TD>
					用户编号
				</TD>
				<TD>
					用户名
				</TD>
				<TD>
					密码
				</TD>
				<TD>
					性别
				</TD>
				<TD>
					爱好
				</TD>
				<TD>
					操作
				</TD>
			</TR>
			<%
				for (Person p : list) {
					String sex = p.getSex();
					if (sex.equals("nan")) {
						sex = "男";
					} else {
						sex = "女";
					}
					String likes = p.getLikes();//绘画、音乐、跳舞
					String[] arr = likes.split(",");
					String like = "";
					for (String str : arr) {
						if (str.equals("huihua")) {
							like += "绘画 ";
						}
						if (str.equals("yinyue")) {
							like += "音乐 ";
						}
						if (str.equals("tiaowu")) {
							like += "跳舞 ";
						}
					}
			%>
			<TR>
				<TD><%=p.getPid()%></TD>
				<TD><%=p.getUname()%></TD>
				<TD><%=p.getPwd()%></TD>
				<TD><%=sex%></TD>
				<TD><%=like%></TD>
				<TD>
					<a href="select?pid=<%=p.getPid()%>">修改</a>&emsp;
					<a href="delete?pid=<%=p.getPid()%>">删除</a>
				</TD>
			</TR>
			<%
				}
			%>
		</TABLE>
		<br>
	</body>
</html>
