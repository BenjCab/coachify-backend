set schema 'public';

create table if not exists topics
(
    id         serial primary key not null,
    topic_name varchar(44)        not null
);

create table if not exists topic_by_coach
(
    id               serial primary key not null,
    coach_profile_id serial             not null,
    topic_id         serial             not null,
    grade1           boolean            not null,
    grade2           boolean            not null,
    grade3           boolean            not null

);
