package br.com.gabriel.shop.unidade.aplication.shopitem.service

import br.com.gabriel.shop.aplication.shopitem.model.ShopItem
import br.com.gabriel.shop.aplication.shopitem.rest.dto.ShopItemRequest
import br.com.gabriel.shop.aplication.shopitem.rest.dto.ShopItemResponse
import br.com.gabriel.shop.aplication.shopitem.service.ShopItemRepository
import br.com.gabriel.shop.aplication.shopitem.service.ShopItemServiceImpl
import br.com.gabriel.shop.fixtures.FixtureFactoryUtils.Companion.build
import br.com.gabriel.shop.fixtures.extension.FixtureFactoryExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.*


@ExtendWith(FixtureFactoryExtension::class)
class ShopIntemServiceImpl {

    private val shopItemRepository = mock(ShopItemRepository::class.java)
    private val shopItemServiceImpl = ShopItemServiceImpl(shopItemRepository)


    @Test
    fun `quando chmado sava um shopItem no banco`(){
        val captor = ArgumentCaptor.forClass(ShopItem::class.java)
        val shopItemRequest: ShopItemRequest = build()
        shopItemServiceImpl.save(shopItemRequest)
        verify(shopItemRepository, times(1)).save(captor.capture())
    }

    @Test
    fun `qunado chamado dever retorna uma lista de ShopItemResponse`(){
        val shopItem: ShopItem = build()
        val shopItemResponse: ShopItemResponse = build()
        `when`(shopItemRepository.findAll()).thenReturn(arrayListOf(shopItem))
        val response = shopItemServiceImpl.list()
        Assertions.assertEquals(arrayListOf(shopItemResponse), response)
    }
}