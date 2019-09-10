<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	/*HttpSession s = request.getSession();
	Object obj = s.getAttribute("person");
	if (obj == null) {
		request.setAttribute("msg", "请重新登录");
		request.getRequestDispatcher("../index.jsp").forward(request,
				response);
	}*/
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
		<div align="right">
			<!--  欢迎您，${sessionScope.person.uname }！您是第<%=(Integer) application.getAttribute("count")%>个访问者
				  <br>
			-->
			欢迎您，${sessionScope.person.uname }！您是第${applicationScope.count }个访问者
			<br>
		</div>
		<p align="right">
			<a href="loginoff">退出</a>
		</p>
		<%
			///request.getAttribute("list");//JSTL+EL
		%>
		<center>
			<table border="1">
				<tr>
					<td>
						name
					</td>
					<td>
						pwd
					</td>
					<td>
						bir
					</td>
					<td colspan="3">
						call
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
						<td>
							<fmt:formatDate value="${p.bir}" type="both"></fmt:formatDate>
							<fmt:formatDate value="${p.bir}" type="date" />
							<fmt:formatDate value="${p.bir}" type="time" />
						</td>
						<c:forTokens items="${p.call}" delims="-" step="1" varStatus="s"
							var="c">
							<td>
								${s.count }:${c}
							</td>
						</c:forTokens>
					</TR>
				</c:forEach>
			</table>
		</center>
		<br>
	</body>
</html>
