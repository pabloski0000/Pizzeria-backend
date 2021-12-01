CREATE TABLE users (
 id binary(16) primary key,
name varchar(50) not null,
last_name varchar(50) not null,
 email varchar(50) not null unique,
password varchar(255) not null,
provider varchar(50) not null,
rol varchar(50) not null
);