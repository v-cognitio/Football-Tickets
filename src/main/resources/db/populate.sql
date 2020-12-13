DELETE FROM tickets;
DELETE FROM user_tickets;
DELETE FROM users;
DELETE FROM subscriptions;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO subscriptions(description, discount) VALUES
    ('Basic', 10),
    ('Advanced', 25);

INSERT INTO users(name, email, password, subscription, sub_expire) VALUES
    ('Petya', 'petya@gmail.com', 12345678, 100000, '2023-01-01 00:00:00'),
    ('Leha', 'leha@gmail.com', 12345678, 100001, '2030-01-01 00:00:00');

INSERT INTO tickets(description, date_time, price) VALUES
    ('zenit-cska', '2021-05-30 16:00:00', 2100.50),
    ('zenit-loko', '2021-06-08 18:00:00', 1800.30);

INSERT INTO user_tickets(user_id, ticket_id, cost) VALUES
    (100002, 100004, 1000),
    (100002, 100004, 1500),
    (100003, 100005, 500)