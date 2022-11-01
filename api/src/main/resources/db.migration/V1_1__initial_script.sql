create table cinema.users
(
    id                serial
        constraint users_pk
            primary key,
    login             varchar(20)  default 'name'::character varying not null,
    creation_date     timestamp(6) default CURRENT_TIMESTAMP(6)      not null,
    modification_date timestamp(6) default CURRENT_TIMESTAMP(6)      not null,
    password          varchar(100)                                   not null,
    birth             timestamp(6)                                   not null,
    email             varchar(255)                                   not null
);

alter table cinema.users
    owner to postgres;

create unique index users_id_uindex
    on cinema.users (id);

create index users_user_name_index
    on cinema.users (login);

create unique index users_password_uindex
    on cinema.users (password);

create unique index users_email_uindex
    on cinema.users (email);

create index users_birth_index
    on cinema.users (birth);

create table cinema.roles
(
    id        bigserial
        constraint roles_pk
            primary key,
    role_name varchar(15) default 'USER'::character varying not null
);

alter table cinema.roles
    owner to postgres;

create unique index roles_id_uindex
    on cinema.roles (id);

create index roles_role_name_index
    on cinema.roles (role_name);

create table cinema.hall
(
    id        serial
        constraint hall_pk
            primary key,
    name_hall varchar(100) not null
);

alter table cinema.hall
    owner to postgres;

create unique index hall_id_uindex
    on cinema.hall (id);

create table cinema.movie
(
    id               serial
        constraint movie_pk
            primary key,
    title            varchar(50)          not null,
    description      varchar(255)         not null,
    genre            varchar(25)          not null,
    is_available     boolean default true not null,
    age_restrictions integer              not null
);

alter table cinema.movie
    owner to postgres;

create unique index movie_id_uindex
    on cinema.movie (id);

create unique index movie_title_uindex
    on cinema.movie (title);

create table cinema.session
(
    id             serial
        constraint session_pk
            primary key,
    session_start  timestamp(6) not null,
    end_of_session timestamp(6) not null
);

alter table cinema.session
    owner to postgres;

create unique index session_id_uindex
    on cinema.session (id);

create table cinema.place
(
    id           serial
        constraint place_pk
            primary key,
    place        integer                       not null,
    row          integer                       not null,
    is_available boolean          default true not null,
    price        double precision default 0    not null
);

alter table cinema.place
    owner to postgres;

create unique index place_id_uindex
    on cinema.place (id);

create table cinema.ticket
(
    id               bigserial
        constraint ticket_pk
            primary key,
    movie_id         bigint    not null
        constraint ticket_movie_id_fk
            references cinema.movie
            on update cascade,
    session_id       bigint    not null
        constraint ticket_session_id_fk
            references cinema.session
            on update cascade,
    date_of_purchase timestamp not null,
    place_id         bigint    not null
        constraint ticket_place_id_fk
            references cinema.place
            on update cascade,
    user_id          bigint    not null
        constraint ticket_users_id_fk
            references cinema.users
            on update cascade on delete cascade
);

alter table cinema.ticket
    owner to postgres;

create unique index ticket_id_uindex
    on cinema.ticket (id);

create index ticket_movie_id_index
    on cinema.ticket (movie_id);

create index ticket_session_id_index
    on cinema.ticket (session_id);

create unique index ticket_place_id_uindex
    on cinema.ticket (place_id);

create index ticket_date_of_purchase_index
    on cinema.ticket (date_of_purchase);

create index ticket_user_id_index
    on cinema.ticket (user_id);

create table cinema.l_role_user
(
    id      bigserial
        constraint l_role_user_pk
            primary key,
    user_id bigint not null
        constraint l_role_user_users_id_fk
            references cinema.users
            on update cascade on delete cascade,
    role_id bigint not null
        constraint l_role_user_roles_id_fk
            references cinema.roles
);

alter table cinema.l_role_user
    owner to postgres;

create unique index l_role_user_id_uindex
    on cinema.l_role_user (id);

create index l_role_user_user_id_role_id_index
    on cinema.l_role_user (user_id, role_id);

create table cinema.l_place_hall
(
    id       bigserial
        constraint l_place_hall_pk
            primary key,
    hall_id  bigint not null
        constraint l_place_hall_hall_id_fk
            references cinema.hall
            on update cascade on delete cascade,
    place_id bigint not null
        constraint l_place_hall_place_id_fk
            references cinema.place
            on update cascade on delete cascade
);

alter table cinema.l_place_hall
    owner to postgres;

create unique index l_place_hall_id_uindex
    on cinema.l_place_hall (id);

