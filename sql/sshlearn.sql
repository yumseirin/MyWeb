create table Qu  (
   dno                varchar2(20)                    not null,
   name               varchar2(20),
   constraint PK_TDISTRICT primary key (dno)
);

create table Jiedao  (
   sno                varchar2(20)                    not null,
   dno                varchar2(20),
   name               varchar2(20),
   constraint PK_TSTREET primary key (sno)
);

alter table Jiedao  
   add constraint FK_TSTREET_REFERENCE_TDISTRIC foreign key (dno)
      references Qu(dno);


create table THouseType  (
   id                 number(5)                       not null,
   name               varchar2(20),
   constraint PK_THOUSETYPE primary key (id)
);
create table Thouse  (
   hid                number(9)                       not null,
   sno                varchar2(20),
   htid               number(5),
   hdesc              varchar2(2000),
   hprice             number(7,2),
   constraint PK_THOUSE primary key (hid)
);

alter table Thouse
   add constraint FK_THOUSE_REFERENCE_TSTREET foreign key (sno)
      references Jiedao  (sno);

alter table Thouse
   add constraint FK_THOUSE_REFERENCE_THOUSETY foreign key (htid)
      references THouseType (id);


create table Tuser  (
   uname              varchar2(20)                    not null,
   pwd                varchar2(20),
   email              varchar2(30),
   constraint PK_TUSER primary key (uname)
);

create table THouseRent  (
   id                 number(9)                       not null,
   hid                number(9),
   uname              varchar2(20),
   price              number(6,2),
   rdesc              varchar2(200),
   rdate              date,
   constraint PK_THOUSERENT primary key (id)
);

alter table THouseRent
   add constraint FK_THOUSERE_REFERENCE_THOUSE foreign key (hid)
      references Thouse (hid);

alter table THouseRent
   add constraint FK_THOUSERE_REFERENCE_TUSER foreign key (uname)
      references Tuser (uname);

