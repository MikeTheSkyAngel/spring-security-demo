create table if not exists users (
    username varchar(50) primary key,
    password varchar(255) not null,
    enabled boolean default true,
    created_at timestamp default current_timestamp
);

create table if not exists authorities (
    username varchar(50) references users(username) on delete cascade,
    authority varchar(50) not null
);

create unique index if not exists idx_auth_user on authorities(username, authority);
