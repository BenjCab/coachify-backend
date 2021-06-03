set schema 'public';
create table if not exists feedback_coach
(
    session_feedback_id   serial primary key not null,
    rating1   int not null,
    rating2      int not null,
    comment1     varchar(255),
    comment2     varchar(255)
);

ALTER TABLE sessions ADD COLUMN feedback_coach_id int;

ALTER TABLE sessions ADD foreign key(feedback_coach_id)
    REFERENCES feedback_coach(session_feedback_id);
