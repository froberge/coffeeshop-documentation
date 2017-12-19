INSERT INTO USERS (ID, FIRST_NAME, LAST_NAME, GENDER, BIRTHDATE, EMAILADR, PASSWORD, CREATE_DATE) VALUES
  (nextval('users_seq'), 'Admin', 'Admin', 'M', current_timestamp, 'admin@coffeshop.com', 'pwd001',current_timestamp ),
  (nextval('users_seq'), 'Charlotte', 'Roberge', 'F', to_date('1996-01-29', 'YYYY-MM-DD'), 'charlotte@coffeshop.com', 'secret', 'B', current_timestamp),
  (nextval('users_seq'), 'Olivier', 'Roberge', 'M', to_date('1990-07-29', 'YYYY-MM-DD'), 'olivier@coffeeshop.com', 'secret', 'B', current_timestamp);
