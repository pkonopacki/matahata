drop table account cascade;

create table account (
	id				bigint		auto_increment,
	bank_id			bigint,
	account_name	varchar(30),
	account_number	varchar(50)	not null,
	balance			numeric(10, 2),
	curr_iso_code	varchar(3),
	description		varchar(100),
	creation_date	date,
	last_update		date,
	active			tinyint		not null,

	constraint account_pk primary key (id),
	constraint account_no_uq unique (account_number)
);