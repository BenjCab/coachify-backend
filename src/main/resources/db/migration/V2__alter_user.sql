SET SCHEMA 'public';

alter table users
    drop column password;
