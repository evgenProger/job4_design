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

insert into typeFood(name) values ('dairy');
insert into food(name, expired_date, price, type_id) VALUES ('milk', '2021-04-09', 50, 1);
insert into food(name, expired_date, price, type_id) VALUES ('butter', '2021-04-04', 70, 1);
insert into food(name, expired_date, price, type_id) VALUES ('cheese', '2021-04-21', 102, 1);
insert into food(name, expired_date, price, type_id) VALUES ('sour cream', '2021-03-01', 94, 1);
insert into food(name, expired_date, price, type_id) VALUES ('ice cream', '2021-05-30', 69, 1);

insert into typeFood(name) values ('meat');

insert into food(name, expired_date, price, type_id) values ('beef', '2021-03-26', 232, 2);
insert into food(name, expired_date, price, type_id) values ('lamb', '2021-04-02', 354, 2);
insert into food(name, expired_date, price, type_id) values ('chicken', '2021-04-24', 127, 2);
insert into food(name, expired_date, price, type_id) values ('duck', '2021-05-07', 248, 2);

insert into typeFood(name) values ('bakery products');

insert into food(name, expired_date, price, type_id) VALUES ('cake', '2021-06-14', 78, 3);
insert into food(name, expired_date, price, type_id) VALUES ('pie', '2021-06-03', 25, 3);
insert into food(name, expired_date, price, type_id) VALUES ('ring roll', '2021-07-28', 59, 3);

select f.name as наименование, tF.name as категория from food as f
    join typeFood tF on tF.id = f.type_id
    where tF.name = 'dairy';

select name from food where name like '%cream%';

select name from food where date_part('month', expired_date) = date_part('month', current_date + interval '1 month');

select name from food where price = (select max(price) from food);

select tF.name, count(f.name)  from food as f join typeFood tF on tF.id = f.type_id
group by tF.name;

select tf.name as категория, count(f.name) as количество  from typeFood as tf
join food f on tf.id = f.type_id
group by tf.id;

select f.name from food as f join typeFood tF on tF.id = f.type_id
where tF.name = 'dairy' or tF.name = 'bakery products';

select tF.name from typeFood as tF join food f on tF.id = f.type_id
group by tF.name
having count(f.name) < 5;













