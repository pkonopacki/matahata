alter table category add category_type tinyint;
update category set category_type = 'EXPENSE';
alter table category modify category_type tinyint not null;