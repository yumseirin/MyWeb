<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	HttpSession s = request.getSession();
	Object obj = s.getAttribute("person");
	if (obj == null) {
		request.setAttribute("msg", "请重新登录");
		request.getRequestDispatcher("../index.jsp").forward(request,
				response);
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'admin.jsp' starting page</title>

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
		<a href="loginoff">退出</a>
		<%
			///request.getAttribute("list");//JSTL+EL
		%>
		<table border="1">
			<tr>
				<td>
					name
				</td>
				<td>
					pwd
				</td>
			</tr>
			<c:forEach items="${requestScope.list}" var="p">
				<TR>
					<c:if test="${p.uname == 'aa'}">
						<TD>
							${p.uname}是坏蛋！
						</TD>
					</c:if>
					<c:if test="${p.uname !='aa'}">
						<TD>
							${p.uname}是好蛋！
						</TD>
					</c:if>
					<c:if test="${p.pwd == '123'}">
						<TD>
							${p.pwd}对的
						</TD>
					</c:if>
					<c:if test="${p.pwd != '123'}">
						<TD>
							${p.pwd}错的
						</TD>
					</c:if>
				</TR>
			</c:forEach>
		</table>
		<br>
	</body>
</html>
