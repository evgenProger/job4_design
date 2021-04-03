CREATE TABLE "user" (
  "id"  SERIAL PRIMARY KEY,
  "name" varchar(200),
  role_id int references role(id)
);

CREATE TABLE "role" (
  "id"  SERIAL  PRIMARY KEY,
  "name" varchar(2000)
);

CREATE TABLE "rules" (
  "id"  SERIAL PRIMARY KEY,
  "name" varchar(2000)
);

CREATE TABLE "role_rules" (
  "id"  SERIAL PRIMARY KEY,
  "role_id" int references role(id),
  "rules_id" int references rules(id)
);

CREATE TABLE "item" (
  "id"  SERIAL PRIMARY KEY,
  "name" varchar(200),
  "user_id" int references "user"(id),
  "category_id" int references "category"(id),
  "state_id" int references "state"(id)
);

CREATE TABLE "comments" (
  "id" SERIAL PRIMARY KEY,
  "comment" text,
  "item_id" int references item(id)
);

CREATE TABLE "attachs" (
  "id" SERIAL PRIMARY KEY,
  name "varchar" (200),
  "item_id" int references item(id)
);

CREATE TABLE "category" (
  "id"  SERIAL PRIMARY KEY,
  "name" varchar(200)
);

CREATE TABLE "state" (
  "id" SERIAL PRIMARY KEY,
  "status" varchar(200)
);

