DROP TABLE IF EXISTS billionaires;

CREATE TABLE person (
  id LONG AUTO_INCREMENT  PRIMARY KEY,
  firstName VARCHAR(250) NOT NULL,
  lastName VARCHAR(250) NOT NULL,
  pesel VARCHAR(250) NOT NULL,
  retard BOOLEAN NOT NULL
);

CREATE TABLE retard (
  id LONG AUTO_INCREMENT  PRIMARY KEY,
  pesel VARCHAR(250) NOT NULL,
);