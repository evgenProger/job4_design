create table teens
(
    id serial primary key ,
    name varchar (20),
    gender varchar (5)
);

insert  into teens(name, gender) VALUES ('Mike', 'M');
insert into teens(name, gender) VALUES ('Kate', 'F');
insert into teens(name, gender) VALUES ('Vera', 'F');
insert into teens(name, gender) VALUES ('Jack', 'M');
insert into teens(name, gender) VALUES ('Nata', 'F');
insert into teens(name, gender) VALUES ('Steven', 'M');
insert into teens(name, gender) VALUES ('Bob', 'M');

select tM.name, tF.name as famale
    from teens tM cross join teens tF where tM.gender != tF.gender;





