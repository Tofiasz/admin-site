INSERT INTO
role  (role_name) VALUES
('ROLE_USER'),
('ROLE_MODERATOR'),
('ROLE_ADMIN');

insert into admin_user (password, user_name, account_non_locked, failed_attempt, enabled)
values ('$2a$10$rWKBKaDW/xDgRZJnC1bs4.q3hbNgzEWujudfW5sDCfaMzn1eEyGem', 'admin', true, '0', true);

insert into admin_user_roles (admin_user_id, roles_id) values ('1', '1');
insert into admin_user_roles (admin_user_id, roles_id) values ('1', '2');
insert into admin_user_roles (admin_user_id, roles_id) values ('1', '3');

insert into admin_user (password, user_name, account_non_locked, failed_attempt, enabled)
values ('$2a$12$fdygmfc6pg16WiO0SMgijeGnYjqStD/TiV9U.0h/7Vjkoy3holVfu', 'moderator', true, '0', true);

insert into admin_user_roles (admin_user_id, roles_id) values ('2', '1');
insert into admin_user_roles (admin_user_id, roles_id) values ('2', '2');

insert into admin_user (password, user_name, account_non_locked, failed_attempt, enabled)
values ('$2a$12$RsipernU4.QATy5KKd1eC.bEQxarW9x3YVAOQLqIV1ijsdU5vG3Zi', 'user', true, '0', true);

insert into admin_user_roles (admin_user_id, roles_id) values ('3', '1');

insert into admin_user (password, user_name, account_non_locked, failed_attempt, enabled)
values ('$2a$10$rWKBKaDW/xDgRZJnC1bs4.q3hbNgzEWujudfW5sDCfaMzn1eEyGem', 'admin1', true, '0', true);

insert into admin_user_roles (admin_user_id, roles_id) values ('4', '1');
insert into admin_user_roles (admin_user_id, roles_id) values ('4', '2');
insert into admin_user_roles (admin_user_id, roles_id) values ('4', '3');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Łódź', 'Małego Rycerza', '56', '5', '93-633', '500-421-300');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Gdańsk', 'Wąskotorowa', '111', '1', '80-774', '500-400-312');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Łódź', 'Usługowa', '11', '11', '92-647', '500-421-301');

insert into address (country, city, street, house_number, zip_code, phone_number)
values ('Poland', 'Lublin', 'Daszyńskiego Ignacego', '77', '20-250', '500-400-302');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Łódź', 'Małego Rycerza', '56', '5', '93-633', '500-400-320');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Warszawa', 'Polna', '83', '5', '93-633', '500-400-100');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Olsztyn', 'Kresowa', '94', '1', '60-773', '500-400-123');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Poznań', 'Zagumienna', '56', '5', '15-583', '500-400-234');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Białystok', 'Bukowskiego Jerzego', '56', '5', '10-698', '500-433-300');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Olsztyn', 'Bacieczki', '56', '5', '15-685', '500-400-984');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Białystok', 'Wiejska', '56', '5', '93-633', '501-400-123');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Kraków', 'Starego Wiarusa', '56', '5', '31-263', '520-400-300');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Szczecin', 'Owcza', '4', '5', '20-229', '503-400-300');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Szczecin', 'Lednicka', '111', '5', '70-733', '500-912-300');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Kraków', 'Niepokalanej Marii', '94', '5', '04-559', '500-654-300');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Bydgoszcz', 'Polanka', '35', '5', '86-105', '500-412-300');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Zielona Góra', 'Kręta', '1', '5', '41-404', '500-756-300');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Wydminy', 'Grunwaldzka', '126', '5', '92-109', '500-321-300');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Łódź', 'Warszawa', '56', '5', '01-466', '500-123-300');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Lublin', 'Potok', '56', '5', '20-819', '500-745-300');

