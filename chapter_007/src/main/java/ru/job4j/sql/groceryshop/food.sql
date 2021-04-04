create table food
(
    id serial primary key,
    name varchar(50),
    expired_date date,
    price float,
    type_id int references typeFood(id)
);

create table typeFood
(
    id serial primary key,
    name varchar (50)
);

insert into typeFood(name) values ('dairy ')
insert into food(name, expired_date, price, type_id) VALUES ('milk', '2021-04-09', 50, 1)

