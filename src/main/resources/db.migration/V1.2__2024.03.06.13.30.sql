INSERT INTO role_t VALUES
                       (1, 'ROLE_ADMIN'),
                       (2, 'ROLE_USER'),
                       (3, 'ROLE_OPERATOR');

INSERT INTO user_t VALUES
                       (1, 'admin', 'admin'),
                       (2, 'oper', 'oper'),
                       (3, 'user', 'user'),
                       (4, 'loser', 'loser');

INSERT INTO user_role_t VALUES
                            (1, 1, 1),
                            (2, 1, 3),
                            (3, 2, 3),
                            (4, 2, 2),
                            (5, 4, 2);