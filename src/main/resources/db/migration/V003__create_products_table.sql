create table products (
id             bigint not null auto_increment,
active         boolean not null,
created_at     datetime(6) not null default current_timestamp(6),
name           varchar(255) not null,
price          decimal(10, 2) not null,
slug           varchar(255) not null,
photo_url      varchar(255) not null,

primary key (id)
);