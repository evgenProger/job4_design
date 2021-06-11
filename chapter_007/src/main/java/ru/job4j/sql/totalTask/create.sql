create table "user"
(
    id serial primary key,
    name varchar(75)
);

create table meet
(
    id serial primary key,
    name varchar(75)
);

create table user_meet
(
    id serial primary key,
    "meet_id" int references meet(id),
    "user_id" int  references "user"(id)

);

create table status
(
    id serial primary key,
    status varchar(75)
);

create table user_meet_status
(
    id serial primary key,
    id_user_meet int references user_meet(id),
    id_status int references status(id)
)

