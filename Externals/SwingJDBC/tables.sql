create table representative (
	repno int(10) primary key auto_increment,
	repname varchar(50) not null,
	state varchar(50) not null,
	comission int(10) not null,
	rate int(10) not null
);

create table customer (
	repno int(10) not null,
	custno int(10) primary key auto_increment,
	custname varchar(50) not null,
	state varchar(50) not null,
	credlimit int(10) not null
);
