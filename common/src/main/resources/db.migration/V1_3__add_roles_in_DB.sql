INSERT INTO cinema.roles (id, role_name, creation_date, modification_date)
VALUES (DEFAULT, 'ROLE_ADMIN', null, null) ON CONFLICT DO NOTHING;
INSERT INTO cinema.roles (id, role_name, creation_date, modification_date)
       VALUES (DEFAULT, 'ROLE_USER', null, null)
       ON CONFLICT DO NOTHING;
INSERT INTO cinema.roles (id, role_name, creation_date, modification_date)
VALUES (DEFAULT, 'ROLE_MODERATOR', null, null) ON CONFLICT DO NOTHING;
INSERT INTO cinema.roles (id, role_name, creation_date, modification_date)
VALUES (DEFAULT, 'ROLE_ANONYMOUS', null, null) ON CONFLICT DO NOTHING;

INSERT INTO cinema.l_role_user (id, user_id, role_id) VALUES (DEFAULT, 1::bigint, 1::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_role_user (id, user_id, role_id) VALUES (DEFAULT, 1::bigint, 2::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_role_user (id, user_id, role_id) VALUES (DEFAULT, 1::bigint, 3::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_role_user (id, user_id, role_id) VALUES (DEFAULT, 1::bigint, 4::bigint) ON CONFLICT DO NOTHING;
--
