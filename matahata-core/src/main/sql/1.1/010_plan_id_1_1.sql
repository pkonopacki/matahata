drop table plan_item cascade;

create table plan_item (
	id				bigint			auto_increment,
	category_id		bigint			not null,
	cat_limit		numeric(10,2)	not null,
	
	constraint pk_plan_item primary key (id),
	constraint fk_plan_item_category_id foreign key (category_id) references category (id)
) default charset utf8 collate utf8_polish_ci;

drop table plan_item_link cascade;

create table plan_item_link (
	plan_id				bigint			auto_increment,
	plan_item_id		bigint,
	
	constraint pk_plan_item primary key (plan_id, plan_item_id),
	constraint fk_plan_item_link_plan foreign key (plan_id) references plan (id),
	constraint fk_plan_item_link_plan_item foreign key (plan_item_id) references plan_item (id)
) default charset utf8 collate utf8_polish_ci;

alter table plan drop column amount;