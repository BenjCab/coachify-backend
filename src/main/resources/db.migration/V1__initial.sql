create table pet
(
    id           integer not null,
    name         varchar(255),
    kind         varchar(255),
    image        varchar(255),
    profile_text varchar(1023),
    popularity   varchar(255),
    primary key (id)
);