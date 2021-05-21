set schema 'public';

create table if not exists sessions
(
    session_id   serial primary key not null,
    coach_id     serial             not null,
    coachee_id   serial             not null,
    subject      varchar(255),
    location     varchar(255),
    remarks      varchar(255),
    session_date date,
    session_time time
);
