-- Accounts table
create table if not exists accounts (
    id serial primary key,
    username varchar(100) not null,
    password varchar(255) not null,
    rol varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp
);
