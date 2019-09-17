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

		<title>修改会议预定</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="styles/common03.css">


	</head>

	<body>
		<div class="page-content">
			<div class="content-nav">
				会议预定 > 修改会议预定
			</div>
			<form method="post" action="">
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
								年终总结
							</td>
						</tr>
						<tr>
							<td>
								预计参加人数：
							</td>
							<td>
								200
							</td>
						</tr>
						<tr>
							<td>
								预计开始时间：
							</td>
							<td>
								2019-10-10 10：20：11
							</td>
						</tr>
						<tr>
							<td>
								预计结束时间：
							</td>
							<td>
								2019-10-10 11：20：11
							</td>
						</tr>
						<tr>
							<td>
								会议说明：
							</td>
							<td>
								<textarea id="description" rows="5" readonly>年终xxxxx</textarea>
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

									<tr>
										<td>
											张三
										</td>
										<td>
											1234565
										</td>
										<td>
											7869@qq.com
										</td>
									</tr>

									<tr>
										<td>
											张三1
										</td>
										<td>
											123456
										</td>
										<td>
											7897@qq.com
										</td>
									</tr>

									<tr>
										<td>
											张三2
										</td>
										<td>
											1234565
										</td>
										<td>
											7889@qq.com
										</td>
									</tr>


								</table>
							</td>
						</tr>
						<tr>

							<td class="command" colspan="2">
								<input type="hidden" name="meetingid" value="ddd">

								<input type="button" class="clickbutton" value="撤销会议"
									onclick="window.location.href='chexiaomeeting.jsp';" />

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
