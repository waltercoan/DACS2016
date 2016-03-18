create database restaurante2016;

grant all privileges on restaurante2016.* to 'bob' 

identified by 'bob';

flush privileges;

create table produto (oid int not null auto_increment 

primary key, descricao varchar(1000), valor decimal, 

unidade varchar(100));