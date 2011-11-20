drop table beneficiary cascade;

create table beneficiary (
	id				bigint		auto_increment,
	initials		varchar(3),
	first_name		varchar(30),
	middle_name		varchar(30),
	description		varchar(100),
	last_name		varchar(30)	not null,
	dob				date,
	creation_date	date,
	last_update		date,
	active			tinyint		not null,

	constraint beneficiary_pk primary key (id)
);