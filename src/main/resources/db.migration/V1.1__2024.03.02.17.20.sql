CREATE TABLE user_role_t (
    id SERIAL PRIMARY KEY,
    user_id int REFERENCES user_t(id),
    role_id int REFERENCES role_t(id)
);

ALTER TABLE claim_t
    ADD COLUMN user_id int REFERENCES user_t(id);