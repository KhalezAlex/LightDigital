CREATE TABLE user_t (
    id SERIAL PRIMARY KEY,
    username varchar(20) NOT NULL UNIQUE,
    password varchar(256) NOT NULL
);

CREATE TABLE role_t (
    id SERIAL PRIMARY KEY,
    role varchar(20) NOT NULL UNIQUE
);

CREATE TABLE authority_t (
    id SERIAL PRIMARY KEY,
    authority varchar(20) NOT NULL UNIQUE
);

CREATE TABLE request_t (
    id SERIAL PRIMARY KEY,
    name varchar(30) NOT NULL,
    phone varchar(12) NOT NULL UNIQUE,
    status varchar(20) NOT NULL,
    request varchar(1024) NOT NULL,
    comment varchar(256)
);