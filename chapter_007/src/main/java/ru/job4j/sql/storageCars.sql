create table carBody
(
    id serial primary key,
    name varchar (50)
);

insert into carBody(name) values ('sedan');
insert into carBody(name) values ('coupe');
insert into carBody(name) values ('sports car');
insert into carBody(name) values ('hatchback');
insert into carBody(name) values ('minivan');

create table engine
(
    id serial primary key,
    type varchar(50)
);

insert into engine(type) values ('V engine');
insert into engine(type) values ('four cylinders');
insert into engine(type) values ('five cylinders');
insert into engine(type) values ('six cylinders');
insert into engine(type) values ('inline engine');

create table transmission
(
    id serial primary key,
    type varchar(50)
);

insert into transmission(type) values ('manual transmission');
insert into transmission(type) values ('automatic transmission');
insert into transmission(type) values ('cvt');
insert into transmission(type) values ('semi-automatic transmission');

create table car
(
    id serial primary key,
    name varchar(50),
    carBody_id int references carBody(id),
    engine_id int references engine(id),
    transmission_id int references transmission(id)
);

insert into car(name, carBody_id, engine_id, transmission_id) VALUES ('land rover', 3, 2, 1);
insert into car(name, carBody_id, engine_id, transmission_id) VALUES ('lexus', 2, 1, 3);
insert into car(name, carBody_id, engine_id, transmission_id) VALUES ('mercedes', 1, 4, 4);
insert into car(name, carBody_id, engine_id, transmission_id) VALUES ('volvo', 5, 4, 4);
insert into car(name, carBody_id, engine_id, transmission_id) VALUES ('volkswagen', 4, 5, 2);
insert into car(name, carBody_id, engine_id, transmission_id) VALUES ('mitsubishi', 3, 3, 3);
insert into car(name, carBody_id, engine_id, transmission_id) VALUES (null , 1, 4, 2);

select c.name as car, b.name as carBody, e.type as engine, t.type as transmission
from car as c join carBody as b on c.carBody_id = b.id
join engine as e on c.engine_id = e.id
join transmission t on c.transmission_id = t.id;

select cB.name as carbody from car as c
join carBody cB on c.carBody_id = cB.id where c.name is null;

select e.type as engine from car as c
join engine e on c.engine_id = e.id where c.name is null;

select t.type as transmission from car as c
join transmission t on c.transmission_id = t.id  where c.name is null;






