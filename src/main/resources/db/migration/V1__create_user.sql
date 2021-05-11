SET SCHEMA 'public';

create table users
(
    id              serial not null primary key,
    first_name      varchar(44) not null,
    last_name       varchar(44) not null,
    email           varchar(255) not null,
    password        varchar(255) not null
);

insert into users (id, first_name, last_name, email, password) values (1, 'test', 'test', 'test.test@gmail.com', 'Athdsk8*df');
