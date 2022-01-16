INSERT INTO userr (username, password, enabled)
values (
        'user',
        'pass',
        true);

INSERT INTO userr (username, password, enabled)
values (
        'admin',
        'pass',
        true);

INSERT INTO authority (username, authority)
values ('user', 'ROLE_USER');

INSERT INTO authority (username, authority)
values ('admin', 'ROLE_ADMIN');