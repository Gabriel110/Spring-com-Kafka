create table roles(
    id bigint not null auto_increment,
    nome varchar(250) not null,
    primary key(id)
);

insert into roles values(1, 'ADM');

create table cliente_roles(
   id bigint not null auto_increment,
   roles_id bigint not null,
   cliente_id bigint not null,
   primary key(id),
   foreign key(roles_id) references roles(id),
   foreign key(cliente_id) references cliente(id)
);

insert into cliente_roles values(1, 1, 1);
