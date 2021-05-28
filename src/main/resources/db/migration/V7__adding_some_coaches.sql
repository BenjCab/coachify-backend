set schema 'public';

insert into accounts(first_name, last_name, email, password, enabled)
values ('Bob', 'TheBuilder', 'bob@test.com', '$2a$10$fMwGqxsxtRttQsFl3g8GXeYDK3BJMeZH4MM9ZYlgnw9T42cxXux7u', true);
insert into authorities(account_id, authority)
values (4, 'COACH');
insert into authorities(account_id, authority)
values (4, 'COACHEE');

insert into accounts(first_name, last_name, email, password, enabled)
values ('Gerald', 'of rivia', 'gerald@test.com', '$2a$10$fMwGqxsxtRttQsFl3g8GXeYDK3BJMeZH4MM9ZYlgnw9T42cxXux7u', true);
insert into authorities(account_id, authority)
values (5, 'COACH');
insert into authorities(account_id, authority)
values (5, 'COACHEE');

insert into accounts(first_name, last_name, email, password, enabled)
values ('Rick', 'Sanchez', 'rick@test.com', '$2a$10$fMwGqxsxtRttQsFl3g8GXeYDK3BJMeZH4MM9ZYlgnw9T42cxXux7u', true);
insert into authorities(account_id, authority)
values (6, 'COACH');
insert into authorities(account_id, authority)
values (6, 'COACHEE');

insert into accounts(first_name, last_name, email, password, enabled)
values ('The', 'Doctor', 'doctor@test.com', '$2a$10$fMwGqxsxtRttQsFl3g8GXeYDK3BJMeZH4MM9ZYlgnw9T42cxXux7u', true);
insert into authorities(account_id, authority)
values (7, 'COACH');
insert into authorities(account_id, authority)
values (7, 'COACHEE');

insert into topics(topic_name) values ('C#');
insert into topics(topic_name) values ('C++');
insert into topics(topic_name) values ('PHP');
insert into topics(topic_name) values ('Python-Turtle');

insert into coach_profile(account_id, introduction, availability, image)
values (4, 'i build stuff', 'every other day', './assets/images/bob.jpg');

insert into coach_profile(account_id, introduction, availability, image)
values (5, 'ill teach you how to slain monster and use good programming practice', 'every monday', './assets/images/gerald.jpg');

insert into coach_profile(account_id, introduction, availability, image)
values (6, 'This is not an easter egg.', '2 first sundays of the month', './assets/images/Rick_Sanchez.png');

insert into coach_profile(account_id, introduction, availability, image)
values (7, 'A dallek invasion is nothing compared to a typo in a URL', 'idk just ask me', './assets/images/doctor.jpg');

insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(4, 3, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(4, 2, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(4, 5, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(5, 6, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(5, 5, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(6, 5, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(6, 4, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(3, 2, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(3, 6, true, false, false);
