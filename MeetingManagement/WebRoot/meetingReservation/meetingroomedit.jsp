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

		<title>修改会议室信息</title>

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
				会议预定 > 修改会议室信息
			</div>
			<form onsubmit="" action="" method="post">

				<fieldset>
					<legend>
						会议室信息
					</legend>
					<table class="formtable">

						<tr>
							<td>
								门牌号:
							</td>
							<td>
								<input name="roomnum" id="roomnum" type="text" maxlength="10"
									value="" />
							</td>
						</tr>
						<tr>
							<td>
								会议室名称:
							</td>
							<td>
								<input name="roomname" id="roomname" type="text" maxlength="20"
									value="" />
							</td>
						</tr>
						<tr>
							<td>
								最多容纳人数：
							</td>
							<td>
								<input name="capacity" id="capacity" type="text" value="" />
							</td>
						</tr>
						<tr>
							<td>
								当前状态：
							</td>
							<td>

								<input type="radio" name="status" id="status" value="0"
									checked="checked" />
								<label for="status">
									启用
								</label>
								<input type="radio" name="status" id="status" value="1" />
								<label for="status">
									停用
								</label>


							</td>
						</tr>
						<tr>
							<td>
								备注：
							</td>
							<td>
								<textarea name="remark" id="remark" maxlength="200" rows="5"
									cols="60"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2" class="command">
								<input type="submit" value="确认修改" class="clickbutton" />
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
