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

		<title>添加会议室</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="styles/common.css" />

	</head>

	<body>
		<div class="page-content">
			<div class="content-nav">
				会议预定 > 添加会议室
			</div>

			<form action="" method="post">

				<fieldset>
					<legend>
						会议室信息
					</legend>

					<table class="formtable" style="width: 70%" border="0">
						<tr>
							<td>
								门牌号:
							</td>
							<td>
								<input type="text" name="roomnum" id="roomnum" maxlength="10" />
							</td>
						</tr>
						<tr>
							<td>
								会议室名称:
							</td>
							<td>
								<input type="text" name="roomname" id="roomname" maxlength="20" />
							</td>
						</tr>
						<tr>
							<td>
								最多容纳人数：
							</td>
							<td>
								<input type="text" name="capacity" id="capacity" />
							</td>
						</tr>
						<tr>
							<td>
								当前状态：
							</td>
							<td>
								<input type="radio" name="status" id="status" value="1"
									checked="checked" />
								<label for="status">
									启用
								</label>
								<input type="radio" name="status" id="status" value="0" />
								<label for="status" value="0">
									停用
								</label>

							</td>
						</tr>
						<tr>
							<td>
								备注：
							</td>
							<td>
								<textarea name="remark" id="remark" rows="3" cols="20"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2" class="command">

								<input type="submit" value="添加" class="clickbutton" />
								<input type="reset" value="重置" class="clickbutton" />
							</td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
	</body>
</html>
