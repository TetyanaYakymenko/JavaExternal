# -*- coding: utf-8 -*-
# MySQL Workbench Python script
# <description>
# Written in MySQL Workbench 8.0.13

INSERT INTO role (id, role_name) VALUES (1,'administrator'), (2,'moderator'), (3,'speaker'), (4, 'user');

INSERT INTO user (id, surname, name, login, password, email, role_id, salary) VALUES        (1, 'Ivanov', 'Ivan', 'ivanov', 'pass1', 'i@gmail.com', 2, 15000);
INSERT INTO user (id, surname, name, login, password, email, phone, role_id, salary) VALUES (2, 'Petrov', 'Petro', 'petrov', 'pass2', 'petr@mail.ru', 0993080201, 1, 10000);
INSERT INTO user (id, surname, name, login, password, role_id) VALUES (3,'Sidorov', 'Vasya', 'sidorov', 'pass3', 4);
INSERT INTO user (id, surname, name, login, password, email, phone, role_id, rating, salary) VALUES (4, 'Gladkov', 'Ighor', 'gladkov', 'pass4', 'gladkov@gmail.com', 0995037834, 3, 5, 7000);
INSERT INTO user (id, surname, name, login, password, email, role_id) VALUES (5, 'Blinov', 'Ivan', 'blinov', 'pass5', 'blinov@ukr.net', 4);

INSERT INTO conference (id, name, date, place) VALUES (1, 'First', 180518180000, 'Kyiv some street 5');
INSERT INTO conference (id, name, date, place) VALUES (2, 'My conference', 180618180000, 'our meeting room');
INSERT INTO conference (id, name) VALUES(3, 'Final reporting');

SET FOREIGN_KEY_CHECKS=0;
INSERT INTO report (id, name, text, speaker_id, conference_id) VALUES (1, 'First report', 'Blabla blabla', 4, 1);
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO report (id, name, text, speaker_id, conference_id) VALUES (2, 'Second', 'youhou and blalba', 4, 2);

INSERT INTO user_conference (id, user_id, conference_id, visited) VALUES (1, 3, 1, true);
INSERT INTO user_conference (id, user_id, conference_id, visited) VALUES (2, 5, 2, true);
INSERT INTO user_conference (id, user_id, conference_id, visited) VALUES (3, 1, 3, false);
INSERT INTO user_conference (id, user_id, conference_id, visited) VALUES (4, 2, 2, true);

