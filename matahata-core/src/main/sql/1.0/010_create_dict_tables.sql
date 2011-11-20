drop table currency cascade;

create table currency (
	id				bigint		auto_increment,
	iso_code	 	varchar(3)	not null,
	description 	varchar(50),
	is_default		tinyint		not null,
	creation_date	date,
	last_update		date,
	active			bit		not null,

	constraint currency_pk primary key (id),
	constraint iso_code_uq unique (iso_code)
) default charset utf8 collate utf8_polish_ci;

drop table account cascade;

create table account (
	id				bigint		auto_increment,
	bank_id			bigint,
	account_name	varchar(30),
	account_number	varchar(50)	not null,
	balance			numeric(10, 2) not null,
	currency_id		bigint,
	description		varchar(100),
	creation_date	date,
	last_update		date,
	active			bit		not null,

	constraint account_pk primary key (id),
	constraint account_no_uq unique (account_number),
	constraint account_currency_fk foreign key (currency_id) references currency (id)
) default charset utf8 collate utf8_polish_ci;

drop table beneficiary cascade;

create table beneficiary (
	id				bigint		auto_increment,
	initials		varchar(3),
	first_name		varchar(30),
	middle_name		varchar(30),
	last_name		varchar(30)	not null,
	description		varchar(100),
	dob				date,
	creation_date	date,
	last_update		date,
	active			bit		not null,

	constraint beneficiary_pk primary key (id)
) default charset utf8 collate utf8_polish_ci;

drop table category cascade;

create table category (
	id				bigint		auto_increment,
	abbreviation 	varchar(5)	not null,
	description 	varchar(100),
	monthly_limit	numeric(10, 2) not null,
	creation_date	date,
	last_update		date,
	active			bit		not null,

	constraint category_pk primary key (id),
	constraint category_uq unique (abbreviation)
) default charset utf8 collate utf8_polish_ci;