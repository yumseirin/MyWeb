--create user meeting identified by xxxx;  --xxxx密码 --创建用户并设密码
--grant dba to meeting;  --给用户dba权限

--------------------------计数器表--------------------------------------------------------------------------------
CREATE TABLE counter (
  counterid number(11) NOT NULL ,
  visitcount number(11) NOT NULL,
  PRIMARY KEY  (counterid)
);
create sequence seq_counterid;

counterid  计数器id            主键自增
visitcount 计数器

--------------------部门表-------------------------------------------------------------------------------------


CREATE TABLE department (
  departmentid number(11) NOT NULL ,
  departmentname varchar2(50) default NULL,
  departmentstatus number(10) default NULL,
  PRIMARY KEY  (departmentid)
);
create sequence seq_departmentid;

departmentid    部门id        主键自增
departmentname    部门名称
departmentstatus  部门状态    0 正  1 非

----------------------------------员工表---------------------------------------------------------------------------------

CREATE TABLE employee (
  employeeid number(11) NOT NULL ,
  realname varchar2(20) default NULL,
  username varchar2(20) default NULL,
  password varchar2(20) default NULL,
  phone varchar2(20) default NULL,
  email varchar2(20) default NULL,
  departmentid number(11) default NULL,
  status number(11) default NULL,
  remark varchar2(200) default NULL,
  role number(11) default NULL,
  PRIMARY KEY  (employeeid)
);
create sequence seq_employeeid;

employeeid      员工id     主键自增
realname        员工真实姓名
username  用户名
password  密码
phone     联系电话
email     电子邮箱
departmentid  所属部门
status=0  status表示员工的状态，0表示正在审核，1表示审核通过，2表示审核未通过，默认为正在审核
remark    备注
role=2    role表示员工的角色，1表示为管理员，2表示为员工,默认为员工


-------------------------预定会议表---------------------------------------------------------------------------------

CREATE TABLE meeting (
  meetingid number(11) NOT NULL ,
  meetingname varchar2(20) NOT NULL,
  meetingpersonnum number(11) NOT NULL,
  meetingstarttime date default NULL,
  meetingendtime date default NULL,
  reservetime date default NULL,
  roomid number(11) default NULL,
  meetingremark varchar2(200) default NULL,
  reserveuserid number(10)  default NULL,
  meetingstatus number(11) default NULL,
  canceledtime date,
  canceledreason varchar2(200),
  PRIMARY KEY  (meetingid)
) ;
create sequence seq_meetingid;

meetingid         预定会议id         主键自增
meetingname         会议名称
meetingpersonnum    会议参加人数
meetingstarttime          会议开始时间
meetingendtime            会议结束时间
reservetime                     会议预定时间
roomid                          会议室id
meetingremark                   会议说明
reserveuserid                   会议预定人的id
meetingstatus                   会议状态
canceledtime                    取消时间
canceledreason                  取消原因

--------------------会议室表--------------------------------------------------------------------------------------------------

CREATE TABLE meetingroom (
  roomid number(11) NOT NULL ,
  roomnum varchar2(20) default NULL,
  roomname varchar2(20) default NULL,
  capacity number(11) default NULL,
  status number(11) default NULL,
  remark varchar2(255) default NULL,
  employeeid number(11) default NULL,
  PRIMARY KEY  (roomid) 
);
create sequence seq_roomid;

roomid          会议室id    主键自增
roomnum   门牌号
roomname  会议室名称
capacity  容纳人数
status    当前状态
remark    备注
employeeid  谁定的会议室
------------------------------参与会议人员表-------------------------------------------------------------------------


CREATE TABLE meetinguser (
  meetinguserid number(11) NOT NULL ,
  meetingid number(11) NOT NULL,
  employeeid number(11) NOT NULL,
  PRIMARY KEY  (meetinguserid),
  constraint  dd  FOREIGN KEY (meetingid) REFERENCES meeting (meetingid)
); 
create sequence seq_meetinguserid;

meetinguserid  参与会议人员表id     主键自增
meetingid      会议id
employeeid     要参与会议的员工id

----------------------------------------------------------------------------------------------------------------
