package br.com.gabriel.shop.aplication.shopitem.rest.dto

data class ShopItemResponse(
    val id: Long,
    val productIdentifier: String,
    val amount: Int,
    val price: Float
)