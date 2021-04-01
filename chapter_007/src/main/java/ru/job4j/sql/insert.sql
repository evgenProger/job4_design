insert into "user" (name) values ('user1');
insert into "user" (name) values ('user2');
insert into "user" (name) values ('user3');
insert into "user"(name) values ('user4');
insert into "role" (name, user_id) values ('operator', 1);
insert into "role" (name, user_id) values ('administrator', 2);
insert into "role"(name, user_id) VALUES ('director', 3);
insert into role(name, user_id) VALUES ('storeman', 4);
insert into "rules"(name) values ('add');
insert into "rules"(name) values ('delete');
insert into "rules"(name) values ('create');
insert into "rules"(name) values ('comment');
insert into "rules"(name) values ('read');
insert into "role_rules"(role_id, rules_id) VALUES (1, 4);
insert into role_rules(role_id, rules_id) VALUES (1, 4);
insert into "role_rules"(role_id, rules_id) VALUES (3, 1);
insert into "role_rules"(role_id, rules_id) VALUES (3, 2);
insert into "role_rules"(role_id, rules_id) VALUES (3, 3);
insert into "role_rules"(role_id, rules_id) VALUES (3, 4);
insert into "role_rules"(role_id, rules_id) VALUES (4, 4);
insert into "role_rules"(role_id, rules_id) VALUES (2, 1);
insert into "role_rules"(role_id, rules_id) VALUES (2, 4);
insert into "role_rules"(role_id, rules_id) VALUES (2, 3);
insert into "category"(name) values ('household appliances');
insert into "category"(name) values ('toys');
insert into "category"(name) values ('sport');
insert into "state"(status) values ('accepted');
insert into "state"(status) values ('in processing');
insert into "state"(status) values ('deleted');
insert into "item"(name, user_id, category_id, state_id) VALUES ('item_№1', 1, 1, 1);
insert into "item"(name, user_id, category_id, state_id) VALUES ('item_N2', 1, 2, 2);
insert into "item"(name, user_id, category_id, state_id) VALUES ('item_N3', 2, 2, 3);
insert into "item"(name, user_id, category_id, state_id) VALUES ('item_N4', 3, 3, 2);
insert into "item"(name, user_id, category_id, state_id) VALUES ('item_N4', 3, 3, 3);
insert into "item"(name, user_id, category_id, state_id) VALUES ('item_N4', 1, 2, 3);
insert into "attachs"(name, item_id) VALUES ('blank', 1);
insert into "attachs"(name, item_id) VALUES ('picture of computer', 2);
insert into attachs(name, item_id) VALUES ('description', 2);
insert into "attachs"(name, item_id) VALUES ('picture of washer', 3);
insert into "attachs"(name, item_id) VALUES ('report', 4);
insert into "attachs"(name, item_id) VALUES ('answer', 4);
insert into comments(comment, item_id) VALUES ('thank you', 2);
insert into comments(comment, item_id) VALUES ('I am satisfied' , 2);
insert into comments(comment, item_id) VALUES ('everything is bad' , 1);
insert into comments(comment, item_id) VALUES ('sorry for delay' , 3);












