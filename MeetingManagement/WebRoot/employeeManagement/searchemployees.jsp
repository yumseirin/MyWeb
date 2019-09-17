<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="vo.Employee,vo.Page"%>
<%@ page import="util.CommonConstant"%>
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

		<title>搜索员工</title>

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
				会议预定 > 搜索员工
			</div>
			<form action="" method="post">

				<!-- 每页显示多少条 -->
				<fieldset>
					<legend>
						搜索会议
					</legend>
					<table class="formtable">
						<tr>
							<td>
								姓名：
							</td>
							<td>
								<input type="text" name="realname" id="realname" maxlength="20" />
							</td>
							<td>
								账号名：
							</td>
							<td>
								<input type="text" name="username" id="username" maxlength="20" />
							</td>
							<td>
								状态：
							</td>
							<td>
								<%
									String status = request.getParameter("status");
								%>
								<input type="radio" id="status" name="status" value="" />
								<label>
									已批准
								</label>

								<input type="radio" id="status" name="status" value="" />

								<label>
									待审批
								</label>



								<label>
									已关闭
								</label>

								<input type="radio" id="status" name="status" value="" />
								<label>
									所有
								</label>

							</td>
						</tr>
						<tr>
							<td colspan="6" class="command">
								<input type="submit" class="clickbutton" value="查询" />
								<input type="reset" class="clickbutton" value="重置" />
							</td>
						</tr>
					</table>
				</fieldset>
			</form>

			<div>
				<h3 style="text-align: center; color: black">
					查询结果
				</h3>
				<div class="pager-header">
					<div class="header-info">
						共
						<span class="info-number">100</span>条结果， 分成
						<span class="info-number">10</span>页显示， 当前第
						<span class="info-number">1</span>页
					</div>
					<div class="header-nav">

						<a href="">首页</a>
						<a href="">上页</a>

						<a href="">下页</a>
						<a href="">末页</a> 跳到第
						<input type="text" name="pagenow" id="pagenow" class="nav-number" />
						页
						<input type="button" class="clickbutton" value="跳转" onclick="" />
					</div>
				</div>
			</div>
			<table class="listtable">
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
						12345648978
					</td>
					<td>
						789@qq.com
					</td>
					<td>

						帐号已关闭
						<a class="">关闭账号</a>(二选一)

					</td>
				</tr>


			</table>
		</div>
	</body>
</html>
