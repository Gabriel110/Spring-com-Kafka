package br.com.gabriel.shop.aplication.shop.rest.dto

import br.com.gabriel.shop.aplication.shopitem.rest.dto.ShopItemResponse

data class ShopResponse(
    val id: Long,
    val identifier: String,
    val items:  List<ShopItemResponse>
) {
}