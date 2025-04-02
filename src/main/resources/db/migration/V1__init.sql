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

create table if not exists producer
(
    id           bigserial primary key,
    name         varchar(50)  NOT NULL UNIQUE

);

create table if not exists country
(
    id           bigserial primary key,
    name         varchar(50)  NOT NULL UNIQUE
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
      producer_id         bigint,
      country_id          bigint,
      category_id         bigint,
      item_number         varchar(50) NOT NULL UNIQUE,
      short_description   varchar(500)  NOT NULL,
      full_description    varchar    NOT NULL,
      main_image          bytea  NOT NULL,
      supplement_facts    varchar NOT NULL UNIQUE,
      score               bigint,
      foreign key (producer_id) references producer (id),
      foreign key (country_id) references country (id),
      foreign key (category_id) references category (id)
  );

  create table if not exists image
  (
      id            bigserial primary key,
      product_id    bigint,
      foreign key (product_id) references product (id)
  );

  create table if not exists feedback
  (
       id            bigserial primary key,
       product_id    bigint,
       users_id      bigint,
       content       varchar(500),
       foreign key (users_id) references users (id),
       foreign key (product_id) references product (id)
  )