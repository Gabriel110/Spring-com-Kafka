package br.com.gabriel.shop.aplication.shopitem.rest.dto

import br.com.gabriel.shop.config.util.NoArg

@NoArg
data class ShopItemResponse(
    val id: Long,
    val productIdentifier: String,
    val amount: Int,
    val price: Float
)