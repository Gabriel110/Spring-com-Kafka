package br.com.gabriel.shop.unidade.aplication.shop.service

import br.com.gabriel.shop.aplication.shop.model.Shop
import br.com.gabriel.shop.aplication.shop.service.ShopRepository
import br.com.gabriel.shop.aplication.shop.service.ShopServiceImpl
import br.com.gabriel.shop.aplication.shopitem.service.ShopItemRepository
import br.com.gabriel.shop.util.Util
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.*


class ShopServiceImpTest {

    private val shopRepository: ShopRepository = mock(ShopRepository::class.java)
    private val shopItemRepository:ShopItemRepository = mock(ShopItemRepository::class.java)

    private val shopServiceImpl = ShopServiceImpl(shopRepository, shopItemRepository)

    private val util = Util()

    @Test
    fun `quando chamdo deve listar os shop`(){
        `when`(shopRepository.findAll()).thenReturn(arrayListOf(util.getShop()))
        val response = shopServiceImpl.list()
        Assertions.assertEquals(arrayListOf(util.getShopResponse()), response)
    }

    @Test
    fun `quando cahamdo deve salvar dados no banco`(){
         val capture = ArgumentCaptor.forClass(Shop::class.java)
        `when`(shopItemRepository.findById(1)).thenReturn(util.getOptionalShopItem())
        shopServiceImpl.save(util.getShopRequest())
        verify(shopRepository, times(1)).save(capture.capture())
    }
}

