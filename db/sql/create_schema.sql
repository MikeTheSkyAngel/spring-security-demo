-- Accounts table
create table if not exists accounts (
    id serial primary key,
    username varchar(100) not null,
    password varchar(255) not null,
    rol varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp
);

--
--create table if not exists authorities (
--    user_id int references users(id) on delete cascade,
--    authority varchar(50) not null
--);
--
--create unique index if not exists idx_auth_user on authorities(user_id, authority);
--
---- Profiles tables
--create table if not exists profiles (
--    id serial primary key,
--    user_id int references users(id) on delete cascade,
--    full_name varchar(100) not null,
--    date_of_birth date,
--    phone varchar(20),
--    address varchar(255),
--    city varchar(100),
--    country varchar(100),
--    zip_code varchar(20),
--    profile_picture_url varchar(255),
--    status int default 0,
--    created_at timestamp default current_timestamp,
--    updated_at timestamp
--);
--
--create table if not exists profile_locale_settings (
--    profile_id int references profiles(id) on delete cascade,
--    language_code varchar(10) not null,      -- e.g., 'en', 'es'
--    country_code varchar(10),                 -- e.g., 'US', 'MX'
--    date_format varchar(20),                 -- e.g., 'yyyy-MM-dd'
--    status int default 0,
--    created_at timestamp default current_timestamp,
--    updated_at timestamp
--);
--
--create unique index if not exists idx_profile_locale on profile_locale_settings(profile_id, language_code, country_code);
