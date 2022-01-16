create table userr(
    username varchar_ignorecase(50) not null primary key,
    password varchar_ignorecase(50) not null,
    enables boolean not null
);

create table authority(
    username varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_users foreign key (username) references userr (username)
);

create unique index ix_auth_username on authority (username, authority)