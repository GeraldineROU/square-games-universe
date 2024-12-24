CREATE DATABASE IF NOT EXISTS square_games;

USE square_games;

CREATE TABLE IF NOT EXISTS users
(
    id INT PRIMARY KEY NOT NULL ,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(255)
);

INSERT INTO users (id, first_name, last_name, email) VALUES
  (1, 'Michael', 'Scott', 'michael.scott@dundermifflin.com'),
  (2, 'Dwight', 'Schrute', 'dwight.schrute@dundermifflin.com'),
  (3, 'Jim', 'Halpert', 'jim.halpert@dundermifflin.com'),
  (4, 'Pam', 'Beesly', 'pam.beesly@dundermifflin.com'),
  (5, 'Ryan', 'Howard', 'ryan.howard@dundermifflin.com'),
  (6, 'Angela', 'Martin', 'angela.martin@dundermifflin.com'),
  (7, 'Kevin', 'Malone', 'kevin.malone@dundermifflin.com'),
  (8, 'Oscar', 'Martinez', 'oscar.martinez@dundermifflin.com'),
  (9, 'Stanley', 'Hudson', 'stanley.hudson@dundermifflin.com'),
  (10, 'Toby', 'Flenderson', 'toby.flenderson@dundermifflin.com');
