--liquibase formatted sql
--changeset parsentev:create_users_table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(2000)
);