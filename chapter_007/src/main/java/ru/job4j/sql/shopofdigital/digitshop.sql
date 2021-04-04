create table devices
(
    id    serial primary key,
    name  varchar(255),
    price float
);

create table people
(
    id   serial primary key,
    name varchar(255)
);

create table devices_people
(
    id        serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into people(name) values ('Evgeny');
insert into people(name) values ('Masha');
insert into people(name) values ('Sara');
insert into people(name) values ('Marina');
insert into people(name) values ('Misha');
insert into devices(name, price) VALUES ('TV', 50000);
insert into devices(name, price) VALUES ('phone', 20000);
insert into devices(name, price) VALUES ('washer', 70000);
insert into devices(name, price) VALUES ('laptop', 80000);
insert into devices(name, price) VALUES ('tablet', 90000);

insert into devices_people(device_id, people_id) VALUES (2, 1);
insert into devices_people(device_id, people_id) VALUES (1, 2);
insert into devices_people(device_id, people_id) VALUES (3, 5);
insert into devices_people(device_id, people_id) VALUES (4, 3);
insert into devices_people(device_id, people_id) VALUES (5, 4);

insert into devices_people(device_id, people_id) VALUES (2, 2);
insert into devices_people(device_id, people_id) VALUES (2, 3);
insert into devices_people(device_id, people_id) VALUES (3, 5);
insert into devices_people(device_id, people_id) VALUES (4, 1);
insert into devices_people(device_id, people_id) VALUES (5, 4);

select avg(price) from devices;

select p.name, avg(price)
from devices_people as dp
         join devices as d on dp.device_id = d.id
         join people as p on dp.people_id = p.id
group by p.name;

select p.name, avg(price)
from devices_people as dp
         join devices as d on dp.device_id = d.id
         join people as p on dp.people_id = p.id
group by p.name
having avg(price) < 70000;

