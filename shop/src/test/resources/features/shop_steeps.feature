# language: pt
Funcionalidade: Listando Shop
Cenario: listando shop
  Quando acessa o controler
  Entao e retonado uma lista de shop

Cenario: salvando shop
  Dado um request do tipo shop
  Quando um resquest valido
  Entao salve no banco
