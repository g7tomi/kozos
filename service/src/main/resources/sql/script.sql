DROP DATABASE IF EXISTS customerdb;
CREATE DATABASE IF NOT EXISTS customerdb;
USE customerdb;

create table customers(id INT NOT NULL AUTO_INCREMENT,name varchar(30), age int, email varchar(30), PRIMARY KEY(id));
insert into customers (name,age,email) values ('Mate',24,'hirannormatt@gmail.com');
insert into customers (name,age,email) values ('Tomi',23,'fogt@hotmail.com');



