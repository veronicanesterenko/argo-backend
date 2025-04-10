create type role_enum as enum ('client', 'manager');

create table if not exists users
(
    id           bigserial primary key,
    first_name   varchar(30)  NOT NULL,
    last_name    varchar(50)  NOT NULL,
    role         role_enum    NOT NULL,
    phone_number varchar(20)  NOT NULL,
    login        varchar(255) NOT NULL UNIQUE,
    password     varchar(255) NOT NULL,
    email        varchar(255) NOT NULL UNIQUE
);

create table if not exists brand
(
    id           bigserial primary key,
    name         varchar(50)  NOT NULL UNIQUE,
    city         varchar,
    brand_logo   bytea,
    brand_info   varchar
);

  create table if not exists category
  (
      id           bigserial primary key,
      name         varchar(50)  NOT NULL UNIQUE
  );

  create table if not exists product
  (
      id                  bigserial primary key,
      name                varchar(30)  NOT NULL,
      brand_id            bigint,
      item_number         varchar(50) NOT NULL UNIQUE,
      main_image          bytea,
      supplement_facts    varchar NOT NULL UNIQUE,
      score               bigint,
      short_description   varchar(500)  NOT NULL,
      full_description    varchar    NOT NULL,
      quantity            varchar,
      foreign key (brand_id) references brand (id)
  );

  create table if not exists category_to_product
  (
      id           bigserial primary key,
      product_id   bigint,
      category_id  bigint,
      foreign key (product_id) references product (id),
      foreign key (category_id) references category (id)
    );

  create table if not exists image
  (
      id            bigserial primary key,
      product_id    bigint,
      content       bytea  NOT NULL,
      foreign key (product_id) references product (id)
  );

  create table if not exists feedback
  (
       id            bigserial primary key,
       product_id    bigint,
       user_id      bigint,
       content       varchar(500),
       foreign key (user_id) references users (id),
       foreign key (product_id) references product (id)
  )