drop table operation cascade;

create table operation (
	id					bigint			auto_increment,
	operation_date		date,
	account_id			bigint			not null,
	amount				numeric(10,2)	not null,
	currency_id			bigint			not null,
	orig_amount			numeric(10,2)	not null,
	orig_currency_id	bigint			not null,
	item_id				bigint,
	object_type			varchar(20) 	not null,
	  
	constraint pk_operation primary key (id),
	constraint fk_operation_acc_id foreign key (account_id) references account (id),
	constraint fk_operation_curr_id foreign key (currency_id) references currency (id),
	constraint fk_operation_orig_curr_id foreign key (orig_currency_id) references currency (id),
	constraint fk_operation_item_id foreign key (item_id) references item (id)
);