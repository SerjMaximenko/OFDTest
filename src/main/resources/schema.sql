CREATE TABLE users( id int identity primary key , username varchar(255), password varchar(255), role varchar(255));

INSERT INTO users(username, password) VALUES ('Josh1', '$2y$12$OrGTwd8ykV8cSQE2eeYZ3uyxcUM3u5cFHOpdCRpJF64UHaYuyI.5i');
INSERT INTO users(username, password) VALUES ('Josh2', '$2y$12$OrGTwd8ykV8cSQE2eeYZ3uyxcUM3u5cFHOpdCRpJF64UHaYuyI.5i');
INSERT INTO users(username, password) VALUES ('Josh3', '$2y$12$OrGTwd8ykV8cSQE2eeYZ3uyxcUM3u5cFHOpdCRpJF64UHaYuyI.5i');
INSERT INTO users(username, password) VALUES ('Josh4', '$2y$12$OrGTwd8ykV8cSQE2eeYZ3uyxcUM3u5cFHOpdCRpJF64UHaYuyI.5i');

create table balances (id int identity primary key, user_id int, balance int, balance_type varchar (255), changed datetime, FOREIGN KEY (user_id) REFERENCES users(id));

insert into balances(user_id, balance, balance_type, changed) VALUES (1, 1, 'Fixed', DATE '2015-12-17');
insert into balances(user_id, balance, balance_type, changed) VALUES (1, 2, 'Fixed', DATE '2016-12-17');
insert into balances(user_id, balance, balance_type, changed) VALUES (1, 3, 'Fixed', DATE '2017-12-17');
insert into balances(user_id, balance, balance_type, changed) VALUES (1, 4, 'Fixed', DATE '2018-12-17');
insert into balances(user_id, balance, balance_type, changed) VALUES (1, 5, 'Fixed', DATE '2019-12-17');
insert into balances(user_id, balance, balance_type, changed) VALUES (1, 6, 'Fixed', DATE '2020-12-17');
insert into balances(user_id, balance, balance_type, changed) VALUES (1, 7, 'Fixed', DATE '2020-12-17');
insert into balances(user_id, balance, balance_type, changed) VALUES (1, 8, 'Fixed', DATE '2020-12-17');