create table shop_item (
  id bigint not null auto_increment,
  amount integer not null,
  price float not null,
  product_identifier varchar(255),
  primary key (id)
);

insert  into shop_item (id, amount, price, product_identifier) values (1, 32, 12.0, 'camisa pokemon');
insert  into shop_item (id, amount, price, product_identifier) values (2, 31, 122.0, 'camisa one pice');
insert  into shop_item (id, amount, price, product_identifier) values (3, 30, 142.0, 'pulsera naruto');
insert  into shop_item (id, amount, price, product_identifier) values (4, 29, 142.0, 'pulsera dbz');
insert  into shop_item (id, amount, price, product_identifier) values (5, 28, 142.0, 'pulsera fabrica de monstros');