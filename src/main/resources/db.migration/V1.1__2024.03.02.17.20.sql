CREATE TABLE user_role_table (
    id SERIAL PRIMARY KEY,
    user_id int REFERENCES user_t(id),
    role_id int REFERENCES role_t(id)
);

ALTER TABLE authority_t
    ADD COLUMN role_id int REFERENCES role_t(id);

ALTER TABLE request_t
    ADD COLUMN user_id int REFERENCES user_t(id);