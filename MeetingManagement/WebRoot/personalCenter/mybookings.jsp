<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="vo.Meeting"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的预定</title>
    
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
                    个人中心 > 我的预定
                </div>
                <table class="listtable">
                    <caption>我预定的会议：</caption>
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>操作</th>
                    </tr>
                  
                  
                      <tr>
                        <td>年终总结</td>
                        <td>1号会议室</td>
                        <td>2019-10-1</td>
                        <td>2019-10-6</td>
                        <td>2019-9-4</td>
                        <td>       
                                <a class="clickbutton" href="mybookingdetail.jsp">查看/取消</a>
                         
                          
                             
                          
                         </td>
                     </tr>
                 
                </table>
            </div>
  </body>
</html>
