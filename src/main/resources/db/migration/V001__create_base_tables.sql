create table customers (
id             bigint not null auto_increment,
active         boolean not null,
created_at     datetime(6) not null default current_timestamp(6),
cpf            varchar(255) not null,
email          varchar(255) not null,
name           varchar(255) not null,
password       varchar(255) not null,
phone          varchar(255) not null,

primary key (id)
);

create table addresses (
id             bigint not null auto_increment,
active         boolean not null,
created_at     datetime(6) not null default current_timestamp(6),
alias          varchar(255) not null,
city           varchar(255) not null,
complement     varchar(255) not null,
neighborhood   varchar(255) not null,
number         varchar(255) not null,
state          varchar(255) not null,
street         varchar(255) not null,
zip_code       varchar(255) not null,
customer_id    bigint,

primary key (id)
);

alter table addresses
add constraint fk_address_customer_id
foreign key (customer_id)
references customers (id);

create table address_purposes (
id             bigint not null auto_increment,
active         boolean not null,
created_at     datetime(6) not null default current_timestamp(6),
purpose        varchar(255) not null,
address_id     bigint,

primary key (id)
);

alter table address_purposes
add constraint fk_address_purposes_addresses_id
foreign key (address_id)
references addresses (id);

create table cards (
id             bigint not null auto_increment,
active         boolean not null,
created_at     datetime(6) not null default current_timestamp(6),
flag           varchar(255) not null,
main           boolean not null,
number         varchar(255) not null,
security_code  varchar(255) not null,
type           varchar(255) not null,
name           varchar(255) not null,
customer_id    bigint,

primary key (id)
);

alter table cards
add constraint fk_card_customer_id
foreign key (customer_id)
references customers (id);

create table card_flags (
id             bigint not null auto_increment,
active         boolean not null,
created_at     datetime(6) not null default current_timestamp(6),
name           varchar(255) not null,

primary key (id)
);