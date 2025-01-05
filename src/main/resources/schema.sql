CREATE SCHEMA IF NOT EXISTS square_games_db;

CREATE TABLE IF NOT EXISTS players(
                                      id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                      name VARCHAR (100) NOT NULL
    );
