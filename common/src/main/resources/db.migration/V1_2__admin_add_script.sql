INSERT INTO cinema.users
    (id, login, is_deleted, creation_date, modification_date, password, birth, email)
VALUES (DEFAULT, 'Admin', false, '2022-09-19 22:32:17.000000', '2022-09-19 22:32:18.000000', 'ADMIN', '2022-09-19 22:32:23.000000', 'Admin1@gmail.com')
ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_role_user (id, user_id, role_id) VALUES (DEFAULT, 1::bigint, 1::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_role_user (id, user_id, role_id) VALUES (DEFAULT, 1::bigint, 2::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_role_user (id, user_id, role_id) VALUES (DEFAULT, 1::bigint, 3::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_role_user (id, user_id, role_id) VALUES (DEFAULT, 1::bigint, 4::bigint) ON CONFLICT DO NOTHING;