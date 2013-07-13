create table ubuser (
	id number,
	firstName varchar2(30),
	lastName varchar2(30),
	userName varchar2(30),
	password varchar2(40),
	constraint ubuser_pk primary key (id),
	constraint ub_username_uk unique (userName)
);