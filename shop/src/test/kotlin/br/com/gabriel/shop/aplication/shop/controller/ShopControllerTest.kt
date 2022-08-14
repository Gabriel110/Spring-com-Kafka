package br.com.gabriel.shop.aplication.shop.controller

import br.com.gabriel.shop.aplication.shop.rest.controller.ShopController
import br.com.gabriel.shop.aplication.shop.service.ShopServiceImpl
import br.com.gabriel.shop.util.Util
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.http.HttpStatus

class ShopControllerTest {

    private val shopServiceImpl = mock(ShopServiceImpl::class.java)
    private val shopController = ShopController(shopServiceImpl)
    private val util = Util()

    @Test
    fun `quando chamdo deve retorna Status Code ok`(){
        val response = shopController.save(util.getShopRequest())
        Assertions.assertEquals(HttpStatus.OK, response.statusCode)
        Assertions.assertEquals("Salvo com sucesso!", response.body)
    }

    @Test
    fun `qunado chamdo dele listar shops`(){
        `when`(shopServiceImpl.list()).thenReturn(arrayListOf(util.getShopResponse()))
        val response = shopController.list()
        Assertions.assertEquals(HttpStatus.OK, response.statusCode)
        Assertions.assertEquals(arrayListOf(util.getShopResponse()), response.body)
    }
}