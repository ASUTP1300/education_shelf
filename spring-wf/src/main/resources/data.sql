CREATE SCHEMA test;

CREATE TABLE test.person (
    id int4 NOT NULL,
    name varchar(256) NOT NULL,
    age int NOT NULL
);

INSERT INTO test.person VALUES
    (1, 'Руслан', 32),
    (2, 'Егор', 30),
    (3, 'Михаил', 25);