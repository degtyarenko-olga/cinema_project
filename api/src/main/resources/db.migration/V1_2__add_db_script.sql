INSERT INTO cinema.users (id, login, is_deleted, creation_date, modification_date, password, birth, email)
VALUES (DEFAULT, 'Admin', false, '2022-09-19 22:32:17.000000', '2022-09-19 22:32:18.000000',
        '$2a$12$YVROa3LqxOiPeRmHykaWsusIea4N61277FOFJNpGkibwhbSR23w8W',
        '2022-09-19 22:32:23.000000', 'Admin1@gmail.com') ON CONFLICT DO NOTHING;
--------------------------------------------------------------
INSERT INTO cinema.roles (id, role_name) VALUES (DEFAULT, 'ROLE_ADMIN') ON CONFLICT DO NOTHING;
INSERT INTO cinema.roles (id, role_name) VALUES (DEFAULT, 'ROLE_USER') ON CONFLICT DO NOTHING;
INSERT INTO cinema.roles (id, role_name) VALUES (DEFAULT, 'ROLE_MODERATOR') ON CONFLICT DO NOTHING;
INSERT INTO cinema.roles (id, role_name) VALUES (DEFAULT, 'ROLE_ANONYMOUS') ON CONFLICT DO NOTHING;

INSERT INTO cinema.l_role_user (id, user_id, role_id) VALUES (DEFAULT, 1::bigint, 1::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_role_user (id, user_id, role_id) VALUES (DEFAULT, 1::bigint, 2::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_role_user (id, user_id, role_id) VALUES (DEFAULT, 1::bigint, 3::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_role_user (id, user_id, role_id) VALUES (DEFAULT, 1::bigint, 4::bigint) ON CONFLICT DO NOTHING;
--------------------------------------------------------------
INSERT INTO cinema.hall (id, name_hall) VALUES (DEFAULT, 'RED HALL') ON CONFLICT DO NOTHING;
INSERT INTO cinema.hall (id, name_hall) VALUES (DEFAULT, 'GREEN HALL') ON CONFLICT DO NOTHING;
INSERT INTO cinema.hall (id, name_hall) VALUES (DEFAULT, '3D HALL') ON CONFLICT DO NOTHING;
--------------------------------------------------------------
INSERT INTO cinema.movie (id, title, description, genre, is_available, age_restrictions)
VALUES (DEFAULT, 'Harry Potter and the Half-Blood Prince', 'Harry helps Dumbledore uncover the main secret of Voldemort.' ||
' Part 6 with a heartbreaking ending','fantasy',true ,14) ON CONFLICT DO NOTHING;
INSERT INTO cinema.movie (id, title, description, genre, is_available, age_restrictions)
VALUES (DEFAULT, 'The Crow', 'An infernal rock musician avenges his desecrated love.','horror',true ,16) ON CONFLICT DO NOTHING;
----------------------------------------------------------------
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 1, 1, true, 5) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 2, 1, true, 5) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 3, 1, true, 5) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 4, 1, true, 5) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 5, 1, true, 5) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 6, 1, true, 5) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 7, 1, true, 5) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 8, 1, true, 5) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 9, 1, true, 5) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 10, 1, true, 5) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 1, 2, true, 7) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 2, 2, true, 7) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 3, 2, true, 7) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 4, 2, true, 7) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 5, 2, true, 7) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 6, 2, true, 7) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 7, 2, true, 7) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 8, 2, true, 7) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 9, 2, true, 7) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 10, 2, true, 7) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 1, 3, true, 8) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 2, 3, true, 8) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 3, 3, true, 8) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 4, 3, true, 8) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 5, 3, true, 8) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 6, 3, true, 8) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 7, 3, true, 8) ON CONFLICT DO NOTHING;
INSERT INTO cinema.place (id,place, row, is_available, price) VALUES (DEFAULT, 8, 3, true, 8) ON CONFLICT DO NOTHING;
------------------------------------------------------------------------------
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 1::bigint, 1::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 1::bigint, 2::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 1::bigint, 3::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 1::bigint, 4::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 1::bigint, 5::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 1::bigint, 6::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 1::bigint, 7::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 1::bigint, 8::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 1::bigint, 9::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 1::bigint, 10::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 2::bigint, 11::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 2::bigint, 12::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 2::bigint, 13::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 2::bigint, 14::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 2::bigint, 15::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 2::bigint, 16::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 2::bigint, 17::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 2::bigint, 18::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 2::bigint, 19::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 2::bigint, 20::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 3::bigint, 21::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 3::bigint, 22::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 3::bigint, 23::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 3::bigint, 24::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 3::bigint, 25::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 3::bigint, 26::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 3::bigint, 27::bigint) ON CONFLICT DO NOTHING;
INSERT INTO cinema.l_place_hall (id, hall_id, place_id) VALUES (DEFAULT, 3::bigint, 28::bigint) ON CONFLICT DO NOTHING;
-----------------------------------------------------------------------------
INSERT INTO cinema.session (id, session_start, end_of_session)
VALUES (DEFAULT, '2022-10-27 18:30:39.000000'::timestamp(6), '2022-10-27 20:00:40.000000'::timestamp(6))
ON CONFLICT DO NOTHING;
INSERT INTO cinema.session (id, session_start, end_of_session)
VALUES (DEFAULT, '2022-10-27 14:00:39.000000'::timestamp(6), '2022-10-27 16:00:40.000000'::timestamp(6))
ON CONFLICT DO NOTHING;
INSERT INTO cinema.session (id, session_start, end_of_session)
VALUES (DEFAULT, '2022-10-27 20:00:39.000000'::timestamp(6), '2022-10-27 21:30:40.000000'::timestamp(6))
ON CONFLICT DO NOTHING;
INSERT INTO cinema.session (id, session_start, end_of_session)
VALUES (DEFAULT, '2022-10-28 18:00:39.000000'::timestamp(6), '2022-10-28 20:00:40.000000'::timestamp(6))
ON CONFLICT DO NOTHING;
INSERT INTO cinema.session (id, session_start, end_of_session)
VALUES (DEFAULT, '2022-10-29 16:15:39.000000'::timestamp(6), '2022-10-29 17:50:40.000000'::timestamp(6))
ON CONFLICT DO NOTHING;
