create table movies(
    id bigint,
    title varchar(255),
    description varchar(1000),
    image_id bigint,
    rental_price numeric(10, 2),
    sale_price numeric(10, 2),
    availability bigint,
    likes bigint,
    created_at timestamp,
    updated_at timestamp
);

create table movies_audit(
    id bigint,
    old_title varchar(255),
    old_rental_price numeric(10, 2),
    old_sale_price numeric(10, 2),
    new_title varchar(255),
    new_rental_price numeric(10, 2),
    new_sale_price numeric(10, 2),
    updated_at timestamp
);

create table movies_rentals(
    id bigint,
    movie_id bigint,
    user_id bigint,
    rented_at timestamp,
    must_return_at timestamp,
    created_at timestamp
);

create table movies_purchases(
    id bigint,
    movie_id bigint,
    user_id bigint,
    purchased_at timestamp,
    created_at timestamp
);

create table users(
    id bigint,
    username varchar(255),
    password varchar(255),
    enabled boolean,
    created_at timestamp,
    updated_at timestamp
);

create table users_movies_likes(
    id bigint,
    movie_id bigint,
    created_at timestamp
);

create table images(
    id bigint,
    url varchar(255),
    created_at timestamp,
    updated_at timestamp
);
