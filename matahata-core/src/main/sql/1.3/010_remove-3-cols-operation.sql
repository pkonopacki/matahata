alter table operation drop column orig_amount;
alter table operation drop column orig_currency_id;
alter table operation drop foreign key fk_operation_curr_id;
alter table operation drop column currency_id;