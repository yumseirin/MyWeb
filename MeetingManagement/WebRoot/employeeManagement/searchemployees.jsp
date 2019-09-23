<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="vo.Employee,vo.Page"%>
<%@ page import="util.CommonConstant"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<form action="SearchEmployeeServlet" method="post">

				<!-- 每页显示多少条 -->
				<fieldset>
					<legend>
						搜索员工
					</legend>
					<table class="formtable">
						<tr>
							<td>
								姓名：
							</td>
							<td>
								<input type="text" name="realname" id="realname" value="${realname}" maxlength="20" />
							</td>
							<td>
								用户名：
							</td>
							<td>
								<input type="text" name="username" id="username" value="${username}" maxlength="20" />
							</td>
							<td>
								状态：
							</td>
							<td>
								<c:choose>
                                <c:when test="${status==0}">
                                    <input type="radio" id="status" name="status" value="1"/><label>已批准</label>
                                    <input checked="checked" type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    <input type="radio" id="status" name="status" value="4"/><label>已关闭</label>
                                    <input type="radio" id="status" name="status" value="5" /><label>所有</label>
                                </c:when>
                                <c:when test="${status==1}">
                                    <input type="radio" checked="checked" id="status" name="status" value="1"/><label>已批准</label>
                                    <input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    <input type="radio" id="status" name="status" value="4"/><label>已关闭</label>
                                    <input type="radio" id="status" name="status" value="5" /><label>所有</label>
                                </c:when>
                                <c:when test="${status==4}">
                                    <input type="radio" id="status" name="status" value="1"/><label>已批准</label>
                                    <input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    <input type="radio" checked="checked" id="status" name="status" value="4"/><label>已关闭</label>
                                    <input type="radio" id="status" name="status" value="5" /><label>所有</label>
                                </c:when>
                                <c:when test="${status==5}">
                                    <input type="radio" id="status" name="status" value="1"/><label>已批准</label>
                                    <input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    <input type="radio" id="status" name="status" value="4"/><label>已关闭</label>
                                    <input type="radio" checked="checked" id="status" name="status" value="5" /><label>所有</label>
                                </c:when>
                            </c:choose>
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
						<span class="info-number">${totalCount}</span>条结果， 分成
						<span class="info-number">${totalPage}</span>页显示， 当前第
						<span class="info-number">${page}</span>页
					</div>
					<div class="header-nav">
						<a href="<%=basePath%>/SearchEmployeeServlet?page=1&status=${status}&realname=${realname}&username=${username}">首页</a>
						<c:choose>
	                        <c:when test="${page>1}">
								<a href="<%=basePath%>/SearchEmployeeServlet?page=${page-1}&status=${status}&realname=${realname}&username=${username}">上页</a>
							</c:when>
	                        <c:otherwise>
	                           	上页
	                        </c:otherwise>
                    	</c:choose>
                    	<c:choose>
	                        <c:when test="${page<totalPage}">
								<a href="<%=basePath%>/SearchEmployeeServlet?page=${page+1}&status=${status}&realname=${realname}&username=${username}">下页</a>
							</c:when>
	                        <c:otherwise>
	                         	下页
	                        </c:otherwise>
                    	</c:choose>
						<a href="<%=basePath%>/SearchEmployeeServlet?page=${totalPage}&status=${status}&realname=${realname}&username=${username}">末页</a> 跳到第
						<form action="<%=basePath%>/SearchEmployeeServlet" method="post" style="display: inline">
                        <input type="hidden" name="realname" value="${realname}">
                        <input type="hidden" name="username" value="${username}">
                        <input type="hidden" name="status" value="${status}">跳到第
                        <input type="text" id="pagenum" name="page" class="nav-number"/>页
                        <input type="submit" class="clickbutton" value="跳转"/>
                    </form>
					</div>
				</div>
			</div>
			<table class="listtable">
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
							<form method="post" action="SearchEmployeeServlet">
								<input type="hidden" name="realname" value="${realname}">
								<input type="hidden" name="username" value="${username}">
								<input type="hidden" name="status" value="${status}">
								<input type="hidden" name="empid" value="${emp.employeeid}">
								<c:choose>
		                        	<c:when test="${status==4}">
		                        		<input type="hidden" name="updateStatus" value="0">
			                         	<!-- 开启账号后需要重新审核 -->
										<input class="clickbutton" value="开启账号" type="submit"></input>
									</c:when>
			                        <c:otherwise>
			                         	<input type="hidden" name="updateStatus" value="4">
										<input class="clickbutton" value="关闭账号" type="submit"></input>
			                        </c:otherwise>
                    			</c:choose>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>
