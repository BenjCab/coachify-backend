SET SCHEMA 'public';

create table topics
(
    id   serial      not null primary key,
    name varchar(44) not null
);

insert into topics(name)
values ('testTopic');
