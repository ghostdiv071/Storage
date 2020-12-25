create table customer (
    id int not null ,
    name varchar(255) not null,
    purchase_amount float check ( purchase_amount >= 0 ),
    primary key(id)
);

create table provider (
    id int not null,
    name varchar(255) not null,
    primary key (id)
);

create table product (
    id int not null,
    name varchar(255) not null,
    type varchar(255) not null,
    provider_id int not null,
    customer_id int,
    primary key (id),
    foreign key (provider_id) references provider(id),
    foreign key (provider_id) references customer(id)
);

select id, name
    from provider
    where id = 1;
