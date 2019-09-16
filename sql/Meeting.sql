--create user meeting identified by meeting;
--grant dba to meeting;

--------------------------��������--------------------------------------------------------------------------------
CREATE TABLE counter (
  counterid number(11) NOT NULL ,
  visitcount number(11) NOT NULL,
  PRIMARY KEY  (counterid)
);
create sequence seq_counterid;

counterid  ������id            ��������
visitcount ������

--------------------���ű�-------------------------------------------------------------------------------------


CREATE TABLE department (
  departmentid number(11) NOT NULL ,
  departmentname varchar2(50) default NULL,
  departmentstatus number(10) default NULL,
  PRIMARY KEY  (departmentid)
);
create sequence seq_departmentid;

departmentid    ����id        ��������
departmentname    ��������
departmentstatus  ����״̬    0 ��  1 ��

----------------------------------Ա����---------------------------------------------------------------------------------

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

employeeid      Ա��id     ��������
realname        Ա����ʵ����
username  �û���
password  ����
phone     ��ϵ�绰
email     ��������
departmentid  ��������
status=0  status��ʾԱ����״̬��0��ʾ������ˣ�1��ʾ���ͨ����2��ʾ���δͨ����Ĭ��Ϊ�������
remark    ��ע
role=2    role��ʾԱ���Ľ�ɫ��1��ʾΪ����Ա��2��ʾΪԱ��,Ĭ��ΪԱ��


-------------------------Ԥ�������---------------------------------------------------------------------------------

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

meetingid         Ԥ������id         ��������
meetingname         ��������
meetingpersonnum    ����μ�����
meetingstarttime          ���鿪ʼʱ��
meetingendtime            �������ʱ��
reservetime                     ����Ԥ��ʱ��
roomid                          ������id
meetingremark                   ����˵��
reserveuserid                   ����Ԥ���˵�id
meetingstatus                   ����״̬
canceledtime                    ȡ��ʱ��
canceledreason                  ȡ��ԭ��

--------------------�����ұ�--------------------------------------------------------------------------------------------------

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

roomid          ������id    ��������
roomnum   ���ƺ�
roomname  ����������
capacity  ��������
status    ��ǰ״̬
remark    ��ע
employeeid  ˭���Ļ�����
------------------------------���������Ա��-------------------------------------------------------------------------


CREATE TABLE meetinguser (
  meetinguserid number(11) NOT NULL ,
  meetingid number(11) NOT NULL,
  employeeid number(11) NOT NULL,
  PRIMARY KEY  (meetinguserid),
  constraint  dd  FOREIGN KEY (meetingid) REFERENCES meeting (meetingid)
); 
create sequence seq_meetinguserid;

meetinguserid  ���������Ա��id     ��������
meetingid      ����id
employeeid     Ҫ��������Ա��id

----------------------------------------------------------------------------------------------------------------
