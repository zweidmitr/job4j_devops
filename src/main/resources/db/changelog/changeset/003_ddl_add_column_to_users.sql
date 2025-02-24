--liquibase formatted sql
--changeset parsentev:add_second_arg dbms:postgresql
ALTER TABLE users ADD COLUMN second_arg INTEGER;