<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>撤销会议预定</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="styles/common.css">


	</head>

	<body>
		<div class="page-content">
			<div class="content-nav">
				会议预定 &gt; 撤销会议预定
			</div>
			<form action="DoCancelMeetingServlet" method="post">
				<fieldset>
					<legend>
						撤销预定
					</legend>
					<table class="formtable">
						<tr>
							<td>
							<input type="hidden" name="mid" value="${m.meetingid}" />
							
								会议名称：
							</td>
							<td>
								${m.meetingname}
							</td>
						</tr>
						<tr>
							<td>
								撤销理由：
							</td>
							<td>
								<textarea id="description" rows="5" name="canceledreason"></textarea>
							</td>
						</tr>
						<tr>
							<td class="command" colspan="2">
								<input type="submit" class="clickbutton" value="确认撤销"></input>
								<input type="button" class="clickbutton" value="返回"
									onclick="window.history.back();" />
							</td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
	</body>
</html>
