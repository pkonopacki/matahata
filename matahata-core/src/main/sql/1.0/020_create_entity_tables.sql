drop table plan cascade;

create table plan (
	id				bigint			auto_increment,
	start_date		datetime		not null,
	end_date		datetime		not null,
	amount			numeric(10,2)	not null,
	object_type		varchar(20) 	not null,
	
	constraint pk_plan primary key (id),
	constraint fk_plan_account_id foreign key (account_id) references account (id)
) default charset utf8 collate utf8_polish_ci;

create table plan_item (
	id				bigint			auto_increment,
	category_id		bigint			not null,
	limit			numeric(10,2)	not null,
	
	constraint pk_plan_item primary key (id),
	constraint fk_plan_item_category_id foreign key (category_id) references category (id)
) default charset utf8 collate utf8_polish_ci;


drop table item cascade;

create table item (
	id				bigint			auto_increment,
	event_date		date,
	source      	varchar(50),
	location      	varchar(50),
	amount         	numeric(10,2)	not null,
	orig_amount		numeric(10,2)	not null,
	currency_id		bigint,
	orig_currency_id bigint,
	description   	varchar(100),
	category_id   	bigint,
	src_account_id	bigint,
	dest_account_id	bigint,
	payer_id		bigint,
	beneficiary_id	bigint,
	plan_id			bigint,
	is_refundable	bit,
	is_cleared		bit,
	object_type		varchar(20) 	not null,
	  
	constraint pk_item primary key (id),
	constraint fk_item_cat_id foreign key (category_id) references category (id),
	constraint fk_item_src_acc_id foreign key (src_account_id) references account (id),
	constraint fk_item_dest_acc_id foreign key (dest_account_id) references account (id),
	constraint fk_item_ben_id foreign key (beneficiary_id) references beneficiary (id),
	constraint fk_item_payer_id foreign key (payer_id) references beneficiary (id),
	constraint fk_item_plan_id foreign key (plan_id) references plan (id),
	constraint fk_item_cur_id foreign key (currency_id) references currency (id),
	constraint fk_item_orig_cur_id foreign key (currency_id) references currency (id)
	
) default charset utf8 collate utf8_polish_ci;

drop table item_category cascade;

create table item_category (
	category_id		bigint,
	item_id			bigint,
	
	constraint pk_item_category primary key (category_id, item_id),
	constraint fk_item_category_category_id foreign key (category_id) references category (id),
	constraint fk_item_category_item_id foreign key (item_id) references item (id)
) default charset utf8 collate utf8_polish_ci;


drop table operation cascade;

create table operation (
	id				bigint			auto_increment,
	operation_date	date,
	account_id		bigint			not null,
	amount			numeric(10,2)	not null,
	currency_id		bigint			not null,
	orig_amount		numeric(10,2)	not null,
	orig_currency_id bigint			not null,
	item_id			bigint,
	object_type		varchar(20) 	not null,
	  
	constraint pk_operation primary key (id),
	constraint fk_operation_acc_id foreign key (account_id) references account (id),
	constraint fk_operation_curr_id foreign key (currency_id) references currency (id),
	constraint fk_operation_item_id foreign key (item_id) references item (id)
) default charset utf8 collate utf8_polish_ci;