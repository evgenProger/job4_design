create database IMDb;
create table IMDb (
    id serial primary key,
    title varchar(50),
    rate double precision,
    date date
);
 insert into IMDb(title, rate, date) values ('Better call Saul', 8.9, '2015-02-09');
update IMDb set title = 'True Detective', rate = 9.0, date = '2014-02-22';
delete from IMDb;
drop table IMDb;


