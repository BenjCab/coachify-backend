create table accounts
(
    id         bigint auto_increment primary key not null,
    first_name varchar(44)                       not null,
    last_name  varchar(44)                       not null,
    email      varchar(44)                       not null,
    password   varchar(255)                      not null,
    enabled    boolean default false             not null
);

create table authorities
(
    account_id bigint       not null,
    authority  varchar(255) not null
);

create table account_verification
(
    id bigint auto_increment primary key not null,
    verification_code varchar(255)  not null,
    created_on datetime not null
)