insert into address (country, city, street, house_number, apartment_number, zip_code, phone_number)
values ('Poland', 'Łódź', 'Kazubów', '56', '5', '91-068', '500-441-300');

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Oskar', '$2a$12$HtzV9dLvuDLi5wqkgWp91.XDTHwZLc/x/ZEmehH3YrW7eCVr2Duiy', 'Oskar', 'Górecki', 'oskar.gorecki@o2.pl', '2019-03-29', true, 1);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Marcel', '$2a$12$LTEE/f3oOsHmbOUBbWKel.P6P2HMhd6tiMVb99DQdPsXPC/7LaCz2', 'Marcel', 'Wróblewski', 'marcel.wroblewski@onet.pl', '2018-08-19', false, 2);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Jędrzej', '$2a$12$6OlFnk9ug6usLgD0ewjEq.bBBKAyHie9X3SF1neqgiK1IgizNo8E.', 'Jędrzej', 'Sikora', 'jedrzej.sikora@gmail.com', '2021-07-21', false, 3);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Fabian', '$2a$12$kvDW1SbS85E8ucLAKdkcHONmZCT5QkbIVETNqqR/JQEQrXEaoDUiS', 'Fabian', 'Kaczmarczyk', 'karol.kaczmarczyk@onet.pl', '2021-04-21', true, 4);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Cyprian', '$2a$12$HnCz0y.z.u38CTz0jbkApuJ8b9V/E18GZPPqwjCZMuIznxbze4uxC', 'Cyprian', 'Stępień', 'cyprian.stepien@gmail.com', '2022-01-01', true, 5);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Joachim', '$2a$12$gqSKtGH4x9eArGBFm/1w2.0aki2CGYvL4NWoGEwp2.NOo0pl5o.Di', 'Joachim', 'Kaźmierczak', 'joachim.kazmierczak@o2.pl', '2020-06-20', false, 6);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Franciszek', '$2a$12$xWs9SviozuZNp6TobOkDyu5Oklim8qMHqRrKm82HCwjI2a0iFoIEm', 'Franciszek', 'Czarnecki', 'franciszek.czarnecki@o2.pl', '2018-05-14', true, 7);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Bolesław', '$2a$12$7.7WOjilqpRx6nhwzA9.a.Ir/lABTSmsUjrmlg8j5jyKEpIDyuuua', 'Bolesław', 'Pietrzak', 'boleslaw.pietrzak@onet.pl', '2021-07-07', false, 8);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Karol', '$2a$12$V.3tWv3G57T8EcDnxhRwwuOqSyIB3sb3x1ROkm4QuAmZ6rnPWiouC', 'Karol', 'Szymczak', 'karol.szymczak@gmail.com', '2020-03-13', true, 9);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Florian', '$2a$12$Mh4Cr7DzsN7.e.rtnUn5c.l82RyceoD8eq7wLxNambsIaIgecK3Jq', 'Florian', 'Pawlak', 'florian.pawlak@gmail.com', '2015-10-14', false, 10);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Anatolia', '$2a$12$XfNOOccb/GV2qQ58cAz3cuMYuSSiLknXYvM09hVehJFSGOC/uu6bi', 'Anatolia', 'Wójcik', 'anatolia.wojcik@onet.pl', '2006-11-15', true, 11);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Regina', '$2a$12$uRWcagVviS1RKdabePWzA.O5ToOMkZdaEsH0PT/EPI197bVozx2ve', 'Regina', 'Chmielewska', 'regina.chmielewska@gmail.com', '2020-02-01', true, 12);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Marysia', '$2a$12$AQzrvGebepdnZFf416QOTe0G6N0bd0Zae60T4jqdWqbQ9wl61X6oC', 'Marysia', 'Jasińska', 'marysia.jasinska@o2.pl', '2019-07-15', false, 13);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Hortensja', '$2a$12$53ZhPHXeAhDtIYwGEtoyseOxpYtZBpgmjyWGXUFLQ/s53F1CGz5gm', 'Hortensja', 'Pawlak', 'hortensja.pawlak@gmail.com', '2021-04-19', true, 14);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Beata', '$2a$12$inzko4.Wy13yKQdR0qRr4eoKm5ftMqqJuoXcFTbeP/jT9fiM.WTPC', 'Beata', 'Zalewska', 'beata.zalewska@onet.pl', '2022-02-02', false, 15);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Zofia', '$2a$12$aSj0t./OMYyYjtd88uA6P.tA2kHYWptaDgGVDg2zVMou9Y0okJ7yK', 'Zofia', 'Sadowska', 'zofia.sadowska@gmail.com', '2021-01-01', true, 16);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Gabriela', '$2a$12$ESQsqCpU1o6a3bMhj7n7leRBiYo/m7T2lNEPDJ10aqoCofjM67XJC', 'Gabriela', 'Błaszczyk', 'gabriela.blaszczyk@o2.plm', '2020-05-10', true, 17);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Marlena', '$2a$12$OssZFEAw/0.reLVnzC0YY.IeLs/O1LTYzr3/oO7hjRoSM3YCU7mMa', 'Marlena', 'Sokołowska', 'marlena.sokolowska@o2.pl', '2020-12-30', true, 18);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Helena', '$2a$12$LZ9psu5VLLammR5fCKOv6.qhv4Eix6hDQNImUXcBvqm8Eyvg07Num', 'Helena', 'Marciniak', 'helena.marciniak@gmail.com', '2022-02-21', true, 19);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Elwira', '$2a$12$LRsXqeuD.bg.M7V9Br9vZu8kjB9yrbGA./Ev3IgsaJAo5qRgQB.Tu', 'Elwira', 'Jasińska', 'elwira.jasinska@onet.pl', '2020-04-25', false, 20);

