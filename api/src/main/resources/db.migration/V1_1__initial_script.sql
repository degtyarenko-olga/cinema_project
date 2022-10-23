create table if not exists users
(
    id                serial
        constraint users_pk
            primary key,
    login             varchar(20)  default 'name'::character varying not null,
    is_deleted        boolean      default false                     not null,
    creation_date     timestamp(6) default CURRENT_TIMESTAMP(6)      not null,
    modification_date timestamp(6) default CURRENT_TIMESTAMP(6)      not null,
    password          varchar(100)                                    not null,
    birth             timestamp(6)                                   not null,
    email             varchar(255)                                   not null
);

alter table users
    owner to postgres;

create unique index if not exists users_id_uindex
    on users (id);

create index if not exists users_user_name_index
    on users (login);

create index if not exists users_is_deleted_index
    on users (is_deleted);

create unique index if not exists users_password_uindex
    on users (password);

create unique index if not exists users_email_uindex
    on users (email);

create table if not exists roles
(
    id                bigserial
        constraint roles_pk
            primary key,
    role_name         varchar(15) default 'USER'::character varying not null,
    creation_date     timestamp(6),
    modification_date timestamp(6)
);

alter table roles
    owner to postgres;

create unique index if not exists roles_id_uindex
    on roles (id);

create table if not exists hall
(
    id        serial
        constraint hall_pk
            primary key,
    name_hall varchar(100) not null
);

alter table hall
    owner to postgres;

create unique index if not exists hall_id_uindex
    on hall (id);

create table if not exists movie
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

alter table movie
    owner to postgres;

create unique index if not exists movie_id_uindex
    on movie (id);

create table if not exists session
(
    id             serial
        constraint session_pk
            primary key,
    session_start  timestamp(6) not null,
    end_of_session timestamp(6) not null
);

alter table session
    owner to postgres;

create unique index if not exists session_id_uindex
    on session (id);

create table if not exists place
(
    id           serial
        constraint place_pk
            primary key,
    place        integer                       not null,
    row          integer                       not null,
    is_available boolean          default true not null,
    price        double precision default 0    not null
);

alter table place
    owner to postgres;

create unique index if not exists place_id_uindex
    on place (id);

create table if not exists ticket
(
    id               bigserial
        constraint ticket_pk
            primary key,
    movie_id         bigserial
        constraint ticket_movie_id_fk
            references movie
            on update cascade,
    session_id       bigserial
        constraint ticket_session_id_fk
            references session
            on update cascade,
    date_of_purchase timestamp not null,
    place_id         bigserial
        constraint ticket_place_id_fk
            references place
            on update cascade
);

alter table ticket
    owner to postgres;

create unique index if not exists ticket_id_uindex
    on ticket (id);

create table if not exists l_role_user
(
    id      bigserial
        constraint l_role_user_pk
            primary key,
    user_id bigint not null
        constraint l_role_user_users_id_fk
            references users
            on update cascade on delete cascade,
    role_id bigint not null
        constraint l_role_user_roles_id_fk
            references roles

);

alter table l_role_user
    owner to postgres;

create unique index if not exists l_role_user_id_uindex
    on l_role_user (id);

create index if not exists l_role_user_user_id_role_id_index
    on l_role_user (user_id, role_id);

create table if not exists l_place_hall
(
    id       bigserial
        constraint l_place_hall_pk
            primary key,
    hall_id  bigint not null
        constraint l_place_hall_hall_id_fk
            references hall
            on update cascade on delete cascade,
    place_id bigint not null
        constraint l_place_hall_place_id_fk
            references place
            on update cascade on delete cascade
);

alter table l_place_hall
    owner to postgres;

create unique index if not exists l_place_hall_id_uindex
    on l_place_hall (id);