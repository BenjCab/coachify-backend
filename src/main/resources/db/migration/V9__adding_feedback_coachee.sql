set schema 'public';
create table if not exists feedback_coachee
(
    session_feedback_id   serial primary key not null,
    explanation_rating   int not null,
    useful_rating      int not null,
    comment1     varchar(255),
    comment2     varchar(255)
);

ALTER TABLE sessions ADD COLUMN feedback_coachee_id int;

ALTER TABLE sessions ADD foreign key(feedback_coachee_id)
    REFERENCES feedback_coachee(session_feedback_id);

