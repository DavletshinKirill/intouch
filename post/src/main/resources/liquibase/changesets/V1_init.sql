create table if not exists users
(
    id       uuid primary key,
    name     varchar(255) not null,
    username varchar(255) not null unique,
    password varchar(255) not null
);

create table if not exists users_roles
(
    user_id uuid       not null,
    role    varchar(255) not null,
    primary key (user_id, role),
    constraint fk_users_roles_users foreign key (user_id) references users (id) on delete cascade on update no action
);
