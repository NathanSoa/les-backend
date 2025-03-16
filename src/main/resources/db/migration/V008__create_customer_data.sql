insert into customers (
    active,
    created_at,
    cpf,
    email,
    name,
    password,
    phone
) values (
     true,
     '2023-10-10 00:00:00.000000',
     '12345678900',
     'customer@example.com',
     'John Doe',
     'password123',
     '555-1234'
 );

set @customer_id = last_insert_id();

insert into addresses (
    active,
    created_at,
    alias,
    city,
    complement,
    neighborhood,
    number,
    state,
    street,
    zip_code,
    customer_id
) values (
     true,
     '2023-10-10 00:00:00.000000',
     'Home',
     'City A',
     'Apt 1',
     'Neighborhood A',
     '123',
     'State A',
     'Street A',
     '12345-678',
     @customer_id
 );

set @first_address = last_insert_id();

insert into addresses (
    active,
    created_at,
    alias,
    city,
    complement,
    neighborhood,
    number,
    state,
    street,
    zip_code,
    customer_id
) values (
     true,
     '2023-10-10 00:00:00.000000',
     'Work',
     'City B',
     'Suite 200',
     'Neighborhood B',
     '456',
     'State B',
     'Street B',
     '98765-432',
     @customer_id
 );

set @second_address = last_insert_id();

insert into address_purposes (
    active,
    created_at,
    purpose,
    address_id
) values (
     true,
     '2023-10-10 00:00:00.000000',
     'BILLING',
     @first_address
 ), (
    true,
    '2023-10-10 00:00:00.000000',
    'SHIPPING',
    @first_address
), (
     true,
     '2023-10-10 00:00:00.000000',
     'SHIPPING',
     @second_address
 );

insert into cards (
    active,
    created_at,
    flag,
    main,
    number,
    security_code,
    type,
    name,
    customer_id
) values (
     true,
     '2023-10-10 00:00:00.000000',
     'Visa',
     true,
     '4111111111111111',
     '123',
     'Credit',
     'John Doe',
     @customer_id
 ), (
     true,
     '2023-10-10 00:00:00.000000',
     'MasterCard',
     false,
     '5500000000000004',
     '456',
     'Credit',
     'John Doe',
     @customer_id
 ), (
     true,
     '2023-10-10 00:00:00.000000',
     'Amex',
     false,
     '340000000000009',
     '789',
     'Credit',
     'John Doe',
     @customer_id
 );