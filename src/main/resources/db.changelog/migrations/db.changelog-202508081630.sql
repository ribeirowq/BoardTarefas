--liquibase formatted sql
--changeset thiago:202508081630
--comment boards table create

CREATE TABLE BOARDS(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR NOT NULL
) ENGINE=innoDB;

--rollback DROP TABLE BOARDS