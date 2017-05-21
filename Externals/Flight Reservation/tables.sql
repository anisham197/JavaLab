create table flight (
	flno int(10) not null,
	flname varchar(50) not null,
	day varchar(50) not null

);

create table seat (
	flno int(10) not null,
	dtime varchar(50) not null,
	name varchar(50) not null,
	phone int(10) not null,
	sno int(10) not null
);

insert into flight values (12345, 'Air India', 'Monday' );
insert into flight values (12346, 'Indigo', 'Tuesday' );
insert into flight values (12347, 'Air India', 'Wednesday' );
insert into flight values (12348, 'Jet Airways', 'Thursday' );
insert into flight values (12349, 'Jet Airways', 'Friday' );
insert into flight values (12340, 'Air India', 'Saturday' );
insert into flight values (22345, 'Indigo', 'Sunday' );
insert into flight values (32345, 'Emirates', 'Monday' );
insert into flight values (42345, 'Jet Airways', 'Tuesday' );
insert into flight values (52345, 'Indigo', 'Wednesday' );
insert into flight values (62345, 'Air India', 'Thursday' );

