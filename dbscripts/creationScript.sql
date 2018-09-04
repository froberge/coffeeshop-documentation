DROP TABLE IF EXISTS USERS;
DROP SEQUENCE IF EXISTS users_seq;

BEGIN;

CREATE SEQUENCE users_seq
 START WITH     1
 INCREMENT BY   1;

 CREATE TABLE USERS(
    ID   INT               NOT NULL,
    NAME VARCHAR(100) NOT NULL,
    GENDER VARCHAR(6)      NOT NULL,
    BIRTHDATE  DATE,
    EMAILADR  VARCHAR(100)  NOT NULL,
    PASSWORD  VARCHAR(20)  NOT NULL,
    CREATE_DATE DATE,
    PRIMARY KEY (ID)
 );

INSERT INTO USERS (ID, NAME, GENDER, BIRTHDATE, EMAILADR, PASSWORD, CREATE_DATE) VALUES
  (nextval('users_seq'), 'System Admin','Male', current_timestamp, 'admin@coffeshop.com', 'pwd001',current_timestamp );

INSERT INTO USERS (ID, NAME, GENDER, BIRTHDATE, EMAILADR, PASSWORD, CREATE_DATE) VALUES
  (nextval('users_seq'), 'Default user','Male', current_timestamp, 'default@example.com', 'default123',current_timestamp );


COMMIT;