insert into customer (login, password, first_name, last_name, email_address, registration_date, is_account_verified, address_id)
values ('Justyna', '$2a$12$wshxpmhjKyXElZJb5mLGI.lObzsaC.om7BaYFw5ZhYZpgXxkzLL6W', 'Justyna', 'Bąk', 'justyna.bak@gmail.com', '2022-03-16', true, 21);

insert into category (title, meta_title, content)
values ('Computer, Tables & Accessories', 'Computer, Tables & Accessories - meta title', 'Computer, Tables & Accessories - content');

insert into product_category (title, meta_title, content, category_id)
values ('Laptop & MacBooks', 'Laptop & MacBooks - meta title', 'Laptop & MacBooks - content', '1');

insert into product_type (title, meta_title, content, product_category_id)
values ('Windows Laptops', 'Windows Laptops - meta title', 'Windows Laptops - content', '1');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Windows Laptop 1', 'Windows Laptop 1 - meta title', 'Windows Laptop 1 - content', '2022-05-11 20:02:32.375', 'WIN/WIN', '978020137962', '2000', '23', 'true', '100', '1', '1');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Windows Laptop 2', 'Windows Laptop 2 - meta title', 'Windows Laptop 2 - content', '2022-05-11 20:02:32.375', 'WIN/WIN', '978020137963', '3000', '23', 'true', '200', '1', '1');

insert into product_type (title, meta_title, content, product_category_id)
values ('Macbooks', 'Macbooks - meta title', 'Macbooks - content', '1');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Macbook Laptop 1', 'Macbook Laptop 1 - meta title', 'Macbook Laptop 1 - content', '2022-05-11 20:02:32.375', 'MAC/MAC', '978020117963', '5000', '23', 'true', '231', '1', '2');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Macbook Laptop 2', 'Macbook Laptop 2 - meta title', 'Macbook Laptop 2 - content', '2022-05-11 20:02:32.375', 'MAC/MAC', '978020117963', '7000', '23', 'true', '541', '1', '2');

insert into product_type (title, meta_title, content, product_category_id)
values ('Chromebooks', 'Chromebooks - meta title', 'Chromebooks - content', '1');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Chromebook Laptop 1', 'Chromebook Laptop 1 - meta title', 'Chromebook Laptop 1 - content', '2022-05-11 20:02:32.375', 'CHR/CHR', '978220117963', '13', '23', 'true', '351', '1', '3');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Chromebook Laptop 2', 'Chromebook Laptop 2 - meta title', 'Chromebook Laptop 2 - content', '2022-05-11 20:02:32.375', 'CHR/CHR', '978220114963', '133', '23', 'true', '594', '1', '3');

insert into product_type (title, meta_title, content, product_category_id)
values ('Gaming Laptops', 'Gaming Laptops - meta title', 'Gaming Laptops - content', '1');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Gaming Laptop 1', 'Gaming Laptop 1 - meta title', 'Gaming Laptop 1 - content', '2022-05-11 20:02:32.375', 'GAM/GAM', '978220114963', '1120', '23', 'true', '3501', '1', '4');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Gaming Laptop 2', 'Gaming Laptop 2 - meta title', 'Gaming Laptop 2 - content', '2022-05-11 20:02:32.375', 'GAM/GAM', '978320114963', '3120', '23', 'true', '34', '1', '4');

insert into product_category (title, meta_title, content, category_id)
values ('Desktop Computers', 'Desktop Computers - meta title', 'Desktop Computers - content', '1');

