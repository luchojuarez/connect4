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
 -- para pasar la fecha con el created_at tiene que ser: (created_at TIMESTAMP,)
 nick VARCHAR(10) UNIQUE,
 name VARCHAR(20),
 lastName VARCHAR(20),
 mail VARCHAR(30) UNIQUE,
 dni VARCHAR(15),
 years INT);
-- *********************************************************************************************
-- *********************************************************************************************

CREATE TABLE games(
 id INT(11) NOT NULL AUTO_INCREMENT,
 dateBegin VARCHAR(30),
 dateEnd VARCHAR(30),
 grid_id INT,
 
--  user_id INT,
 player1_id INT,
 player2_id INT,
 win_id INT,
CONSTRAINT games_pk PRIMARY KEY (id));

-- *********************************************************************************************
-- *********************************************************************************************

CREATE TABLE grids(
 id INT(11) NOT NULL AUTO_INCREMENT,
 X INT,
 Y INT,
CONSTRAINT grids_pk PRIMARY KEY (id));

-- *********************************************************************************************
-- *********************************************************************************************

CREATE TABLE cells(
 id INT(11) NOT NULL AUTO_INCREMENT,
 X INT,
 Y INT,
 state INT,-- ocupadoPorPlayer1 = 1/ocupadoPorPlayer2 = 2 / libre = 0
 grid_id INT,
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