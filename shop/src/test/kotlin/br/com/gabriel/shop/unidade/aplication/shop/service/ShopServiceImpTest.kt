package br.com.gabriel.shop.unidade.aplication.shop.service

import br.com.gabriel.shop.aplication.shop.model.Shop
import br.com.gabriel.shop.aplication.shop.rest.dto.ShopResponse
import br.com.gabriel.shop.aplication.shop.service.ShopRepository
import br.com.gabriel.shop.aplication.shop.service.ShopServiceImpl
import br.com.gabriel.shop.aplication.shopitem.model.ShopItem
import br.com.gabriel.shop.aplication.shopitem.service.ShopItemRepository
import br.com.gabriel.shop.fixtures.FixtureFactoryUtils.Companion.build
import br.com.gabriel.shop.fixtures.extension.FixtureFactoryExtension
import br.com.gabriel.shop.util.Util
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.*
import java.util.*


@ExtendWith(FixtureFactoryExtension::class)
class ShopServiceImpTest {

    private val shopRepository: ShopRepository = mock(ShopRepository::class.java)
    private val shopItemRepository:ShopItemRepository = mock(ShopItemRepository::class.java)

    private val shopServiceImpl = ShopServiceImpl(shopRepository, shopItemRepository)

    @Test
    fun `quando chamdo deve listar os shop`(){
        val shopResponse: ShopResponse = build()
        val shop: Shop = build()
        `when`(shopRepository.findAll()).thenReturn(arrayListOf(shop))
        val response = shopServiceImpl.list()
        Assertions.assertEquals(arrayListOf(shopResponse), response)
    }

    @Test
    fun `quando cahamdo deve salvar dados no banco`(){
         val capture = ArgumentCaptor.forClass(Shop::class.java)
        val shop: ShopItem = build()
        `when`(shopItemRepository.findById(1)).thenReturn(Optional.of(shop))
        shopServiceImpl.save(build())
        verify(shopRepository, times(1)).save(capture.capture())
    }
}

