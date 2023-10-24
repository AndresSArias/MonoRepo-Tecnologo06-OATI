/*
	Script for create the database of Microservice Users with name of elecciones_dbusers
*/

DROP DATABASE IF EXISTS elecciones_dbusers;
CREATE DATABASE IF NOT EXISTS  elecciones_dbusers;

USE elecciones_dbusers;

SET FOREIGN_KEY_CHECKS=0; 
/* Drop Tables */

DROP TABLE IF EXISTS roles CASCADE
;

DROP TABLE IF EXISTS users CASCADE
;

/* Create Tables */

CREATE TABLE roles
(
	id BIGINT NOT NULL AUTO_INCREMENT,
	description VARCHAR(255) NULL,
	name VARCHAR(255) NULL,
	CONSTRAINT PK_Role PRIMARY KEY (id ASC)
)
COMMENT = 'Table containt roles of users in system'

;

CREATE TABLE users
(
	id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Id generic of user',
	number_document VARCHAR(20) NOT NULL COMMENT 'Cedula of user',
	name VARCHAR(255) NOT NULL COMMENT 'name of user',
	id_role BIGINT NOT NULL COMMENT 'id generic and relational with role of user.',
	CONSTRAINT PK_User PRIMARY KEY (id ASC)
)
COMMENT = 'In this table containt the users of system election regional'

;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE users 
 ADD CONSTRAINT UNIQUE_Number_Document UNIQUE (number_document ASC)
;

ALTER TABLE users 
 ADD INDEX IXFK_Users_Roles (id_role ASC)
;

/* Create Foreign Key Constraints */

ALTER TABLE users 
 ADD CONSTRAINT FK_Users_Roles
	FOREIGN KEY (id_role) REFERENCES roles (id) ON DELETE Restrict ON UPDATE Restrict
;

SET FOREIGN_KEY_CHECKS=1
; 
