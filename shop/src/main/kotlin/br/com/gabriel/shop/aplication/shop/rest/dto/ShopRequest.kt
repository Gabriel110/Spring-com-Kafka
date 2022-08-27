package br.com.gabriel.shop.aplication.shop.rest.dto

import br.com.gabriel.shop.aplication.shop.model.Shop
import br.com.gabriel.shop.aplication.shopitem.model.ShopItem

data class ShopRequest(
   val identifier: String,
   val items:  List<Long>
) {

    fun toModel(iten: List<ShopItem>): Shop {
        return Shop(
            identifier = identifier,
            items = iten
        )
    }
}