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
		<center>
			<%
				String tu = (String) request.getAttribute("tu");
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
						生日
					</TD>
					<TD>
						相片
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
					<TD><%=p.getBir()%></TD>
					<TD>
						<%
							if (p.getPicname() != null) {
						%>
						<img src="<%=basePath%>img/<%=p.getPicname()%>" width="400"
							height="400">
						<%
							} else {
						%>无附件<%
							}
						%>
					</TD>
					<TD>
						<a
							href="select?pid=<%=p.getPid()%>&
							page=<%=(Integer) request.getAttribute("page")%>">修改</a>
						&emsp;
						<a
							href="delete?pid=<%=p.getPid()%>&
							page=<%=(Integer) request.getAttribute("page")%>">删除</a>
					</TD>
				</TR>
				<%
					}
				%>
			</TABLE>
			<br>
			<TABLE border=2>
				<TR>
					<TD>
						第<%=(Integer) request.getAttribute("page")%>页/ 共<%=(Integer) request.getAttribute("zongyeshu")%>页
					</TD>

					<TD>
						<a href="fenye?p=1">首页</a>
					</TD>
					<TD>
						<a href="fenye?p=<%=(Integer) request.getAttribute("page") - 1%>">上一页</a>
					</TD>
					<TD>
						<a href="fenye?p=<%=(Integer) request.getAttribute("page") + 1%>">下一页</a>
					</TD>
					<TD>
						<a href="fenye?p=<%=(Integer) request.getAttribute("zongyeshu")%>">末页</a>
					</TD>
					<TD>
						<a href="">跳转到</a> 第
						<input type="text" name="jump" size="5">
						页

					</TD>
				</TR>
			</TABLE>
			<br>
		</center>
	</body>
</html>
