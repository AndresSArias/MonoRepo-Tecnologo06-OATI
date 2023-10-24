/*
	Script for the fill the initial register of elecciones_dbusers
*/
USE elecciones_dbusers;

INSERT INTO roles (id, description, name) VALUES ('1', 'ROLE_ADMIN', 'ROLE_ADMIN');
INSERT INTO roles (id, description, name) VALUES ('2', 'ROLE_CANDIDATE', 'ROLE_CANDIDATE');
INSERT INTO roles (id, description, name) VALUES ('3', 'ROLE_CITIZEN', 'ROLE_CITIZEN');

INSERT INTO users (id, number_document, name, id_role)
VALUES (1, '9999999999', 'Registrador OATI', 1);

INSERT INTO users (id, number_document, name, id_role)
VALUES (2, '321', 'Carlos Fernando Galán', 2);
INSERT INTO users (id, number_document, name, id_role)
VALUES (3, '123', 'Gustavo Bolívar', 2);
INSERT INTO users (id, number_document, name, id_role)
VALUES (4, '213', 'Juan Daniel Oviedo', 2);

INSERT INTO users (id, number_document, name, id_role)
VALUES (5, '111', 'Andrés Arias', 3);
INSERT INTO users (id, number_document, name, id_role)
VALUES (6, '666', 'Ana Martínez', 3);
INSERT INTO users (id, number_document, name, id_role)
VALUES (7, '777', 'Carlos Rodríguez', 3);
INSERT INTO users (id, number_document, name, id_role)
VALUES (8, '888', 'Laura González', 3);
INSERT INTO users (id, number_document, name, id_role)
VALUES (9, '999', 'Juan Pérez', 3);
INSERT INTO users (id, number_document, name, id_role)
VALUES (10, '222', 'María López', 3);
