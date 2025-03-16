create table product_items (
id             bigint not null auto_increment,
active         boolean not null,
created_at     datetime(6) not null default current_timestamp(6),
code           varchar(255) not null,
status         varchar(255) not null,
product_id     bigint not null,

primary key (id)
);

alter table product_items
    add constraint fk_product
    foreign key (product_id)
    references products(id);