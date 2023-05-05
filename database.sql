DROP DATABASE IF EXISTS bazasait;
CREATE DATABASE bazasait;
USE bazasait;
CREATE TABLE potrebiteli(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255),
	pass VARCHAR(255)
);
INSERT INTO potrebiteli VALUES
	(1, "admin", "admin"),
	(2, "usr", "u");