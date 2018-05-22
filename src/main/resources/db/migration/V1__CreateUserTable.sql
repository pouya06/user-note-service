CREATE TABLE user(
  id BIGSERIAL PRIMARY KEY,
  note_id BIGSERIAL NOT NULL,
  email VARCHAR(40) UNIQUE,
  password VARCHAR(40),
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);

CREATE SEQUENCE user_sequence
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

INSERT INTO user (id, note_id, email, password) VALUES (user_sequence.nextval, 1, "abc@abc.com", "password1");