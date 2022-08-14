package br.com.gabriel.shop.aplication.shopitem.controller

import br.com.gabriel.shop.aplication.shopitem.rest.controller.ShopItenController
import br.com.gabriel.shop.aplication.shopitem.service.ShopItemServiceImpl
import br.com.gabriel.shop.util.Util
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.springframework.http.HttpStatus

class ShopItemControllerTest {
    private val shopItenService = Mockito.mock(ShopItemServiceImpl::class.java)
    private val shopController = ShopItenController(shopItenService)
    private val util = Util()

    @Test
    fun `quando chamdo deve retornar Status Code 200`(){
        val response = shopController.save(util.getShopItemRequest())
        Assertions.assertEquals(HttpStatus.OK, response.statusCode)
        Assertions.assertEquals("Salvo com sucesso!", response.body)
    }

    @Test
    fun `quando chamdo deve listar shopItens`(){
       `when`(shopItenService.list()).thenReturn(arrayListOf(util.getShopItemResponse()))
        val response = shopController.list()
        Assertions.assertEquals(HttpStatus.OK, response.statusCode)
        Assertions.assertEquals(arrayListOf(util.getShopItemResponse()), response.body)
    }
}