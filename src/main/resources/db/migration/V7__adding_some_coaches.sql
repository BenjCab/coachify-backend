set schema 'public';

insert into accounts(first_name, last_name, email, password, enabled)
values ('Bob', 'TheBuilder', 'bob@test.com', '$2a$10$fMwGqxsxtRttQsFl3g8GXeYDK3BJMeZH4MM9ZYlgnw9T42cxXux7u', true);
insert into authorities(account_id, authority)
values (10, 'COACH');
insert into authorities(account_id, authority)
values (10, 'COACHEE');

insert into accounts(first_name, last_name, email, password, enabled)
values ('Gerald', 'Bowl', 'gerald@test.com', '$2a$10$fMwGqxsxtRttQsFl3g8GXeYDK3BJMeZH4MM9ZYlgnw9T42cxXux7u', true);
insert into authorities(account_id, authority)
values (11, 'COACH');
insert into authorities(account_id, authority)
values (11, 'COACHEE');

insert into accounts(first_name, last_name, email, password, enabled)
values ('Rick', 'Sanchez', 'rick@test.com', '$2a$10$fMwGqxsxtRttQsFl3g8GXeYDK3BJMeZH4MM9ZYlgnw9T42cxXux7u', true);
insert into authorities(account_id, authority)
values (12, 'COACH');
insert into authorities(account_id, authority)
values (12, 'COACHEE');

insert into accounts(first_name, last_name, email, password, enabled)
values ('TheDoctor', 'Doctor', 'doctor@test.com', '$2a$10$fMwGqxsxtRttQsFl3g8GXeYDK3BJMeZH4MM9ZYlgnw9T42cxXux7u', true);
insert into authorities(account_id, authority)
values (13, 'COACH');
insert into authorities(account_id, authority)
values (13, 'COACHEE');

insert into topics(topic_name) values ('C#');
insert into topics(topic_name) values ('C++');
insert into topics(topic_name) values ('PHP');
insert into topics(topic_name) values ('Python-Turtle');

insert into coach_profile(account_id, introduction, availability, image)
values (10, 'intro', 'every other day', './assets/images/profile-picture-coach.png');

insert into coach_profile(account_id, introduction, availability, image)
values (11, 'test intro', 'every monday', './assets/images/profile-picture-coach.png');

insert into coach_profile(account_id, introduction, availability, image)
values (12, 'This is not an easter egg.', '2 first sundays of the month', './assets/images/profile-picture-coach.png');

insert into coach_profile(account_id, introduction, availability, image)
values (13, 'This is an introduction. im a human, not a robot. there is no planned robot invasion.', 'idk just ask me', './assets/images/profile-picture-coach.png');

insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(10, 3, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(10, 2, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(10, 5, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(11, 6, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(11, 5, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(12, 5, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(12, 4, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(13, 2, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
values(13, 6, true, false, false);
insert into topic_by_coach(coach_profile_id, topic_id, grade1, grade2, grade3)
