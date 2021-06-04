set schema 'public';

create table if not exists accounts
(
    id         serial primary key    not null,
    first_name varchar(44)           not null,
    last_name  varchar(44)           not null,
    email      varchar(44)           not null,
    password   varchar(255)          not null,
    image        varchar(255),
    enabled    boolean default false not null
);

create table if not exists authorities
(
    account_id serial       not null,
    authority  varchar(255) not null
);

create table if not exists account_verification
(
    id                serial primary key not null,
    verification_code varchar(255)       not null,
    created_on        timestamp          not null
);

create table if not exists coach_profile
(
    id           serial primary key not null,
    account_id   serial             not null,
    introduction varchar(255),
    availability varchar(255)
);
