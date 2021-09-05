create database if not exists plants;

use plants;

drop table if exists plantName;
drop table if exists plantType;

create table plantName (
	id int(100) not null auto_increment,
    name varchar(100) not null, 
    primary key(id)
);


