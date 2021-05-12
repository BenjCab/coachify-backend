SET SCHEMA 'public';

create table if not exists topic_by_coach
(
    id       serial  not null primary key,
    coach_id int     not null
        constraint topicByCoach_coaches_id_fk references coaches,
    topic_id int     not null
        constraint topicByCoach_topics_id_fk references topics,
    grade1   boolean not null,
    grade2   boolean not null,
    grade3   boolean not null,
    grade4   boolean not null,
    grade5   boolean not null,
    grade6   boolean not null,
    grade7   boolean not null
);

insert into topic_by_coach (coach_id, topic_id, grade1, grade2, grade3, grade4, grade5, grade6, grade7)
values (1, 1, false, false, false, false, true, true, false);
