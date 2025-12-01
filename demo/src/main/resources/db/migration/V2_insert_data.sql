-- ----------------------------
-- Вставка категорий
-- ----------------------------
INSERT INTO t_category (t_name) VALUES
                                    ('Fitness'),
                                    ('Yoga'),
                                    ('Pilates');

-- ----------------------------
-- Вставка пользователей
-- ----------------------------
INSERT INTO t_user (t_name, t_email) VALUES
                                         ('Kymbat', 'kymbat@gmail.com'),
                                         ('Symbat', 'symbat@gmail.com'),
                                         ('Arina', 'arina@gmail.com');

-- ----------------------------
-- Вставка залов (gyms)
-- ----------------------------

INSERT INTO t_program (t_name, t_description, category_id) VALUES
                                                               ('Morning Fitness', 'Basic morning fitness program', 1),
                                                               ('Yoga Flow', 'Relaxing yoga flow', 2),
                                                               ('Pilates Core', 'Pilates for core strength', 3);

-- ----------------------------
-- Связующая таблица program_gym
-- ----------------------------
-- Program 1 → Gym 1, 2
INSERT INTO program_gym (program_id, gym_id) VALUES
                                                 (1, 1),
                                                 (1, 2);

-- Program 2 → Gym 2, 3
INSERT INTO program_gym (program_id, gym_id) VALUES
                                                 (2, 2),
                                                 (2, 3);

-- Program 3 → Gym 1, 3
INSERT INTO program_gym (program_id, gym_id) VALUES
                                                 (3, 1),
                                                 (3, 3);
