create table movies(
    id bigint,
    title varchar(255) not null,
    description varchar(1000) not null,
    image_id bigint not null,
    rental_price numeric(10, 2) not null,
    sale_price numeric(10, 2) not null,
    availability bigint not null,
    likes bigint not null,
    removed boolean not null,
    created_at timestamp not null,
    updated_at timestamp not null,
    primary key (id)
);

create table movies_audit(
    id bigint,
    old_title varchar(255),
    old_rental_price numeric(10, 2),
    old_sale_price numeric(10, 2),
    new_title varchar(255),
    new_rental_price numeric(10, 2),
    new_sale_price numeric(10, 2),
    updated_at timestamp,
    primary key (id)
);

create table movies_rentals(
    id bigint,
    movie_id bigint,
    user_id bigint,
    rented_at timestamp,
    must_return_at timestamp,
    created_at timestamp,
    primary key (id)
);

create table movies_purchases(
    id bigint,
    movie_id bigint,
    user_id bigint,
    purchased_at timestamp,
    created_at timestamp,
    primary key (id)
);

create table users(
    id bigint,
    username varchar(255),
    password varchar(255),
    enabled boolean,
    created_at timestamp,
    updated_at timestamp,
    primary key (id)
);

create table users_movies_likes(
    id bigint,
    movie_id bigint,
    created_at timestamp,
    primary key (id)
);

create table images(
    id bigint,
    url varchar(255) not null,
    created_at timestamp not null,
    updated_at timestamp not null,
    primary key (id)
);

insert into users values(1, 'user@movie.app', '$2a$10$JuQx2Mh2DAXvAoMwZc4Y6.ni3lA1xPGpqQ2mrukiV1bnIb8b7hS4y', true, current_timestamp, current_timestamp);

insert into images values (1, 'test1.jpg', current_timestamp, current_timestamp);
insert into images values (2, 'test2.jpg', current_timestamp, current_timestamp);

insert into movies values(1, 'Avatar', 'A movie about aliens and nature.', 1, 3.99, 29.50, 50, 12, false, current_timestamp, current_timestamp);
insert into movies values(2, 'Titanic', 'A movie about an ocean liner that sunk.', 2, 3.50, 28.95, 40, 9, false, current_timestamp, current_timestamp);
