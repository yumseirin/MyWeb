<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
		<center>
			<table width="80%" border="1px" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						姓名
					</td>
					<td>
						密码
					</td>
					<td>
						生日
					</td>
					<td>
						电话
					</td>
				</tr>


				<c:forEach var="p" items="${sessionScope.list}">
					<TR>

						<TD>
							${p.uname}
						</TD>
						<TD>
							${p.pwd}
						</TD>
						<TD>
							<fmt:formatDate value="${p.bir}" type="both" />
						</TD>
						<TD>
							<c:forTokens items="${p.call}" delims="-" step="1" var="v"
								varStatus="vs">
								${v}&nbsp;&nbsp;
							</c:forTokens>
						</TD>
					</TR>
				</c:forEach>
			</table>
		</center>
	</body>
</html>
