insert into users (username, password) values
('admin', 'to_be_encoded'),
('user', 'to_be_encoded');

insert into authorities (username, authority) values
('admin', 'ADMIN'),
('admin', 'USER'),
('user', 'USER');
