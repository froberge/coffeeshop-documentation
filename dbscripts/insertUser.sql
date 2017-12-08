INSERT INTO USERS (ID,NAME, GENDER, BIRTHDATE, EMAILADR, PASSWORD, CREATE_DATE) VALUES
  (nextval('users_seq'), 'test', 'F', to_date('2000-09-01', 'YYYY-MM-DD'), 'test@example.com', 'test', current_timestamp ),
  (2, 'users_seq', 'F', to_date('1996-01-29', 'YYYY-MM-DD'), 'charlotte@example.com', 'secret', current_timestamp),
  (3, 'users_SEQ', 'M', to_date('1990-07-29', 'YYYY-MM-DD'), 'olivier@example.com', 'secret',current_timestamp);