insert into product_type (title, meta_title, content, product_category_id)
values ('Everyday Computers', 'Everyday Computers - meta title', 'Everyday Computers - content', '2');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Everyday Computer 1', 'Everyday Computer 1 - meta title', 'Everyday Computer 1 - content', '2022-05-11 20:02:32.375', 'EVR/EVR', '978220124963', '120', '23', 'true', '400', '1', '5');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Everyday Computer 2', 'Everyday Computer 2 - meta title', 'Everyday Computer 2 - content', '2022-05-11 20:02:32.375', 'EVR/EVR', '948220124963', '320', '23', 'true', '440', '1', '5');

insert into product_type (title, meta_title, content, product_category_id)
values ('Gaming Desktop Computers', 'Gaming Desktop Computers - meta title', 'Gaming Desktop Computers - content', '2');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Gaming Computer 1', 'Gaming Computer 1 - meta title', 'Gaming Computer 1 - content', '2022-05-11 20:02:32.375', 'GAC/GAC', '948120124963', '1320', '23', 'true', '1320', '1', '6');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Gaming Computer 2', 'Gaming Computer 2 - meta title', 'Gaming Computer 2 - content', '2022-05-11 20:02:32.375', 'GAC/GAC', '948120124463', '1520', '23', 'true', '131', '1', '6');

insert into product_type (title, meta_title, content, product_category_id)
values ('All-In-One Computers', 'All-In-One Computers - meta title', 'All-In-One Computers - content', '2');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('All-In-One Computer 1', 'All-In-One Computer 1 - meta title', 'All-In-One Computer 1 - content', '2022-05-11 20:02:32.375', 'ALL/ALL', '948120134963', '1310', '23', 'true', '10', '1', '7');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('All-In-One Computer 2', 'All-In-One Computer 2 - meta title', 'All-In-One Computer 2 - content', '2022-05-11 20:02:32.375', 'ALL/ALL', '948120154463', '1580', '23', 'true', '11', '1', '7');

insert into product_type (title, meta_title, content, product_category_id)
values ('Apple Imac', 'Apple Imac - meta title', 'Apple Imac - content', '2');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Apple Imac 1', 'Apple Imac 1 - meta title', 'Apple Imac 1 - content', '2022-05-11 20:02:32.375', 'APP/APP', '948120134563', '131', '23', 'true', '130', '1', '8');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Apple Imac 2', 'Apple Imac 2 - meta title', 'Apple Imac 2 - content', '2022-05-11 20:02:32.375', 'APP/APP', '948120153463', '150', '23', 'true', '121', '1', '8');

insert into product_type (title, meta_title, content, product_category_id)
values ('Apple Mac Pro', 'Apple Mac Pro - meta title', 'Apple Mac Pro - content', '2');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Apple Mac Pro 1', 'Apple Mac Pro 1 - meta title', 'Apple Mac Pro 1 - content', '2022-05-11 20:02:32.375', 'AMP/AMP', '948120134163', '151', '23', 'true', '1301', '1', '9');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Apple Mac Pro 2', 'Apple Mac Pro 2 - meta title', 'Apple Mac Pro 2 - content', '2022-05-11 20:02:32.375', 'AMP/AMP', '948120153463', '110', '23', 'true', '1210', '1', '9');

insert into product_category (title, meta_title, content, category_id)
values ('Tablet & Ipads', 'Tablet & Ipads - meta title', 'Tablet & Ipads - content', '1');

insert into product_type (title, meta_title, content, product_category_id)
values ('Android Tablets', 'Android - meta title', 'Android - content', '3');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Android Tablets 1', 'Android Tablets 1 - meta title', 'Android Tablets 1 - content', '2022-05-11 20:02:32.375', 'ANT/ANT', '948120154163', '150', '23', 'true', '111', '1', '10');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Android Tablets 2', 'Android Tablets 2 - meta title', 'Android Tablets 2 - content', '2022-05-11 20:02:32.375', 'ANT/ANT', '948120113463', '112', '23', 'true', '141', '1', '10');

insert into product_type (title, meta_title, content, product_category_id)
values ('Windows Tablets', 'Windows - meta title', 'Windows - content', '3');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Windows Tablets 1', 'Windows Tablets 1 - meta title', 'Windows Tablets 1 - content', '2022-05-11 20:02:32.375', 'WIT/WIT', '948120154113', '110', '23', 'true', '123', '1', '11');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Windows Tablets 2', 'Windows Tablets 2 - meta title', 'Windows Tablets 2 - content', '2022-05-11 20:02:32.375', 'WIT/WIT', '948120113433', '132', '23', 'true', '143', '1', '11');

