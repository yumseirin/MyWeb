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

		<title>添加会议室</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="styles/common.css" />
		<script type="text/javascript" src="js/jquery-1.8.3.min.js">
</script>
		<script type="text/javascript">
function addmeetingroomvalidate() {
	document.getElementById("sproomnum").innerHTML = "";
	document.getElementById("sproomname").innerHTML = "";
	document.getElementById("spcapacity").innerHTML = "";
	document.getElementById("spremark").innerHTML = "";
	
	var roomnum = document.getElementById("roomnum").value;
	var roomname = document.getElementById("roomname").value;
	var capacity = document.getElementById("capacity").value;
	var remark = document.getElementById("remark").value;	
	
	if (trim(roomnum) == "") {
		document.getElementById("sproomnum").innerHTML = "门牌号不能为空！";
		document.getElementById("roomnum").focus();
		return false;
	}
	var capacityValue="";
	if (trim(roomname) == "") {
		document.getElementById("sproomname").innerHTML = "会议室名称不能为空！";
		document.getElementById("roomname").focus();
		return false;
	}
	if (trim(capacity) == "") {
		document.getElementById("spcapacity").innerHTML = "容纳人数不能为空！";
		document.getElementById("capacity").focus();
		return false;
	}
	if (!/^[1-9][0-9]*$/.test(capacity)){
		document.getElementById("spcapacity").innerHTML = "请输入非零正整数！";
		document.getElementById("capacity").focus();
		return false;
	}
	if (stringLength(remark)>200){
		document.getElementById("spremark").innerHTML = "请输入100字以内的文字！";
		document.getElementById("remark").focus();
		return false;
	}
}
//去掉前后空格
function trim(str) {
	return str.replace(/(^\s+)|(\s+$)/g, "");//去除前后空格
}
//计算字符长度，汉字占两位
function stringLength(str){
	var len = 0;  
    for (var i=0; i<str.length; i++) {  
        if (str.charCodeAt(i)>127 || str.charCodeAt(i)==94) {  
             len += 2;  
         } else {  
             len ++;  
         }  
     }
    return len; 
}
</script>
	</head>

	<body>
		<div class="page-content">
			<div class="content-nav">
				会议预定 > 添加会议室
			</div>

			<form onsubmit="return addmeetingroomvalidate();"
				action="AddMeetingRoomServlet" method="post">

				<fieldset>
					<legend>
						会议室信息
					</legend>

					<table class="formtable" style="width: 70%" border="0">
						<c:if test="${error!=null}">
							<tr>
								<td colspan="2">
									<font color="red">${error}</font>
								</td>
							</tr>
						</c:if>
						<tr>
							<td>
								门牌号:
							</td>
							<td>
								<input type="text" name="roomnum" id="roomnum"
									placeholder="例如：201" maxlength="10" />
								<span id="sproomnum" style="color:red;"></span>
							</td>
						</tr>
						<tr>
							<td>
								会议室名称:
							</td>
							<td>
								<input type="text" name="roomname" id="roomname"
									placeholder="例如：第一会议室" maxlength="20" />
								<span id="sproomname" style="color:red;"></span>
							</td>
						</tr>
						<tr>
							<td>
								最多容纳人数：
							</td>
							<td>
								<input type="text" name="capacity" id="capacity"
									placeholder="填写一个正整数" />
								<span id="spcapacity" style="color:red;"></span>
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
								<textarea name="remark" id="remark" rows="3" cols="20"
									placeholder="100字以内的文字描述"></textarea>
								<span id="spremark" style="color:red;"></span>
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
