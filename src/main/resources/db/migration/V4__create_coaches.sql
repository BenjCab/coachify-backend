SET SCHEMA 'public';

create table coaches
(
    coach_id     serial not null primary key,
    coachee_id   int    not null
        constraint coaches_users_id_fk references users,
    introduction varchar(255),
    availability varchar(255),
    image        varchar(255)
);

insert into coaches (coachee_id) values (5);
