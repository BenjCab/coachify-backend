set schema 'public';

insert into accounts(first_name, last_name, email, password, enabled)
values ('Testa', 'Test', 'test@test.com', '$2a$10$fMwGqxsxtRttQsFl3g8GXeYDK3BJMeZH4MM9ZYlgnw9T42cxXux7u', true);
insert into authorities(account_id, authority)
values (1, 'COACH');
insert into authorities(account_id, authority)
values (1, 'COACHEE');

insert into accounts(first_name, last_name, email, password, enabled)
values ('Bart', 'Simpson', 'bart@test.com', '$2a$10$fMwGqxsxtRttQsFl3g8GXeYDK3BJMeZH4MM9ZYlgnw9T42cxXux7u', true);
insert into authorities(account_id, authority)
values (2, 'COACHEE');

insert into accounts(first_name, last_name, email, password, enabled)
values ('Marge', 'Simpson', 'marge@test.com', '$2a$10$fMwGqxsxtRttQsFl3g8GXeYDK3BJMeZH4MM9ZYlgnw9T42cxXux7u', true);
insert into authorities(account_id, authority)
values (3, 'COACH');
insert into authorities(account_id, authority)
values (3, 'COACHEE');
insert into authorities(account_id, authority)
values (3, 'ADMIN');

insert into coach_profile(account_id, introduction, availability, image)
values (3, 'Hello,my name is Marge Simpson', 'every sunday', './assets/images/profile-picture-coach.png');

insert into coach_profile(account_id, introduction, availability, image)
values (1, 'test intro', 'every day', './assets/images/profile-picture-coach.png');

insert into topics(topic_name) values ('Python');
insert into topics(topic_name) values ('Angular');

insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(1, 1, true, false, false);

insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(1, 2, false, true, false);

insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(2, 2, false, false, true);

insert into sessions(coach_id, coachee_id, subject, location, remarks, session_date, session_time)
values (1, 2, 'python', 'at home', 'pancakes', '2021-06-25', '08:00:00');

insert into sessions(coach_id, coachee_id, subject, location, remarks, session_date, session_time)
values (2, 3, 'angular', 'online', 'learning the admin something', '2021-07-25', '21:30:00');





