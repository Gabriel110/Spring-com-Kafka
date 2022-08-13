package br.com.gabriel.shop.aplication.shop.service

import br.com.gabriel.shop.aplication.shop.rest.dto.ShopRequest
import br.com.gabriel.shop.aplication.shop.rest.dto.ShopResponse
import br.com.gabriel.shop.aplication.shopitem.rest.dto.ShopItemResponse
import br.com.gabriel.shop.aplication.shopitem.service.ShopItemRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ShopServiceImpl(
    private val shopRepository: ShopRepository,
    private val shopItemRepository: ShopItemRepository
) {
    val logger = LoggerFactory.getLogger(ShopServiceImpl::class.java)

    fun save(shopRequest: ShopRequest){
        val items = shopRequest.items.map { shopItemRepository.findById(it).get() }
        val shop =  shopRequest.toModel(items)
        shopRepository.save(shop)
        logger.info("[ShopServiceImpl::itens] Itens $items")
        logger.info("[ShopServiceImpl::save] shop $shop")
    }


    fun list(): List<ShopResponse> {
        val shop = shopRepository.findAll()
        val shopResponse = shop.map { ShopResponse(it.id!!, it.identifier, it.items.map { ShopItemResponse(it.id!!, it.productIdentifier, it.amount, it.price) } ) }
        logger.info("[ShopServiceImpl::list] shop:$shop")
        return shopResponse
    }
}