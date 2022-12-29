/**********************************************************************************************************************/
ALTER DATABASE application CHARACTER SET utf8 COLLATE utf8_general_ci;
/**********************************************************************************************************************/
ALTER TABLE flyway_schema_history CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
/**********************************************************************************************************************/
CREATE TABLE users (
    id          VARCHAR(36)  NOT NULL,
    role        VARCHAR(255) NOT NULL,
    token       VARCHAR(255) NOT NULL,
    rules       LONGTEXT,
    bases       LONGTEXT,
    enabled     BOOLEAN      NOT NULL,
    name        VARCHAR(50)  NOT NULL,
    username    VARCHAR(50)  NOT NULL PRIMARY KEY,
    password    VARCHAR(255) NOT NULL,
    createdAt   DATETIME     NOT NULL,
    updatedAt   DATETIME     NOT NULL,
    description VARCHAR(255) NOT NULL
) ENGINE = InnoDb;
/**********************************************************************************************************************/
CREATE TABLE authorities (
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username),
    UNIQUE INDEX authorities_idx_0 (username, authority)
) ENGINE = InnoDb;
/**********************************************************************************************************************/
/* Main values                                                                                                        */
/**********************************************************************************************************************/
INSERT INTO users (id, token, name, description, role, enabled, username, password, createdAt, updatedAt)
VALUES
(uuid(), uuid(), 'admin', 'admin', 'ADMIN', 1, 'admin@mail.com', '$2a$10$HCPcw0G.du/GAz6CSDoPkOINsBs69e759Tb.8do0ykaQpcTNi/TlC', now(), now());
/**********************************************************************************************************************/
INSERT INTO authorities (username, authority)
VALUES
('admin@mail.com', 'ADMIN');
/**********************************************************************************************************************/