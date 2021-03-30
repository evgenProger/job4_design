insert into "user" (name) values ('user1');
insert into "user" (name) values ('user2');
insert into "user" (name) values ('user3');
insert into "role" (name, user_id) values ('operator', 1);
insert into "role" (name, user_id) values ('administrator', 2);
insert into "role"(name, user_id) VALUES ('director', 3);
insert into "rules"(name) values ('add');
insert into "rules"(name) values ('delete');
insert into "rules"(name) values ('create');
insert into "rules"(name) values ('comment');
insert into "role_rules"(role_id, rules_id) VALUES (1, 1);
insert into "role_rules"(role_id, rules_id) VALUES (3, 1);
insert into "role_rules"(role_id, rules_id) VALUES (3, 2);
insert into "role_rules"(role_id, rules_id) VALUES (3, 3);
insert into "role_rules"(role_id, rules_id) VALUES (4, 1);
insert into "role_rules"(role_id, rules_id) VALUES (4, 2);
insert into "role_rules"(role_id, rules_id) VALUES (4, 3);
insert into "role_rules"(role_id, rules_id) VALUES (4, 4);
insert into "role_rules"(role_id, rules_id) VALUES (1, 3);
insert into "item"(name, user_id) VALUES ('computers', 1);
insert into "item"(name, user_id) VALUES ('tv', 2);
insert into "item"(name, user_id) VALUES ('washer', 1);
insert into "item"(name, user_id) VALUES ('microwave', 3);




