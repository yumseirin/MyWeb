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

		<title>注册审批</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">


		<link rel="stylesheet" href="styles/common.css" />

	</head>

	<body>
		<div class="page-content">
			<div class="content-nav">
				人员管理 > 注册审批
			</div>
			<table class="listtable">
				<caption>
					所有待审批注册信息：
				</caption>
				<tr class="listheader">
					<th>
						姓名
					</th>
					<th>
						用户名
					</th>
					<th>
						联系电话
					</th>
					<th>
						电子邮件
					</th>
					<th>
						操作
					</th>
				</tr>

				<c:forEach items="${list}" var="emp">
					<tr>
						<td>
							${emp.realname}
						</td>
						<td>
							${emp.username}
						</td>
						<td>
							${emp.phone}
						</td>
						<td>
							${emp.email}
						</td>
						<td>
							<a class="clickbutton"
								href="<%=basePath%>UpdateEmpStatusServlet?status=1&empid=${emp.employeeid}">通过</a>
							<a class="clickbutton"
								href="<%=basePath%>UpdateEmpStatusServlet?status=2&empid=${emp.employeeid}">不通过</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
