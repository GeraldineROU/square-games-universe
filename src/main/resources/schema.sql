CREATE SCHEMA IF NOT EXISTS mydb;

USE mydb;

CREATE TABLE IF NOT EXISTS players(
                                      id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                      name VARCHAR (100) NOT NULL
    );

INSERT INTO players (id, name) VALUES
                                   (1, 'Plinicha'),
                                   (2,'Cobalt'),
                                   (3, 'Plinicha'),
                                   (4, 'Zéphyr'),
                                   (5,'Plinicha'),
                                   (6, 'Baldr');
