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
						账号名
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

				<tr>
					<td>
						张三
					</td>
					<td>
						zhangsan
					</td>
					<td>
						138445695221
					</td>
					<td>
						123456@qq.com
					</td>
					<td>
						<input type="button" class="clickbutton" value="通过"
							onclick="window.location.href='EmployeeShenpiServlet?code=yes&employeeid=${employeelist.employeeid}'" />
						<input type="button" class="clickbutton" value="删除"
							onclick="window.location.href='EmployeeShenpiServlet?code=no&employeeid=${employeelist.employeeid}'" />
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
