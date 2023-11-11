CREATE SCHEMA IF NOT EXISTS test;



CREATE TABLE test.person  (
    id int4 NOT NULL UNIQUE,
    name varchar(256) NOT NULL,
    age int NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS test.person_seq;

INSERT INTO test.person VALUES
    (1, 'Руслан', 32),
    (2, 'Егор', 30),
    (3, 'Михаил', 25);