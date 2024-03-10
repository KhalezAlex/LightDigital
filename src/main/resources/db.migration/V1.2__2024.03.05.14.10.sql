DROP TABLE IF EXISTS authority_t;

ALTER TABLE user_t
        ADD COLUMN created timestamp DEFAULT CURRENT_TIMESTAMP;

