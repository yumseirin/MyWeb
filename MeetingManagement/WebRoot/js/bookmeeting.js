//------预订会议表单验证----------------------------------------------------------------------------------
function validate() {

	var meetingname = document.getElementById("meetingname").value;
	var meetingpersonnum = document.getElementById("meetingpersonnum").value;
	var meetingstarttime = document.getElementById("meetingstarttime").value;
	var meetingendtime = document.getElementById("meetingendtime").value;

	if (trim(meetingname) == "") {
		alert("会议名称不能为空！");
		document.getElementById("meetingname").focus();
		return false;
	}
	if (trim(meetingpersonnum) == "") {
		alter("预计参加人数不能为空");
		document.getElementById("meetingpersonnum").focus();
		return false;
	}
	if (isNum(meetingpersonnum)) {
		alert("预计参加人数只能是数字");
		return false;
	}

	if (trim(meetingstarttime) == "") {
		alert("预计开始时间不能为空！");
		document.getElementById("meetingstarttime").focus();
		return false;
	}
	if (trim(meetingendtime) == "") {
		alert("预计结束时间不能为空！");
		document.getElementById("meetingendtime").focus();
		return false;
	}

}

//非空校验 
function trim(str) {

	return str.replace(/(^\s+)|(\s+$)/g, "");

}
//是否是数字
function isNum(str) {
	var i;
	for (i = 0; i < str.length; i++) {
		var ch = str.charAt(i);
		if ((ch < '0' || ch > '9') && ch != '.') {
			return true;
		}
	}
	return false;
}

//---------------------Ajax---------------------------------------------------------------------------------
/*
 * $(function() {
 $("#selDepartments").ready(function() {//ready放在jsp页面才有效不然加载页面时无法触发

 department();
 });
 });
 function department() {
 $.post("GetDepServlet", {}, callBackDepartmentSuccess);
 }
 function callBackDepartmentSuccess(data) {
 var str = "<option value=\"-1\">请选择部门</option>";
 if (data != null && data != "") {
 for ( var i = 0; i < data.length; i++) {
 str += "<option value=\"" + data[i].departmentid + "\">" + data[i].departmentname
 + "</option>"
 }
 $("#selDepartments").html("");
 $("#selDepartments").append(str);
 }
 }
 */
//+++++++++++++++++++++++++获得部门++++++++++++++++++++++++++++++++++
//选择参会人员
/*
 var xmlHttp; //声明一个空对象以接收XMLHttpRequest对象

 function createXMLHttpRequest() 
 {
 if (window.ActiveXObject) //IE浏览器
 {
 xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
 } 
 else if (window.XMLHttpRequest) //除IE外的其他浏览器实现
 {
 xmlHttp = new XMLHttpRequest();                
 }
 }
 */
//++++++++++++++++++选择参会人员   请选择部门++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++     
function showEmployees() 
        {                     
            var deptid=$("#selDepartments").val();  //得到选择的部门
       		if(deptid=="-1") 
       		{
       			$("#selEmployees").html("");
       		}
       		else{
       		$.post("SelectEmployeesOfDeptServlet", {
					deptid : deptid
			}, callEmployeesOfDeptback);
       		}
        }

        function callEmployeesOfDeptback(data) 
        {
        	clearEmployees();
		    var str="";
			if (data != null && data != "") {
				for(var  i=0;i<data.length;i++) {
				str+="<option value=\""+data[i].employeeid+"\">"+data[i].realname+"</option>";
			}
				$("#selEmployees").html("");
				$("#selEmployees").append(str);
			}
        }
        
        function clearEmployees()//部门里的人员清空
        {
         	document.getElementById("selEmployees").options.length=0;//选中的部门下的员工
        }
        
