insert into accounts (username, password, rol) values
('test_admin_user@testapp.com', '-635289258', 'USER'),
('test_user_profile@testapp.com', '-635289258', 'PROFILE'),
('mickey00184@gmail.com', '-635289258', 'USER');

--insert into authorities (user_id, authority) values
--(1, 'USER_READ'),
--(1, 'USER_WRITE'),
--(1, 'PROFILE_READ'),
--(1, 'PROFILE_WRITE'),
--(2, 'PROFILE_READ'),
--(2, 'PROFILE_WRITE'),
--(3, 'USER_READ'),
--(3, 'USER_WRITE'),
--(3, 'PROFILE_READ'),
--(3, 'PROFILE_WRITE');
--
--insert into profiles (user_id, full_name, date_of_birth, phone, address, city, country, zip_code, profile_picture_url) values
--(1, 'Test Main User', '2025-10-07', '1234567890', '123 Admin St', 'Admin City', 'Admin Country', '12345', null),
--(2, 'Test User Profile', '2025-10-07', '0m87654321', '456 Test Ave', 'Test City', 'Test Country', '67890', null),
--(3, 'Mickey Mouse', '1994-09-29', '5647678175', 'Ahorro Postal 45', 'Benito Juarez', 'Mexico', '03410', null);
--
--insert into profile_locale_settings (profile_id, language_code, country_code, date_format) values
--(1, 'en', 'US', 'MM/dd/yyyy'),
--(2, 'es', 'MX', 'dd/MM/yyyy'),
--(3, 'es', 'MX', 'dd/MM/yyyy');
