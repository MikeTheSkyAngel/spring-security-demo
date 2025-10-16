insert into users (username, password) values
('account_user@testapp.com', '$2a$10$1FOuQWXXkOTCFGJgEiDjVuazXb50YFS5MfztMZpYbrkNCCKYEfJPC'),
('cards_user@testapp.com', '$2a$10$1FOuQWXXkOTCFGJgEiDjVuazXb50YFS5MfztMZpYbrkNCCKYEfJPC'),
('loans_user@testapp.com', '$2a$10$1FOuQWXXkOTCFGJgEiDjVuazXb50YFS5MfztMZpYbrkNCCKYEfJPC'),
('balance_user@testapp.com', '$2a$10$1FOuQWXXkOTCFGJgEiDjVuazXb50YFS5MfztMZpYbrkNCCKYEfJPC'),
('mickey00184@gmail.com', '$2a$10$YKo.6tlVmkXF2KETyEtR6OjG4qbSkQ.bh4V1kb5yPjmCyqKEQgJKy');

insert into roles (name, description) values
('ROLE_ADMIN', 'Role for admin users'),
('ROLE_USER', 'Role for regular users');

insert into user_roles (user_id, role_id) values
((select id from users where username = 'account_user@testapp.com'), (select id from roles where name = 'ROLE_ADMIN')),
((select id from users where username = 'cards_user@testapp.com'), (select id from roles where name = 'ROLE_ADMIN')),
((select id from users where username = 'loans_user@testapp.com'), (select id from roles where name = 'ROLE_USER')),
((select id from users where username = 'balance_user@testapp.com'), (select id from roles where name = 'ROLE_USER')),
((select id from users where username = 'mickey00184@gmail.com'), (select id from roles where name = 'ROLE_ADMIN'));
