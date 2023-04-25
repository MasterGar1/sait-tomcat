DROP DATABASE IF EXISTS bazasait;
CREATE DATABASE bazasait;
USE bazasait;
CREATE TABLE users(id INT, username VARCHAR(255), password VARCHAR(255));
INSERT INTO users VALUES (1, "admin", "admin");