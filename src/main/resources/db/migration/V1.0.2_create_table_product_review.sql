create table product_review(
    id bigserial primary key ,
    product_id bigint not null ,
    user_id bigint,
    rating int,
    comment text,
    created timestamp ,
    updated timestamp ,
    foreign key (product_id) references product(id),
    foreign key (user_id) references users(id)
);
create index product_review_user_id_idx on product_review(user_id);
create index product_review_product_id_idx on product_review(product_id);