drop table TO_DO_ITEM;
create sequence hibernate_sequence start with 1 increment by 1;
create table TO_DO_ITEM(
  id varchar(64) not null PRIMARY KEY ,
  item varchar(64) not null,
  status int(10)
);
