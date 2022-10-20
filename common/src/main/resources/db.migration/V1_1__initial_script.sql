create table if not exists cinema.users
(
    id                serial
        constraint users_pk
            primary key,
    login             varchar(20)  default 'name'::character varying not null,
    is_deleted        boolean      default false                     not null,
    creation_date     timestamp(6) default CURRENT_TIMESTAMP(6)      not null,
    modification_date timestamp(6) default CURRENT_TIMESTAMP(6)      not null,
    password          varchar(10)                                    not null,
    birth             timestamp(6)                                   not null,
    email             varchar(255)                                   not null
);

alter table cinema.users
    owner to postgres;

create unique index if not exists users_id_uindex
    on cinema.users (id);

create index if not exists users_user_name_index
    on cinema.users (login);

create index if not exists users_is_deleted_index
    on cinema.users (is_deleted);

create unique index if not exists users_password_uindex
    on cinema.users (password);

create unique index if not exists users_email_uindex
    on cinema.users (email);

create table if not exists cinema.roles
(
    id                bigserial
        constraint roles_pk
            primary key,
    role_name         varchar(15) default 'USER'::character varying not null,
    creation_date     timestamp(6),
    modification_date timestamp(6)
);

alter table cinema.roles
    owner to postgres;

create unique index if not exists roles_id_uindex
    on cinema.roles (id);

create table if not exists cinema.hall
(
    id        serial
        constraint hall_pk
            primary key,
    name_hall varchar(100) not null
);

alter table cinema.hall
    owner to postgres;

create unique index if not exists hall_id_uindex
    on cinema.hall (id);

create table if not exists cinema.movie
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

create unique index if not exists movie_id_uindex
    on cinema.movie (id);

create table if not exists cinema.session
(
    id             serial
        constraint session_pk
            primary key,
    session_start  timestamp(6) not null,
    end_of_session timestamp(6) not null
);

alter table cinema.session
    owner to postgres;

create unique index if not exists session_id_uindex
    on cinema.session (id);

create table if not exists cinema.place
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

create unique index if not exists place_id_uindex
    on cinema.place (id);

create table if not exists cinema.ticket
(
    id               bigserial
        constraint ticket_pk
            primary key,
    movie_id         bigserial
        constraint ticket_movie_id_fk
            references cinema.movie
            on update cascade on delete cascade,
    session_id       bigserial
        constraint ticket_session_id_fk
            references cinema.session
            on update cascade on delete cascade,
    date_of_purchase timestamp not null,
    place_id         bigserial
        constraint ticket_place_id_fk
            references cinema.place
            on update cascade on delete cascade
);

alter table cinema.ticket
    owner to postgres;

create unique index if not exists ticket_id_uindex
    on cinema.ticket (id);

create table if not exists cinema.l_role_user
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
            on update cascade on delete cascade
);

alter table cinema.l_role_user
    owner to postgres;

create unique index if not exists l_role_user_id_uindex
    on cinema.l_role_user (id);

create index if not exists l_role_user_user_id_role_id_index
    on cinema.l_role_user (user_id, role_id);

create table if not exists cinema.l_place_hall
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

create unique index if not exists l_place_hall_id_uindex
    on cinema.l_place_hall (id);