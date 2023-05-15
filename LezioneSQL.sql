/*DDL Data Definition Language*/

/* CREATE DATABASE dbfs0123; /* crea database */ */
/* DROP DATABASE dbfs0123; /*  cancella database */ */

/*CREATE TABLE utente (
    id INT NOT NULL PRIMARY KEY,
    nome VARCHAR NOT NULL,
    cognome VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    citta VARCHAR NOT NULL,
    provincia VARCHAR NOT NULL,
    regione VARCHAR NOT NULL
    CONSTRAINT utente_pk  (id)
    CONSTRAINT email_pk UNIQUE (email)
) */

/*CREATE TABLE utente (
    id SERIAL NOT NULL PRIMARY KEY,
    nome VARCHAR NOT NULL,
    cognome VARCHAR NOT NULL,
    email VARCHAR NOT NULL UNIQUE,
    citta VARCHAR NOT NULL,
    provincia VARCHAR NOT NULL,
    regione VARCHAR NOT NULL
);*/

CREATE TABLE IF NOT EXISTS citta (
	id SERIAL NOT NULL PRIMARY KEY,
	citta VARCHAR NOT NULL,
    provincia VARCHAR NOT NULL,
    regione VARCHAR NOT NULL
);

CREATE TABLE utente (
    id SERIAL NOT NULL PRIMARY KEY,
    nome VARCHAR NOT NULL,
    cognome VARCHAR NOT NULL,
    email VARCHAR NOT NULL UNIQUE,
    citta INTEGER NOT NULL,
	CONSTRAINT citta_FK FOREIGN KEY (citta) REFERENCES citta (id)
);

DROP TABLE utente; /*  cancella tabella */
TRUNCATE utente; /*  svuota dati da tabella */

/*  modifica struttura tabella */
ALTER TABLE  utente ADD cf VARCHAR NULL UNIQUE; /*  aggiungi colonna su tabella */
ALTER TABLE  utente RENAME COLUMN cf TO codicefiscale /*  rinomina colonna su tabella */
ALTER TABLE  utente DROP COLUMN codicefiscale;

/*DML Data Manipulation Language*/

/*INSERT INTO utente (nome, cognome, email, citta, provincia,regione)
	VALUES('Mario', 'Rossi', 'm.rossi@example.com', 'Roma', 'Roma', 'Lazio');
INSERT INTO utente (nome, cognome, email, citta, provincia,regione)
	VALUES('Giuseppe', 'Verdi', 'g.verdi@example.com', 'Milano', 'Milano', 'Lombardia');*/
	 
INSERT INTO citta (citta, provincia, regione) VALUES ('Roma', 'Roma', 'Lazio');
INSERT INTO citta (citta, provincia, regione) VALUES ('Pomezia', 'Roma', 'Lazio');
INSERT INTO citta (citta, provincia, regione) VALUES ('Milano', 'Milano', 'Lombardia');
INSERT INTO citta (citta, provincia, regione) VALUES ('Napoli', 'Napoli', 'Campania');
INSERT INTO citta (citta, provincia, regione) VALUES ('Pompei', 'Napoli', 'Campania');
INSERT INTO citta (citta, provincia, regione) VALUES ('Palermo', 'Palermo', 'Sicilia');

INSERT INTO utente (nome, cognome, email, citta) VALUES('Mario', 'Rossi', 'm.rossi@example.com', 1);
INSERT INTO utente (nome, cognome, email, citta) VALUES('Giuseppe', 'Verdi', 'g.verdi@example.com', 2);
INSERT INTO utente (nome, cognome, email, citta) VALUES('Francesca', 'Neri', 'f.neri@example.com', 3);
INSERT INTO utente (nome, cognome, email, citta) VALUES('Antonio', 'Gialli', 'a.gialli@example.com', 1);
INSERT INTO utente (nome, cognome, email, citta) VALUES('Maria', 'Rossi', 'm.bianchi@example.com', 1);
INSERT INTO utente (nome, cognome, email, citta) VALUES('Filippo', 'Neri', 'f.neri@example.it', 2);
INSERT INTO utente (nome, cognome, email) VALUES('Giovanni', 'Neri', 'g.neri@example.it');

UPDATE utente SET citta = 2 WHERE id = 1;

DELETE FROM utente WHERE id = 1;
	  
/* DQL */
SELECT * FROM utente;
SELECT * FROM citta;

SELECT nome, cognome FROM utente;

SELECT * FROM utente WHERE citta = 1;
SELECT * FROM utente WHERE citta = 1 AND cognome = 'Rossi';
SELECT * FROM utente WHERE email LIKE '%example%';
SELECT nome, cognome FROM utente WHERE nome LIKE '_i%';
SELECT nome, cognome FROM utente WHERE email LIKE '%.__';

SELECT * FROM utente INNER JOIN citta ON utente.citta = citta.id;
SELECT * FROM utente LEFT JOIN citta ON utente.citta = citta.id;
SELECT * FROM utente RIGHT JOIN citta ON utente.citta = citta.id;
SELECT * FROM utente FULL JOIN citta ON utente.citta = citta.id;

SELECT * FROM citta ORDER BY regione ASC;
SELECT DISTINCT provincia FROM citta;

SELECT MAX(id) FROM citta;
SELECT MIN(id) FROM citta;
SELECT AVG(id) FROM citta;
SELECT COUNT(*) FROM citta;

SELECT provincia, count(*) AS numCitta FROM citta GROUP BY provincia;

SELECT * FROM citta WHERE id BETWEEN 2 AND 4;
SELECT * FROM citta WHERE citta BETWEEN 'Ancona' AND 'Otranto';

SELECT * FROM citta WHERE provincia IN ('Napoli', 'Palermo', 'Genova')
SELECT * FROM citta WHERE provincia NOT IN ('Napoli', 'Palermo', 'Genova')

SELECT * FROM utente WHERE citta IS NULL;
SELECT * FROM utente WHERE citta IS NOT NULL;

/* Lazio */ 
SELECT nome AS nomeUtente, cognome AS cognomeUtente, email, c.citta AS nomeCitta, provincia, regione 
	FROM utente AS u INNER JOIN citta AS c ON u.citta = c.id where c.regione = 'Lazio';

SELECT * FROM utente WHERE citta IN (SELECT id FROM citta WHERE regione = 'Lazio');
SELECT * FROM utente WHERE citta IN (1, 5);

