--liquibase formatted sql
--changeset parsentev:add_first_arg dbms:postgresql
ALTER TABLE users ADD COLUMN first_arg INTEGER;