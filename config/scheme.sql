-- ScriptConnect4_AyD.sql



CREATE TABLE users(
 id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
 nickId VARCHAR(25) UNIQUE,
 nameUs VARCHAR(30),
 lastNameUs VARCHAR(20),
 email VARCHAR(30) UNIQUE,
 password VARCHAR(16),
 DNI VARCHAR(15),
 age INT);

-- *********************************************************************************************
-- *********************************************************************************************


CREATE TABLE removeds(
 id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
 day VARCHAR(20),
 nick VARCHAR(10) UNIQUE,
 name VARCHAR(20),
 lastName VARCHAR(20),
 mail VARCHAR(30) UNIQUE,
 dni VARCHAR(15),
 years INT,
 user_id INT);
-- *********************************************************************************************
-- *********************************************************************************************

CREATE TABLE games(
 numberGame INT(11) NOT NULL AUTO_INCREMENT,
 dateBegin DATE,
 dateEnd DATE,
 grid_id INT,
 user_id INT, -- Jugador 1
 -- user2_id INT, -- Jugador 2
 -- esta es mi duda como le pasas el id de los dos jugadores si vos tenes solo un id para poner
CONSTRAINT games_pk PRIMARY KEY (numberGame));

-- *********************************************************************************************
-- *********************************************************************************************

CREATE TABLE grids(
 id INT(11) NOT NULL AUTO_INCREMENT,
 X INT,
 Y INT,
 cell_id INT,
CONSTRAINT grids_pk PRIMARY KEY (id));

-- *********************************************************************************************
-- *********************************************************************************************

CREATE TABLE cells(
 id INT(11) NOT NULL AUTO_INCREMENT,
 X INT,
 Y INT,
CONSTRAINT cells_pk PRIMARY KEY (id));

-- *********************************************************************************************
-- *********************************************************************************************

CREATE TABLE ranks(
 id INT(11) NOT NULL AUTO_INCREMENT,
 PG INT,
 PE INT,
 PP INT,
 points INT,
 nroRank INT,
 user_id INT,
CONSTRAINT ranks_pk PRIMARY KEY (id));

-- *********************************************************************************************
-- *********************************************************************************************

CREATE TABLE hits(
 id INT(11) NOT NULL AUTO_INCREMENT,
 nameHit VARCHAR(30),
 user_id INT,
CONSTRAINT hits_pk PRIMARY KEY (id));

-- *********************************************************************************************
-- *********************************************************************************************