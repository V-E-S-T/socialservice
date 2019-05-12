DROP TABLE IF EXISTS works;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE works
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  price            INTEGER                 NOT NULL,
  description      VARCHAR                 NOT NULL,
  estimate_time     INTEGER                 NOT NULL,
  specialization   VARCHAR                 NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL
);