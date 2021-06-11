insert into "user" (name) values ('Evgeny');
insert into "user" (name ) values ('Vika');
insert into "user" (name) VALUES ('Pasha');
insert into "user" (name) VALUES ('Lena');
insert into "user" (name) VALUES ('Kate');


insert into meet(name) values ('meet_one');
insert into meet(name) values ('meet_two');
insert into meet(name) values ('meet_three');
insert into meet(name) values ('meet_four');
insert into meet(name) values ('meet_five');

insert into user_meet(meet_id, user_id) VALUES (2, 1);
insert into user_meet(meet_id, user_id) VALUES (3, 2);
insert into user_meet(meet_id, user_id) VALUES (1, 1);
insert into user_meet(meet_id, user_id) VALUES (4, 3);
insert into user_meet(meet_id, user_id) VALUES (2, 4);
insert into user_meet(meet_id, user_id) VALUES (2, 5);

insert into status(status) values ('confirmed');
insert into status(status) values ('declined');

insert into user_meet_status(id_user_meet, id_status) VALUES (1, 1);
insert into user_meet_status(id_user_meet, id_status) VALUES (2, 2);
insert into user_meet_status(id_user_meet, id_status) VALUES (3, 1);
insert into user_meet_status(id_user_meet, id_status) VALUES (4, 1);
insert into user_meet_status(id_user_meet, id_status) VALUES (5, 2);
insert into user_meet_status(id_user_meet, id_status) VALUES (6, 1);
