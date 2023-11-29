alter table patients add active tinyInt;
update patients set active = 1;