create table person(
pid number(3),
uname varchar2(10),
pwd varchar2(10),
sex varchar2(4),
likes varchar2(40),
bir date,
picname varchar2(100),
constraint PK_Person primary key(pid)
);

create sequence seq_personid;

select * from person order by pid;

--insert into person values(seq_personid.nextval,?,?,?,?,?,?);
select * from
(select tb.*,rownum rn
from
(select *from person order by pid)tb)a
where rn>=1 and rn<=4;
