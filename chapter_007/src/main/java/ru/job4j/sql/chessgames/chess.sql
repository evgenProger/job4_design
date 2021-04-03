create table games
(
	id serial primary key,
	white_id int references players,
	black_id int references players,
	score varchar(10),
	year date
);



create table players (
    id   serial primary key,
    name varchar(50),
    elo int
);



