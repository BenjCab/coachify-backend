set schema 'public';

ALTER TABLE if exists sessions
    ADD column status varchar(44);
