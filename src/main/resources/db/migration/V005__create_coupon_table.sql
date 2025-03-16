create table coupons (
 id             bigint not null auto_increment,
 active         boolean not null,
 created_at     datetime(6) not null default current_timestamp(6),
 code           varchar(255) not null,
 discount       decimal(10, 2) not null,
 type           varchar(255) not null,
 primary key (id)
);