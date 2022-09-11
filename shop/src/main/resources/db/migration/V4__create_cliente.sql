create table cliente(
    id bigint not null auto_increment,
    nome varchar(50) not null,
    email varchar(50) not null,
    password varchar(300) not null,
    primary key(id)
);

insert into cliente values(1, 'Gabriel', 'gabriel@email.com', '$2a$12$vbhKgLSRztDIOsJyMC9wUe1uDA8nBkZXx0.0vuty1IN5iYG1S/qHi');
insert into cliente values(2, 'Gabriel', 'gabriel2@email.com', '$2a$12$vbhKgLSRztDIOsJyMC9wUe1uDA8nBkZXx0.0vuty1IN5iYG1S/qHi');