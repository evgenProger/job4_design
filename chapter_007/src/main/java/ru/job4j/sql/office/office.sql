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

