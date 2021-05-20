create table sessions
(
    session_id   bigint auto_increment primary key not null,
    coach_id     bigint not null,
    coachee_id   bigint not null,
    subject      varchar(255),
    location     varchar(255),
    remarks      varchar(255),
    session_date date,
    session_time time
);
