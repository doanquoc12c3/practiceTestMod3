create database product_management;

use product_management;

create table category(
     id int primary key auto_increment,
     name varchar(50)
);

create table product(
    id int primary key auto_increment,
    name varchar(50),
    price double,
    color varchar(50),
    description varchar(50),
    categoryId int,
    foreign key (categoryId) references category(id)
);


insert into product(name, price, color, description,categoryId)
values('iphone',13000,'red','new',1),
       ('samsung',15000,'white','new',2);



insert into category(name)
values('smartphone'),
       ('tablet');