insert into product_type (title, meta_title, content, product_category_id)
values ('Apple Tablets', 'Apple - meta title', 'Apple - content', '3');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Apple Tablets 1', 'Apple Tablets 1 - meta title', 'Apple Tablets 1 - content', '2022-05-11 20:02:32.375', 'APT/APT', '948120454113', '1100', '23', 'true', '1213', '1', '12');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Apple Tablets 2', 'Apple Tablets 2 - meta title', 'Apple Tablets 2 - content', '2022-05-11 20:02:32.375', 'APT/APT', '948120111433', '13', '23', 'true', '1433', '1', '12');

insert into product_category (title, meta_title, content, category_id)
values ('eReaders & Accessories', 'eReaders & Accessories - meta title', 'eReaders & Accessories - content', '1');

insert into product_type (title, meta_title, content, product_category_id)
values ('eReaders', 'eReaders - meta title', 'eReaders - content', '4');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('eReader 1', 'eReader 1 - meta title', 'eReader 1 - content', '2022-05-11 20:02:32.375', 'ERR/ERR', '948120454113', '2200', '23', 'true', '1233', '1', '13');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('eReader 2', 'eReader 2 - meta title', 'eReader 2 - content', '2022-05-11 20:02:32.375', 'ERR/ERR', '948120111433', '132', '23', 'true', '133', '1', '13');

insert into product_type (title, meta_title, content, product_category_id)
values ('eReader Cases & Accessories', 'eReader Cases & Accessories - meta title', 'eReader Cases & Accessories - content', '4');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('eReader Case 1', 'eReader Case 1 - meta title', 'eReader Case 1 - content', '2022-05-11 20:02:32.375', 'ERC/ERC', '948121454113', '2230', '23', 'true', '1243', '1', '14');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('eReader Case 2', 'eReader Case 2 - meta title', 'eReader Case 2 - content', '2022-05-11 20:02:32.375', 'ERC/ERC', '948120121433', '1320', '23', 'true', '1313', '1', '14');

insert into product_category (title, meta_title, content, category_id)
values ('Tablet & Ipad Accessories', 'Tablet & Ipad Accessories - meta title', 'Tablet & Ipad Accessories - content', '1');

insert into product_type (title, meta_title, content, product_category_id)
values ('Tablet & Ipad Cases', 'Tablet & Ipad Cases - meta title', 'Tablet & Ipad Cases - content', '5');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Tablet Case 1', 'Tablet Case 1 - meta title', 'Tablet Case 1 - content', '2022-05-11 20:02:32.375', 'TAC/TAC', '948121424113', '2030', '23', 'true', '243', '1', '15');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Tablet Case 2', 'Tablet Case 2 - meta title', 'Tablet Case 2 - content', '2022-05-11 20:02:32.375', 'TAC/TAC', '948121121433', '1020', '23', 'true', '113', '1', '15');

insert into product_type (title, meta_title, content, product_category_id)
values ('Tablet & Ipad Screen Protectors', 'Tablet & Ipad Screen Protectors - meta title', 'Tablet & Ipad Screen Protectors - content', '5');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Tablet Screen Protector 1', 'Tablet Screen Protector 1 - meta title', 'Tablet Screen Protector 1 - content', '2022-05-11 20:02:32.375', 'TSP/TSP', '948121424123', '2031', '23', 'true', '243', '1', '16');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Tablet Screen Protector 2', 'Tablet Screen Protector 2 - meta title', 'Tablet Screen Protector 2 - content', '2022-05-11 20:02:32.375', 'TSP/TSP', '948121121413', '1020', '23', 'true', '1123', '1', '16');

insert into product_type (title, meta_title, content, product_category_id)
values ('Tablet & Ipad Keyboards', 'Tablet & Ipad Keyboards - meta title', 'Tablet & Ipad Keyboards - content', '5');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Tablet Keyboard 1', 'Tablet Keyboard 1 - meta title', 'Tablet Keyboard 1 - content', '2022-05-11 20:02:32.375', 'TKE/TKE', '948120424123', '21', '23', 'true', '43', '1', '17');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Tablet Keyboard 2', 'Tablet Keyboard 2 - meta title', 'Tablet Keyboard 2 - content', '2022-05-11 20:02:32.375', 'TKE/TKE', '948125121413', '10', '23', 'true', '123', '1', '17');

