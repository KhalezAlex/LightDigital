DROP TABLE IF EXISTS user_t;
DROP TABLE IF EXISTS role_t;
DROP TABLE IF EXISTS claim_t;
DROP TABLE IF EXISTS user_role_t;

CREATE TABLE user_t (
    id SERIAL PRIMARY KEY,
    username varchar(20) NOT NULL UNIQUE,
    password varchar(256) NOT NULL,
    created timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE role_t (
    id SERIAL PRIMARY KEY,
    role varchar(20) NOT NULL UNIQUE
);

CREATE TABLE claim_t (
    id SERIAL PRIMARY KEY,
    caption varchar(30) NOT NULL,
    phone varchar(12) NOT NULL,
    status varchar(20) NOT NULL,
    claim varchar(1024) NOT NULL,
    created timestamp DEFAULT CURRENT_TIMESTAMP,
    updated timestamp DEFAULT CURRENT_TIMESTAMP,
    comment varchar(256)
);