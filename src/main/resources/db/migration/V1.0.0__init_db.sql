create table category
(
    id        bigserial primary key,
    name      text not null,
    alias     text not null,
    parent_id int,

    foreign key (parent_id) references category (id)
);

create index category_parent_id_idx on category (parent_id);

create table product
(
    id          bigserial primary key,
    title       text   not null,
    price       float  not null,
    image_link  text,
    category_id bigint not null,
    foreign key (category_id) references category (id)
);
create index product_category_id_idx on product (category_id);
