drop database if exists `restaurant`;
create database restaurant;
use restaurant;

drop table if exists `masa`;
create table masa (
	id int not null auto_increment,
    nr_locuri int not null default 2,
    primary key(id)   
);

drop table  if exists `customer`;
create table customer (
	id int not null auto_increment,
    nume varchar(20) not null,
    prenume varchar(20) not null,
    nr_masa int not null,
    primary key(id),
	foreign key(nr_masa) references masa(id)    
   );
   
drop table  if exists `comanda`;
create table comanda (
	id int not null auto_increment,
    customer_id int not null,
    data datetime not null,
    primary key(id),
    foreign key(customer_id) references customer(id)
); 
  
drop table  if exists `nota_de_plata`;
create table nota_de_plata (
	id int not null auto_increment,
	nr_masa int not null,
    gramaj_total int not null,
    pret_total int not null,
    primary key(id),
    foreign key(nr_masa) references masa(id)
);

drop table if exists `categorie`;
create table categorie (
	id int not null auto_increment,
    denumire varchar(40),
    primary key(id)
);

drop table if exists `produs`;
create table produs (
	id int not null auto_increment,
    categorie_id int not null,
    nume varchar(40) not null,
    pret int not null,
    gramaj int not null,
    primary key(id),
    foreign key(categorie_id) references categorie(id)
);

drop table if exists `istoric_comenzi`;
create table istoric_comenzi (
	id int not null auto_increment,
    comanda_id int not null,
    produs_id int not null,
    primary key(id),
    foreign key(comanda_id) references comanda(id),
    foreign key(produs_id) references produs(id)
)




