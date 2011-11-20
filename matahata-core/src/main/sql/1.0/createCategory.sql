drop table category cascade;

create table category (
	id				bigint		auto_increment,
	abbreviation 	varchar(5)	not null,
	description 	varchar(50) not null,
	creation_date	date,
	last_update		date,
	active			tinyint		not null,

	constraint category_pk primary key (id),
	constraint category_uq unique (abbreviation)
);