DROP SEQUENCE IF EXISTS cs_user.user_seq;
DROP TABLE IF EXISTS cs_user."user";
DROP SCHEMA IF EXISTS cs_user;

CREATE SCHEMA cs_user;

CREATE SEQUENCE cs_user.user_seq
  START WITH     1
  INCREMENT BY   1;
 
CREATE TABLE cs_user."user"(
  ID   INT                NOT NULL,
  NAME VARCHAR(100)       NOT NULL,
  GENDER VARCHAR(6)       NOT NULL,
  BIRTHDATE  DATE,
  EMAIL  VARCHAR(100)  NOT NULL,
  PASSWORD  VARCHAR(20)   NOT NULL,
  CREATE_DATE DATE,
  PRIMARY KEY (ID)
);

INSERT INTO cs_user."user" (ID, NAME, GENDER, BIRTHDATE, EMAIL, PASSWORD, CREATE_DATE) VALUES
  (nextval('cs_user.user_seq'), 'System Admin','Male', current_timestamp, 'admin@coffeeshop.com', 'pwd001',current_timestamp );
INSERT INTO cs_user."user" (ID, NAME, GENDER, BIRTHDATE, EMAIL, PASSWORD, CREATE_DATE) VALUES
  (nextval('cs_user.user_seq'), 'Default user','Male', current_timestamp, 'default@coffeeshop.com', 'default123',current_timestamp );

SET default_tablespace = '';
SET client_encoding = 'UTF8';
