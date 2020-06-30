INSERT INTO CLIENT(name, email, password) VALUES('Maria', 'maria@email.com', '123456');
INSERT INTO CLIENT(name, email, password) VALUES('Jose', 'jose@email.com', '654321');
INSERT INTO CLIENT(name, email, password) VALUES('Sara', 'sara@email.com', '987987');

INSERT INTO BOOK(title, status, client_id) VALUES('Java 8', 'EMPRESTADO', 1);
INSERT INTO BOOK(title, status, client_id) VALUES('String Boot', 'DISPONIVEL', 1);
INSERT INTO BOOK(title, status, client_id) VALUES('Maven', 'DISPONIVEL', 1);
INSERT INTO BOOK(title, status, client_id) VALUES('JPA', 'DISPONIVEL', 2);
INSERT INTO BOOK(title, status, client_id) VALUES('TDD', 'EMPRESTADO', 3);