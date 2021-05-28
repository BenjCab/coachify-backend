set schema 'public';

insert into sessions (coach_id, coachee_id, subject, location, remarks, session_date, session_time, status)
values (1, 2, 'angular', 'f2f', 'bring books', '2021-05-01', '08:00:00', 'Accepted');

insert into sessions (coach_id, coachee_id, subject, location, remarks, session_date, session_time, status)
values (1, 2, 'angular', 'f2f', 'bring more books', '2022-05-01', '08:00:00', 'Accepted');

insert into sessions (coach_id, coachee_id, subject, location, remarks, session_date, session_time, status)
values (1, 2, 'angular', 'f2f', 'bring books', '2021-05-01', '09:00:00', 'Requested');

insert into sessions (coach_id, coachee_id, subject, location, remarks, session_date, session_time, status)
values (1, 2, 'angular', 'f2f', 'bring more books', '2022-05-01', '09:00:00', 'Requested');

insert into sessions (coach_id, coachee_id, subject, location, remarks, session_date, session_time, status)
values (2, 3, 'angular', 'f2f', 'you need your reading glasses', '2021-05-01', '08:00:00', 'Accepted');

insert into sessions (coach_id, coachee_id, subject, location, remarks, session_date, session_time, status)
values (2, 3, 'angular', 'f2f', 'you need your reading glasses', '2022-05-01', '08:00:00', 'Accepted');

insert into sessions (coach_id, coachee_id, subject, location, remarks, session_date, session_time, status)
values (2, 3, 'angular', 'f2f', 'you need your reading glasses', '2021-05-01', '09:00:00', 'Requested');

insert into sessions (coach_id, coachee_id, subject, location, remarks, session_date, session_time, status)
values (2, 3, 'angular', 'f2f', 'you need your reading glasses', '2022-05-01', '09:00:00', 'Requested');

update sessions
set status= 'Requested'
where session_id = 1;

update sessions
set status= 'Requested'
where session_id = 2;

