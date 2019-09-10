create table counts(
counts number(10)
);

insert into counts values(0);

select * from counts;

update counts set counts=?;