alter table doctors add active tinyInt;
update doctors set active = 1;