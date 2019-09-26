<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<title>My JSP 'meetingdetails.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="styles/common.css" />
		<style type="text/css">
</style>

	</head>

	<body>
		<div class="page-content">
			<div class="content-nav">
				会议预定 &gt; 会议信息
			</div>
			<form>
				<fieldset>
					<legend>
						会议信息
					</legend>
					<table class="formtable">
						<tr>
							<td>
								会议名称：
							</td>
							<td>
								${mt.meetingname}
							</td>
						</tr>
						<tr>
							<td>
								预计参加人数：
							</td>
							<td>
								${mt.meetingpersonnum}
							</td>
						</tr>
						<tr>
							<td>
								预计开始时间：
							</td>
							<td>
								${mt.meetingstarttime}
							</td>
						</tr>
						<tr>
							<td>
								预计结束时间：
							</td>
							<td>
								${mt.meetingendtime}
							</td>
						</tr>
						<tr>
							<td>
								会议说明：
							</td>
							<td>
								<textarea id="description" rows="5" readonly>${mt.meetingremark}</textarea>
							</td>
						</tr>
						<tr>
							<td>
								参会人员：
							</td>
							<td>
								<table class="listtable">
									<tr class="listheader">
										<th>
											姓名
										</th>
										<th>
											联系电话
										</th>
										<td>
											电子邮件
										</td>
									</tr>
									<c:forEach items="${emps}" var="emp">
										<tr>
											<td>
												${emp.realname}
											</td>
											<td>
												${emp.phone}
											</td>
											<td>
												${emp.email}
											</td>
										</tr>
									</c:forEach>
								</table>
							</td>
						</tr>
						<tr>
							<tr>
								<td class="command" colspan="2">
									<c:if test="${type=='cancel'}">
										<input type="button" class="clickbutton" value="撤销会议"
											onclick="window.location.href='CancelMeetingServlet?mid=${mt.meetingid}';" />
									</c:if>
									<input type="button" class="clickbutton" value="返回"
										onclick="window.history.back();" />
								</td>
							</tr>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
	</body>
</html>
