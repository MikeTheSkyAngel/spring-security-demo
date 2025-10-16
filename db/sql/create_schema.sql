-- Accounts table
create table if not exists users (
    id UUID primary key default gen_random_uuid(),
    username varchar(100) not null,
    password varchar(255) not null,
    status int default 0,
    created_at timestamp default current_timestamp,
    updated_at timestamp
);

create table roles (
    id UUID primary key default gen_random_uuid(),
    name varchar(50) not null unique,
    description varchar(100),
    created_at timestamp default current_timestamp,
    updated_at timestamp
);

create table user_roles (
    user_id UUID references users(id) on delete cascade,
    role_id UUID references roles(id) on delete cascade,
    primary key (user_id, role_id)
);

create unique index if not exists idx_username on users(username);
create unique index if not exists idx_role_name on roles(name);
create index if not exists idx_user_roles_user_id on user_roles(user_id);
