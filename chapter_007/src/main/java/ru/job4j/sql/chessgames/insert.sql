/*insert into players (name, elo) values('Wilhelm Steinitz', 2600);
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
 */
select distinct p.id as id,  p.name as имя, p.elo as рейтинг, gm.white_id as белые, gm.black_id as черные,
gm.score as "счет партии"
from  games as gm  join players p on p.id = gm.black_id or gm.white_id = p.id


