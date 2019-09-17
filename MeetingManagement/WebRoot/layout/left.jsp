<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="util.CommonConstant"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base>

		<title>CoolMeeting会议管理系统</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="styles/common02.css" />
	</head>

	<body>
		<div class="page-sidebar">
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">
					个人中心
				</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem">
						<a href="mymeetingtongzhi.jsp" target="main">最新通知</a>
					</li>
					<li class="sidebar-menuitem active">
						<a href="mybooking.jsp" target="main">我的预定</a>
					</li>
					<li class="sidebar-menuitem">
						<a href="mymeeting.jsp" target="main">我的会议</a>
					</li>
					
				</ul>
			</div>
        
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">
					人员管理
				</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem">
						<a href="department.jsp" target="main">部门管理</a>
					</li>
					<li class="sidebar-menuitem">
						<a href="employee.jsp" target="main">员工注册</a>
					</li>
					<li class="sidebar-menuitem">
						<a href="employeeshenpi.jsp" target="main">注册审批</a>
					</li>
					<li class="sidebar-menuitem"><!-- &status=5 -->
                        <a href="searchemployee.jsp" target="main">搜索员工</a>
					</li>
				</ul>
			</div>
          
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">
					会议预定
				</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem">
						<a href="addmeetingroom.jsp" target="main">添加会议室</a>
					</li>
					<li class="sidebar-menuitem">
						<a href="allmeetingroom.jsp"
							target="main">查看会议室</a>
					</li>
					<li class="sidebar-menuitem">
						<a href="bookmeeting.jsp" target="main">预定会议</a>
					</li>

				</ul>
			</div>
		</div>

	</body>
</html>
