
INSERT INTO t_category (t_name) VALUES
                                    ('Фитнес'),
                                    ('Йога'),
                                    ('Пилатес');


INSERT INTO t_user (t_name, t_email) VALUES
                                         ('Алина ', 'alina@example.com'),
                                         ('Бекзат А', 'bekzat@example.com'),
                                         ('Сауле ', 'saule@example.com');

INSERT INTO t_program (t_name, t_description, category_id)
SELECT ' фитнес', 'Базовая пзарядки', category_id FROM t_category WHERE t_name='Фитнес'
UNION ALL
SELECT 'Йога д', 'Спокойнй ', category_id FROM t_category WHERE t_name='Йога'
UNION ALL
SELECT 'Пилатес ', 'Укрепление ', category_id FROM t_category WHERE t_name='Пилатес';


INSERT INTO program_user (program_id, user_id)
SELECT p.t_id, u.user_id
FROM t_program p
         JOIN t_user u ON u.t_name IN ('Алина ','Бекзат ')
WHERE p.t_name='Утренний фитнес';


INSERT INTO program_user (program_id, user_id)
SELECT p.t_id, u.user_id
FROM t_program p
         JOIN t_user u ON u.t_name IN ('Бекзат ','Сауле')
WHERE p.t_name='Йога для релаксации';


INSERT INTO program_user (program_id, user_id)
SELECT p.t_id, u.user_id
FROM t_program p
         JOIN t_user u ON u.t_name IN ('Алина ','Сауле Нурбекова')
WHERE p.t_name='Пилатес для спины';