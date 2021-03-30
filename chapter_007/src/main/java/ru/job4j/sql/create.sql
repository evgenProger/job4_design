CREATE TABLE "user" (
  "id"  SERIAL PRIMARY KEY,
  "name" varchar(200)
);

CREATE TABLE "role" (
  "id"  SERIAL  PRIMARY KEY,
  "name" varchar(2000),
  "user_id" int
);

CREATE TABLE "rules" (
  "id"  SERIAL PRIMARY KEY,
  "name" varchar(2000)
);

CREATE TABLE "role_rules" (
  "id"  SERIAL PRIMARY KEY,
  "role_id" int ,
  "rules_id" int
);

CREATE TABLE "item" (
  "id"  SERIAL PRIMARY KEY,
  "name" varchar(200),
  "user_id" int
);

CREATE TABLE "item_user" (
  "id"  SERIAL PRIMARY KEY,
  "item_id" int,
  "user_id" int
);

CREATE TABLE "comments" (
  "id" SERIAL PRIMARY KEY,
  "comment" text,
  "item_id" int
);

CREATE TABLE "attachs" (
  "id" SERIAL PRIMARY KEY,
  name "varchar" (200),
  "item_id" int
);

CREATE TABLE "category" (
  "id"  SERIAL PRIMARY KEY,
  "name" varchar(200),
  "item_id" int
);

CREATE TABLE "state" (
  "id" SERIAL PRIMARY KEY,
  "st" varchar(200),
  "item_id" int
);

ALTER TABLE "role" ADD FOREIGN KEY ("user_id") REFERENCES "user" ("id") ;

ALTER TABLE "role_rules" ADD FOREIGN KEY ("role_id") REFERENCES "role" ("id");

ALTER TABLE "role_rules" ADD FOREIGN KEY ("rules_id") REFERENCES "rules" ("id");

ALTER TABLE "item" ADD FOREIGN KEY ("user_id") REFERENCES "user" ("id");

ALTER TABLE "comments" ADD FOREIGN KEY ("item_id") REFERENCES "item" ("id");

ALTER TABLE "attachs" ADD FOREIGN KEY ("item_id") REFERENCES "item" ("id");

ALTER TABLE "category" ADD FOREIGN KEY ("item_id") REFERENCES "item" ("id");

ALTER TABLE "state" ADD FOREIGN KEY ("item_id") REFERENCES "item" ("id");


