
CREATE TABLE t_category (
                            category_id BIGSERIAL PRIMARY KEY,
                            t_name VARCHAR(255)
);


CREATE TABLE t_user (
                        user_id BIGSERIAL PRIMARY KEY,
                        t_name VARCHAR(255),
                        t_email VARCHAR(255)
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


CREATE TABLE IF NOT EXISTS program_gym (
                                           program_id BIGINT NOT NULL,
                                           gym_id BIGINT NOT NULL,
                                           CONSTRAINT fk_pg_program
                                           FOREIGN KEY (program_id)
    REFERENCES t_program(t_id)
    ON DELETE CASCADE,
    CONSTRAINT fk_pg_gym
    FOREIGN KEY (gym_id)
    REFERENCES t_gym(gym_id)
    ON DELETE CASCADE,
    PRIMARY KEY (program_id, gym_id)
    );
