create table dept
(
    id serial primary key,
    name varchar(14)
);

create table emp
(
    id serial primary key,
    name varchar(10),
    dept_id int references dept(id)
);

insert into DEPT (NAME) values('ACCOUNTING');

insert into dept(name) values('RESEARCH');

insert into dept(name) values('SALES');

insert into dept(name) values('OPERATIONS');

insert into emp(name, dept_id) values('KING', 1);

insert  into emp(name, dept_id) values('BLAKE', 4);

insert into emp(name, dept_id) values('CLARK', 1);

insert into emp(name, dept_id) values ('JONES', 3);

insert into emp(name, dept_id) values('SCOTT', 4);

insert into emp(name, dept_id) values('FORD', 2);

insert into emp(name, dept_id) values('SMITH', 1);

insert into emp(name, dept_id) values('ALLEN', 3);

insert into emp(name, dept_id) values ('WARD', 4);

insert into emp(name, dept_id) values('MARTIN', 1);

insert into emp(name, dept_id) values ('TURNER', 2);

insert into emp(name, dept_id) values('ADAMS', 3);

insert into emp(name, dept_id) values('JAMES', 4);

insert into emp(name, dept_id) values('MILLER', 2);

insert into emp(name, dept_id) values ('Lenny', null);

insert into emp(dept_id) VALUES (4);

select e.name as emplayer, d.name as department from emp as e
left join dept d on e.dept_id = d.id;

select e.name as emplayer, d.name as department from emp as e
right join  dept d on e.dept_id = d.id;

select d.name as department, e.name as emplayers from dept as d
right join emp as e on d.id = e.dept_id;

select e.name as emplayer, d.name as department from emp as e
full join dept d on e.dept_id = d.id;

select * from emp cross join dept;

select d.name as department from emp e
left join dept d on e.dept_id = d.id
where e.name is null