//++++++++++++++++   >  右移 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
         function selectEmployees()
         {        
         		var selEmployees=document.getElementById("selEmployees");//选中的部门下的员工
         		var selSelectedEmployees=document.getElementById("selSelectedEmployees");  //最终选中参加会议的员工
         	    for(var i=0;i<selEmployees.options.length;i++)
                {
                    if (selEmployees.options[i].selected)
                    {
                        var opt=new Option(selEmployees.options[i].text,selEmployees.options[i].value);
                        opt.selected=true;
                        selSelectedEmployees.options.add(opt);
                        selEmployees.options.remove(i);
                    }
                }
            }
            
//++++++++++++++++   < 左移 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
        function deSelectEmployees()
        {
        		var selEmployees=document.getElementById("selEmployees");//选中的部门下的员工
         		var selSelectedEmployees=document.getElementById("selSelectedEmployees");  //最终选中参加会议的员工   
                for(var i=0;i<selSelectedEmployees.options.length;i++)
                {
                    if (selSelectedEmployees.options[i].selected)
                    {
                        selEmployees.options.add(new Option(selSelectedEmployees.options[i].text,selSelectedEmployees.options[i].value));
                        selSelectedEmployees.options.remove(i);
                    }
                }
                setSelected();
         }     
             
        function setSelected()
        {
         		var selSelectedEmployees=document.getElementById("selSelectedEmployees");  //最终选中参加会议的员工   
                for(var i=0;i<selSelectedEmployees.options.length;i++)
                {
                    selSelectedEmployees.options[i].selected=true;
                }
        }

//++++++++++++++++++选择会议室 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++   
        function chooseMeetingRooms()
        { 
        	var meetingpersonnum=document.getElementById("meetingpersonnum").value;   //参会人数
	        var meetingstarttime=document.getElementById("meetingstarttime").value;  //预计开始时间	
	        var meetingendtime=document.getElementById("meetingendtime").value;     //预计结束时间
	        
	        if(meetingpersonnum =="")
	        {
	           alert("请选择预计参加人数");
	           $("#roomid").blur();
	           return false;
	        }
	        if(meetingstarttime =="")
	        {
	           alert("请选择会议预计开始时间");
	           $("#roomid").blur();
	           return false;
	        }
	        if(meetingendtime =="")
	        {
	           alert("请选择会议预计结束时间");
	           $("#roomid").blur();
	           return false;
	        }
	        if(meetingstarttime==meetingendtime || meetingendtime< meetingstarttime)
	        {
	           alert("起始结束时间有误！");
	           $("#roomid").blur();
	           return false;
	        }
	        $.post("ChooseMeetingRoomsServlet", {
	        		meetingpersonnum : meetingpersonnum,
					meetingstarttime : meetingstarttime,
					meetingendtime :meetingendtime
			}, callBackRoomsSuccess);
        }      
        function callBackRoomsSuccess(data) {
	     	var str="";
			if (data != null && data != "") {
		 	for(var  i=0;i<data.length;i++){
		    str+="<option value=\""+data[i].roomid+"\">"+data[i].roomname+"</option>"
		    }
			$("#roomid").html("");
		    $("#roomid").append(str);
			}
		}
        /*
         function refresh()
          {
  		  clearMeetingRooms(); //清空下拉列表中上次查出来的内容
          var roomid=document.getElementById("roomid"); //得到选择会议室的下拉列表中的值
          if (xmlHttp.readyState == 4) 
          {
             if (xmlHttp.status == 200) 
             {
                	
                 var elements = xmlHttp.responseXML.getElementsByTagName("option"); //得到生成的xml中的option节点的内容                     
                 for (var i = 0; i < elements.length; i++) 
                 {
	                 var value = elements[i].getElementsByTagName("value")[0].firstChild.nodeValue;//取option节点下的<value>的值   
	                 var text = elements[i].getElementsByTagName("text")[0].firstChild.nodeValue;//取option节点下的<text>的值                
	                 roomid.options.add(new Option(text,value),i+1);//为下接列表赋值
                 }       
            }
       }
        
    }
    function clearMeetingRooms()
    {
        document.getElementById("roomid").options.length=1;
         	
    }
    */
        
             