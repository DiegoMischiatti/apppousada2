

create database apppousada2;

use apppousada2;


create table hospede(
    id int not null primary key auto_increment,
	nome varchar (80),
    sexo varchar (80),
    cpf varchar (80),
    email varchar (80)  
);

select * from hospede;

