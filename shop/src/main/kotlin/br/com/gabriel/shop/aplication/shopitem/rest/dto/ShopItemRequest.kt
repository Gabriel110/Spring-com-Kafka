package br.com.gabriel.shop.aplication.shopitem.rest.dto

import br.com.gabriel.shop.aplication.shopitem.model.ShopItem
import br.com.gabriel.shop.config.util.NoArg

@NoArg
data class ShopItemRequest(
    val productIdentifier: String,
    val amount: Int,
    val price: Float
) {

    fun toModel(): ShopItem {
        return ShopItem(
            productIdentifier = productIdentifier,
            amount = amount,
            price = price
        )
    }
}