DROP TABLE IF EXISTS user_tickets;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS tickets;
DROP TABLE IF EXISTS subscriptions;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE subscriptions
(
    id           INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    description  TEXT    NOT NULL,
    discount     INTEGER NOT NULL
);

CREATE TABLE users
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name          VARCHAR NOT NULL,
    email         VARCHAR NOT NULL,
    password      VARCHAR NOT NULL,
    subscription  INTEGER,
    sub_expire    TIMESTAMP,
    FOREIGN KEY (subscription) REFERENCES subscriptions (id) ON DELETE RESTRICT,
    CONSTRAINT subscription_expire_not_null
        CHECK ( (subscription IS NULL) OR (sub_expire IS NOT NULL) )
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE tickets
(
    id           INTEGER   PRIMARY KEY DEFAULT nextval('global_seq'),
    description  VARCHAR   NOT NULL,
    date_time    TIMESTAMP NOT NULL,
    price        FLOAT     NOT NULL
);

CREATE TABLE user_tickets
(
    id           INTEGER   PRIMARY KEY DEFAULT nextval('global_seq'),
    user_id      INTEGER   NOT NULL,
    ticket_id    INTEGER   NOT NULL,
    cost         FLOAT     NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (ticket_id) REFERENCES tickets (id) ON DELETE CASCADE
);