/* Please manually create schema + table with a test record */

CREATE TABLE my_test_schema.test_users
(
    id  serial PRIMARY KEY,
    data  jsonb
);

INSERT INTO my_test_schema.test_users(data)
VALUES ('{"greeting": "hi"}');