insert into product_type (title, meta_title, content, product_category_id)
values ('Tablet & Ipad Charges', 'Tablet & Ipad Charges - meta title', 'Tablet & Ipad Charges - content', '5');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Tablet Charge 1', 'Tablet Charge 1 - meta title', 'Tablet Charge 1 - content', '2022-05-11 20:02:32.375', 'CKE/CKE', '948120424423', '231', '23', 'true', '434', '1', '18');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Tablet Charge 2', 'Tablet Charge 2 - meta title', 'Tablet Charge 2 - content', '2022-05-11 20:02:32.375', 'CKE/CKE', '948125121713', '105', '23', 'true', '1231', '1', '18');

insert into category (title, meta_title, content)
values ('Cell Phones and Accessories', 'Cell Phones and Accessories - meta title', 'Cell Phones and Accessories - content');

insert into product_category (title, meta_title, content, category_id)
values ('Cell Phones', 'Cell Phones - meta title', 'Cell Phones - content', '2');

insert into product_type (title, meta_title, content, product_category_id)
values ('Iphone', 'Iphone - meta title', 'Iphone - content', '6');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Iphone 1', 'Iphone 1 - meta title', 'Iphone 1 - content', '2022-05-11 20:02:32.375', 'IPH/IPH', '948120423423', '2321', '23', 'true', '34', '1', '19');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Iphone 2', 'Iphone 2 - meta title', 'Iphone 2 - content', '2022-05-11 20:02:32.375', 'IPH/IPH', '948125121713', '1105', '23', 'true', '1331', '1', '19');

insert into product_type (title, meta_title, content, product_category_id)
values ('Android Phones', 'Android Phones - meta title', 'Android Phones - content', '6');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Android 1', 'Android 1 - meta title', 'Android 1 - content', '2022-05-11 20:02:32.375', 'AND/AND', '943120423423', '232', '23', 'true', '1', '1', '20');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Android 2', 'Android 2 - meta title', 'Android 2 - content', '2022-05-11 20:02:32.375', 'AND/AND', '942125121713', '115', '23', 'true', '131', '1', '20');

insert into product_category (title, meta_title, content, category_id)
values ('Cell Phones Accessories', 'Cell Phones Accessories - meta title', 'Cell Phones Accessories - content', '2');

insert into product_type (title, meta_title, content, product_category_id)
values ('Cell Phones Cases', 'Cell Phones Cases - meta title', 'Cell Phones Cases - content', '7');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Cell Phones Case 1', 'Cell Phones Case 1 - meta title', 'Cell Phones Case 1 - content', '2022-05-11 20:02:32.375', 'CEC/CEC', '943321423423', '232', '23', 'true', '210', '1', '21');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Cell Phones Case 2', 'Cell Phones Case 2 - meta title', 'Cell Phones Case 2 - content', '2022-05-11 20:02:32.375', 'CEC/CEC', '842122121713', '1151', '23', 'true', '311', '1', '21');

insert into product_type (title, meta_title, content, product_category_id)
values ('Screen Protectors', 'Screen Protectors - meta title', 'Screen Protectors - content', '7');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Screen Protector 1', 'Screen Protector 1 - meta title', 'Screen Protector 1 - content', '2022-05-11 20:02:32.375', 'CEE/CEE', '923321423423', '23', '23', 'true', '2100', '1', '22');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Screen Protector 2', 'Screen Protector 2 - meta title', 'Screen Protector 2 - content', '2022-05-11 20:02:32.375', 'CEE/CEE', '742122121713', '11', '23', 'true', '3110', '1', '22');

insert into product_type (title, meta_title, content, product_category_id)
values ('Portable Phone Charges, Charging & Batteries', 'Portable Phone Charges, Charging & Batteries - meta title', 'Portable Phone Charges, Charging & Batteries- content', '7');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Portable Phone Charger 1', 'Portable Phone Charger 1 - meta title', 'Screen Protector 1 - content', '2022-05-11 20:02:32.375', 'PPC/PPC', '923322423423', '5', '23', 'true', '210', '1', '23');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Portable Phone Charger 2', 'Portable Phone Charger 2 - meta title', 'Portable Phone Charger 2 - content', '2022-05-11 20:02:32.375', 'PPC/PPC', '742122121713', '6', '23', 'true', '310', '1', '23');

