package br.com.gabriel.shop.unidade.aplication.shopitem.controller

import br.com.gabriel.shop.aplication.shopitem.rest.controller.ShopItenController
import br.com.gabriel.shop.aplication.shopitem.rest.dto.ShopItemRequest
import br.com.gabriel.shop.aplication.shopitem.rest.dto.ShopItemResponse
import br.com.gabriel.shop.aplication.shopitem.service.ShopItemServiceImpl
import br.com.gabriel.shop.fixtures.FixtureFactoryUtils.Companion.build
import br.com.gabriel.shop.fixtures.extension.FixtureFactoryExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.springframework.http.HttpStatus

@ExtendWith(FixtureFactoryExtension::class)
class ShopItemControllerTest {
    private val shopItenService = Mockito.mock(ShopItemServiceImpl::class.java)
    private val shopController = ShopItenController(shopItenService)

    @Test
    fun `quando chamdo deve retornar Status Code 200`(){
        val shopItemRequest: ShopItemRequest = build()
        val response = shopController.save(shopItemRequest)
        Assertions.assertEquals(HttpStatus.OK, response.statusCode)
        Assertions.assertEquals("Salvo com sucesso!", response.body)
    }

    @Test
    fun `quando chamdo deve listar shopItens`(){
        val shopItemResponse: ShopItemResponse = build()
       `when`(shopItenService.list()).thenReturn(arrayListOf(shopItemResponse))
        val response = shopController.list()
        Assertions.assertEquals(HttpStatus.OK, response.statusCode)
        Assertions.assertEquals(arrayListOf(shopItemResponse), response.body)
    }
}