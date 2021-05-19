create table topics
(
    id         bigint auto_increment primary key not null,
    topic_name varchar(44)                       not null
);

create table topic_by_coach
(
    id               bigint auto_increment primary key not null,
    coach_profile_id bigint                            not null,
    topic_id         bigint                            not null,
    grade1           boolean,
    grade2           boolean,
    grade3           boolean

);