insert into category (title, meta_title, content)
values ('Office Supplies & Ink', 'Office Supplies & Ink - meta title', 'Office Supplies & Ink - content');

insert into product_category (title, meta_title, content, category_id)
values ('Ink & Toner Cartridges', 'Ink & Toner Cartridges - meta title', 'Ink & Toner Cartridges - content', '3');

insert into product_type (title, meta_title, content, product_category_id)
values ('Printer Ink', 'Printer Ink - meta title', 'Printer Ink - content', '8');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Printer Ink 1', 'Printer Ink 1 - meta title', 'Printer Ink 1 - content', '2022-05-11 20:02:32.375', 'PIN/PIN', '923321423423', '33', '23', 'true', '20', '1', '24');

insert into product (title, meta_title, content, created_at, stock_keeping_unit, codeean, price, tax, product_available, quantity, product_category_id, product_type_id)
values ('Printer Ink 2', 'Printer Ink 2 - meta title', 'Printer Ink 2 - content', '2022-05-11 20:02:32.375', 'PIN/PIN', '742123121713', '54', '23', 'true', '30', '1', '24');

insert into product_type (title, meta_title, content, product_category_id)
values ('Printer Toner', 'Printer Toner - meta title', 'Printer Toner - content', '8');

insert into product_type (title, meta_title, content, product_category_id)
values ('3D Printer Cartridges', '3D Printer Cartridges - meta title', '3D Printer Cartridges - content', '8');

insert into product_category (title, meta_title, content, category_id)
values ('Printers, Scanners & Fax', 'Printers, Scanners & Fax - meta title', 'Printers, Scanners & Fax - content', '3');

insert into product_type (title, meta_title, content, product_category_id)
values ('Supertank Printers', 'Supertank Printers - meta title', 'Supertank Printers - content', '9');

insert into product_type (title, meta_title, content, product_category_id)
values ('Inkjet Printers', 'Inkjet Printers - meta title', 'Inkjet Printers - content', '9');

insert into product_type (title, meta_title, content, product_category_id)
values ('Laser Printers', 'Laser Printers - meta title', 'Laser Printers - content', '9');

insert into product_type (title, meta_title, content, product_category_id)
values ('Specialty Printers', 'Specialty Printers - meta title', 'Specialty Printers - content', '9');

insert into category (title, meta_title, content)
values ('TV & Home Theater', 'TV & Home Theater - meta title', 'TV & Home Theater - content');

insert into product_category (title, meta_title, content, category_id)
values ('Televisions', 'Televisions - meta title', 'Televisions - content', '4');

insert into product_type (title, meta_title, content, product_category_id)
values ('40 - 50 inch TVs', '40 - 50 inch TVs - meta title', '40 - 50 inch TVs - content', '10');

insert into product_type (title, meta_title, content, product_category_id)
values ('50 - 60 inch TVs', '50 - 60 inch TVs - meta title', '50 - 60 inch TVs - content', '10');

insert into product_type (title, meta_title, content, product_category_id)
values ('60 - 70 inch TVs', '60 - 70 inch TVs - meta title', '60 - 70 inch TVs - content', '10');

insert into product_category (title, meta_title, content, category_id)
values ('Projectors, Screen & Access', 'Projectors, Screen & Access', 'Projectors, Screen & Access', '4');

insert into product_type (title, meta_title, content, product_category_id)
values ('Projectors', 'Projectors - meta title', 'Projectors - content', '11');

insert into product_type (title, meta_title, content, product_category_id)
values ('Projector Screens', 'Projector Screens - meta tile', 'Projector Screens - content', '11');

insert into product_type (title, meta_title, content, product_category_id)
values ('Projector Mounts & Stands', 'Projector Mounts & Stands - meta tile', 'Projector Mounts & Stands - content', '11');

insert into product_category (title, meta_title, content, category_id)
values ('Home Audio & Theater', 'Home Audio & Theater - meta title', 'Home Audio & Theater - content', '4');

insert into product_type (title, meta_title, content, product_category_id)
values ('Sound Bars', 'Sound Bars - meta tile', 'Sound Bars & Stands - content', '12');

insert into product_type (title, meta_title, content, product_category_id)
values ('Home Speakers', 'Home Speakers - meta tile', 'Home Speakers - content', '12');

