drop database if exists web;
create database web;
use web;
create table data (id int(4) auto_increment not null primary key, 
logname varchar(50),
em varchar(50));
grant SELECT,UPDATE,INSERT,DELETE on web.* to inens identified by 'inens';

