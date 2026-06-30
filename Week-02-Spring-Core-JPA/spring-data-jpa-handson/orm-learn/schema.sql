-- Run before starting the app (ddl-auto=validate expects the table to exist).
--   mysql -u root -p
--   create schema ormlearn;
--   use ormlearn;
--   source schema.sql;

create table country (
    co_code varchar(2) primary key,
    co_name varchar(50)
);

insert into country values ('IN', 'India');
insert into country values ('US', 'United States of America');