insert into product_type (title, meta_title, content, product_category_id)
values ('Amplifiers', 'Amplifiers - meta tile', 'Amplifiers - content', '12');

insert into category (title, meta_title, content)
values ('Cameras & Camcorders', 'Cameras & Camcorders - meta title', 'Cameras & Camcorders - content');

insert into product_category (title, meta_title, content, category_id)
values ('Cameras', 'Cameras - meta title', 'Cameras - content', '5');

insert into product_type (title, meta_title, content, product_category_id)
values ('Point & Shoot Cameras', 'Point & Shoot Cameras - meta tile', 'Point & Shoot Cameras - content', '13');

insert into product_type (title, meta_title, content, product_category_id)
values ('DSLR Cameras', 'DSLR Cameras - meta tile', 'DSLR Cameras - content', '13');

insert into product_type (title, meta_title, content, product_category_id)
values ('Mirrorless Cameras', 'Mirrorless Cameras - meta tile', 'Mirrorless Cameras - content', '13');

insert into product_category (title, meta_title, content, category_id)
values ('Drones & Accessories', 'Drones & Accessories - meta title', 'Drones & Accessories - content', '5');

insert into product_type (title, meta_title, content, product_category_id)
values ('Drones', 'Drones - meta tile', 'Drones - content', '14');

insert into product_type (title, meta_title, content, product_category_id)
values ('Drone Cases & Backpacks', 'Drone Cases & Backpacks - meta tile', 'Drone Cases & Backpacks - content', '14');

insert into product_type (title, meta_title, content, product_category_id)
values ('Drone Batteries & Charges', 'Drone Batteries & Charges - meta tile', 'Drone Batteries & Charges - content', '14');

insert into product_category (title, meta_title, content, category_id)
values ('Security & Access', 'Security & Access - meta title', 'Security & Access - content', '5');

insert into product_type (title, meta_title, content, product_category_id)
values ('Security Cameras', 'Security Cameras - meta tile', 'Security Cameras - content', '15');

insert into product_type (title, meta_title, content, product_category_id)
values ('Home Security Systems & Motion Sensors', 'Home Security Systems & Motion Sensors - meta tile', 'Home Security Systems & Motion Sensors - content', '15');

insert into category (title, meta_title, content)
values ('Headphones, Speakers & Audio', 'Headphones, Speakers & Audio - meta title', 'Headphones, Speakers & Audio - content');

insert into product_category (title, meta_title, content, category_id)
values ('Home Audio & Theater', 'Home Audio & Theater - meta title', 'Home Audio & Theater - content', '6');

insert into product_type (title, meta_title, content, product_category_id)
values ('Sound Bars', 'Sound Bars - meta tile', 'Sound Bars - content', '16');

insert into product_type (title, meta_title, content, product_category_id)
values ('Wireless Multi-Room Speakers', 'Wireless Multi-Room Speakers - meta tile', 'Wireless Multi-Room Speakers - content', '16');

insert into product_type (title, meta_title, content, product_category_id)
values ('Home Speakers', 'Home Speakers - meta tile', 'Home Speakers - content', '16');

insert into product_category (title, meta_title, content, category_id)
values ('Portable Audio', 'Portable Audio - meta title', 'Portable Audio - content', '6');

insert into product_type (title, meta_title, content, product_category_id)
values ('Portable Bluetooth Speakers', 'Portable Bluetooth Speakers - meta tile', 'Portable Bluetooth Speakers - content', '17');

insert into product_type (title, meta_title, content, product_category_id)
values ('Party Speakers', 'Party Speakers - meta tile', 'Party Speakers - content', '17');

insert into product_category (title, meta_title, content, category_id)
values ('Headphones', 'Headphones - meta title', 'Headphones - content', '6');

insert into product_type (title, meta_title, content, product_category_id)
values ('Earbuds & In-Ear Headphones', 'Earbuds & In-Ear Headphones - meta tile', 'Earbuds & In-Ear Headphones - content', '18');

insert into product_type (title, meta_title, content, product_category_id)
values ('On Ear Headphones', 'On Ear Headphones - meta tile', 'On Ear Headphones - content', '18');

insert into product_type (title, meta_title, content, product_category_id)
values ('Over Ear Headphones', 'Over Ear Headphones - meta tile', 'Over Ear Headphones - content', '18');