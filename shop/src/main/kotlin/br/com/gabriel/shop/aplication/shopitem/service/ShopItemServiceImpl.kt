package br.com.gabriel.shop.aplication.shopitem.service

import br.com.gabriel.shop.aplication.shopitem.rest.dto.ShopItemRequest
import br.com.gabriel.shop.aplication.shopitem.rest.dto.ShopItemResponse
import org.springframework.stereotype.Service

@Service
class ShopItemServiceImpl(
    private val shopItemRepository: ShopItemRepository
) {

    fun save(shopItemRequest: ShopItemRequest){
        shopItemRepository.save(shopItemRequest.toModel())
    }

    fun list(): List<ShopItemResponse> {
        return shopItemRepository.findAll().map { ShopItemResponse(it.id!!, it.productIdentifier, it.amount, it.price) }
    }
}