create table shop_items (
 shop_id bigint not null,
 items_id bigint not null
);

alter table shop_items
  add constraint FKby184bd3asd6f2291i70eyg83
  foreign key (items_id)
  references shop_item;

alter table shop_items
   add constraint FK3bo9f3bw73bgsu1myskndp673
   foreign key (shop_id)
    references shop;