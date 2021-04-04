insert into players (name, elo) values('Wilhelm Steinitz', 2600);
insert into players (name, elo ) values ('Johannes  Zukertort', 2590);
insert into players (name, elo ) values ('Alexander Alekhine', 2660);
insert into players (name, elo ) values ('Jose Raul Capablanca', 2640);
insert into players (name, elo) values ('Robert  Fischer', 2785 );
insert into players (name, elo ) values ('Boris  Spassky', 2640);
insert into games(white_id, black_id, score, year) values (1, 2, '1-0', '1886-01-11');
insert into games(white_id, black_id, score, year) values (2, 1, '0-1', '1886-01-13');
insert into games(white_id, black_id, score, year) values (6, 5, '1-0', '1972-07-11');
insert into games(white_id, black_id, score, year) values (5, 6, '0-1', '1972-07-13');
insert into games(white_id, black_id, score, year) values (4, 3, '0-1', '1927-09-16');
insert into games(white_id, black_id, score, year) values (3, 4, '0.5-0.5', '1927-09-18');

 select  w.name as белые, w.elo as рейтинг,  b.name as черные, b.elo as рейтинг,
gm.score as "счет партии", gm.year as дата  from games as gm  join players w on gm.white_id = w.id
join players b on gm.black_id = b.id






