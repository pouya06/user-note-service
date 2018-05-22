CREATE TABLE note(
  id BIGSERIAL PRIMARY KEY,
  user_id BIGSERIAL NOT NULL,
  title VARCHAR(50),
  note VARCHAR(1000),
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);