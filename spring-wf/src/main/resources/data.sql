
--Создаем схему и последовательность для PK
--Создаем таблицу Person и последовательность для PK
--Вставляем данные в Person с учетом Sequence
CREATE SCHEMA IF NOT EXISTS test;

CREATE TABLE test.person  (
    id int4 NOT NULL ,
    name varchar(256) NOT NULL,
    age int NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS test.person_seq;

INSERT INTO test.person(id, name, age) VALUES
    (NEXTVAL('test.person_seq'),'Руслан', 32),
    (NEXTVAL('test.person_seq'),'Егор', 30),
    (NEXTVAL('test.person_seq'),'Михаил', 25);