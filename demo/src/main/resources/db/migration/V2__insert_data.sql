-- ======================
-- Insert categories
-- ======================
INSERT INTO t_category (t_name) VALUES
                                    ('Фитнес'),
                                    ('Йога'),
                                    ('Пилатес');

-- ======================
-- Insert users
-- ======================
INSERT INTO t_user (t_name, t_email) VALUES
                                         ('Алина Кузнецова', 'alina@example.com'),
                                         ('Бекзат Ахметов', 'bekzat@example.com'),
                                         ('Сауле Нурбекова', 'saule@example.com');

-- ======================
-- Insert programs
-- ======================
INSERT INTO t_program (t_name, t_description, category_id)
SELECT 'Утренний фитнес', 'Базовая программа для утренней зарядки', category_id FROM t_category WHERE t_name='Фитнес'
UNION ALL
SELECT 'Йога для релаксации', 'Спокойная йога на каждый день', category_id FROM t_category WHERE t_name='Йога'
UNION ALL
SELECT 'Пилатес для спины', 'Укрепление спины и корпуса', category_id FROM t_category WHERE t_name='Пилатес';

-- ======================
-- Insert relationships (program_user) dynamically
-- ======================
-- Утренний фитнес → Алина, Бекзат
INSERT INTO program_user (program_id, user_id)
SELECT p.t_id, u.user_id
FROM t_program p
         JOIN t_user u ON u.t_name IN ('Алина Кузнецова','Бекзат Ахметов')
WHERE p.t_name='Утренний фитнес';

-- Йога для релаксации → Бекзат, Сауле
INSERT INTO program_user (program_id, user_id)
SELECT p.t_id, u.user_id
FROM t_program p
         JOIN t_user u ON u.t_name IN ('Бекзат Ахметов','Сауле Нурбекова')
WHERE p.t_name='Йога для релаксации';

-- Пилатес для спины → Алина, Сауле
INSERT INTO program_user (program_id, user_id)
SELECT p.t_id, u.user_id
FROM t_program p
         JOIN t_user u ON u.t_name IN ('Алина Кузнецова','Сауле Нурбекова')
WHERE p.t_name='Пилатес для спины';
