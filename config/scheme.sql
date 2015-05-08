DROP TABLE IF EXISTS users;

CREATE TABLE users(
    id INT(11) NOT NULL AUTO_INCREMENT,
    email VARCHAR(60) UNIQUE,
    first_name VARCHAR(56),
    last_name VARCHAR(56),
  CONSTRAINT users_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS ranks;

CREATE TABLE ranks(
    id INT(11) NOT NULL AUTO_INCREMENT,
    points INT(10),
    user_id INT,
  CONSTRAINT rank_pk PRIMARY KEY (id)
);
