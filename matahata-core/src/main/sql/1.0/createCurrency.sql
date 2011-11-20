drop table currency cascade;

create table currency (
	id				bigint		auto_increment,
	iso_code	 	varchar(3)	not null,
	description 	varchar(50),
	is_default		tinyint		not null,
	creation_date	date,
	last_update		date,
	active			tinyint		not null,

	constraint currency_pk primary key (id),
	constraint iso_code_uq unique (iso_code)
);