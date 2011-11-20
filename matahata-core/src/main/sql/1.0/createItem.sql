drop table item cascade;

create table item (
	id					bigint			auto_increment,
	event_date			date,
	source      		varchar(50),
	location      		varchar(50),
	amount         		numeric(10,2)	not null,
	currency_id			bigint,
	orig_amount			numeric(10,2)	not null,
	orig_currency_id	bigint,
	description   		varchar(100),
	category_id   		bigint,
	src_account_id		bigint,
	dest_account_id		bigint,
	payer_id			bigint,
	beneficiary_id		bigint,
	is_refundable		tinyint(1),
	is_cleared			tinyint(1),
	object_type			varchar(20) 	not null,
	  
	constraint pk_item primary key (id),
	constraint fk_item_cat_id foreign key (category_id) references category (id),
	constraint fk_item_src_acc_id foreign key (src_account_id) references account (id),
	constraint fk_item_dest_acc_id foreign key (dest_account_id) references account (id),
	constraint fk_item_ben_id foreign key (beneficiary_id) references beneficiary (id),
	constraint fk_item_payer_id foreign key (payer_id) references beneficiary (id),
	constraint fk_item_cur_id foreign key (currency_id) references currency (id)
	constraint fk_item_orig_cur_id foreign key (orig_currency_id) references currency (id)
);