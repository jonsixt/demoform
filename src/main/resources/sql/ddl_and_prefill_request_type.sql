-- example of application database and its owner/application user creation
CREATE USER request_app WITH ENCRYPTED PASSWORD 'test123';
CREATE DATABASE request_db
   WITH
   OWNER request_app
   ENCODING 'UTF8'
   TABLESPACE  pg_default
   CONNECTION LIMIT  -1;


-- DDL for tables used in the demo, expected to be created in the application database (above or any other used)
CREATE TABLE r_request_type
(
    request_type  VARCHAR(100) NOT NULL,
    CONSTRAINT pk_r_request_type
        PRIMARY KEY (request_type)
);
/
CREATE TABLE r_saved_request
(
    id                  NUMERIC(8) NOT NULL,
    created             TIMESTAMP(2) DEFAULT CURRENT_TIMESTAMP,
    request_type        VARCHAR(100) NOT NULL,
    policy_number       VARCHAR(100),
    name                VARCHAR(30),
    surname             VARCHAR(60),
    request             TEXT,
    CONSTRAINT pk_r_saved_request
        PRIMARY KEY (id),
    CONSTRAINT fk_r_saved_request_type
        FOREIGN KEY (request_type) REFERENCES r_request_type (request_type)
);
/
-- prefill r_request_type with some values so the application is ready to use
INSERT INTO r_request_type (request_type) VALUES ('Complaint');
INSERT INTO r_request_type (request_type) VALUES ('Damaged Case');
INSERT INTO r_request_type (request_type) VALUES ('Contract Adjustment');