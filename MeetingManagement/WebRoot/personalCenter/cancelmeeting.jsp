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
				u会议预定 &gt; 撤销会议预定
			</div>
			<form action="CheXiaoMeetingServlet" onclick="">
				<input type="hidden" name="code" value="update">
				<input type="hidden" name="meetingid" value="${param.meetingid}">
				<fieldset>
					<legend>
						撤销预定
					</legend>
					<table class="formtable">
						<tr>
							<td>
								会议名称：
							</td>
							<td>
								技术部大会
							</td>
						</tr>
						<tr>
							<td>
								撤销理由：
							</td>

							<td>
								<textarea name="meetingremark" id="meetingremark" rows="5"></textarea>
							</td>
						</tr>
						<tr>
							<td class="command" colspan="2">
								<input type="submit" class="clickbutton" value="确认撤销" />
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
