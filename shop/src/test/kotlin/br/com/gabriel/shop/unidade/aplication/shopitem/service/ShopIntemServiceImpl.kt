package br.com.gabriel.shop.unidade.aplication.shopitem.service

import br.com.gabriel.shop.aplication.shopitem.model.ShopItem
import br.com.gabriel.shop.aplication.shopitem.service.ShopItemRepository
import br.com.gabriel.shop.aplication.shopitem.service.ShopItemServiceImpl
import br.com.gabriel.shop.util.Util
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.*

class ShopIntemServiceImpl {

    private val shopItemRepository = mock(ShopItemRepository::class.java)
    private val shopItemServiceImpl = ShopItemServiceImpl(shopItemRepository)
    private val util = Util()

    @Test
    fun `quando chmado sava um shopItem no banco`(){
        val captor = ArgumentCaptor.forClass(ShopItem::class.java)
        shopItemServiceImpl.save(util.getShopItemRequest())
        verify(shopItemRepository, times(1)).save(captor.capture())
    }

    @Test
    fun `qunado chamado dever retorna uma lista de ShopItemResponse`(){
        `when`(shopItemRepository.findAll()).thenReturn(arrayListOf(util.getShopItem()))
        val response = shopItemServiceImpl.list()
        Assertions.assertEquals(arrayListOf(util.getShopItemResponse()), response)
    }
}