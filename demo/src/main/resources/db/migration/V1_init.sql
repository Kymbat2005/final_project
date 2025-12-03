
CREATE TABLE t_category (
                            category_id BIGSERIAL PRIMARY KEY,
                            t_name VARCHAR(255) NOT NULL
);


CREATE TABLE t_user (
                        user_id BIGSERIAL PRIMARY KEY,
                        t_name VARCHAR(255) NOT NULL,
                        t_email VARCHAR(255) NOT NULL UNIQUE
);


CREATE TABLE t_program (
                           t_id BIGSERIAL PRIMARY KEY,
                           t_name VARCHAR(255) NOT NULL,
                           t_description TEXT,
                           category_id BIGINT,
                           CONSTRAINT fk_program_category
                               FOREIGN KEY (category_id)
                                   REFERENCES t_category(category_id)
                                   ON DELETE SET NULL
);

CREATE TABLE program_user (
                              program_id BIGINT NOT NULL,
                              user_id BIGINT NOT NULL,
                              PRIMARY KEY (program_id, user_id),
                              CONSTRAINT fk_program_user_program
                                  FOREIGN KEY (program_id)
                                      REFERENCES t_program(t_id)
                                      ON DELETE CASCADE,
                              CONSTRAINT fk_program_user_user
                                  FOREIGN KEY (user_id)
                                      REFERENCES t_user(user_id)
                                      ON DELETE CASCADE
);