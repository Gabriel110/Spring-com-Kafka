package br.com.gabriel.shop.unidade.aplication.shop.controller

import br.com.gabriel.shop.aplication.shop.rest.controller.ShopController
import br.com.gabriel.shop.aplication.shop.rest.dto.ShopRequest
import br.com.gabriel.shop.aplication.shop.rest.dto.ShopResponse
import br.com.gabriel.shop.aplication.shop.service.ShopServiceImpl
import br.com.gabriel.shop.fixtures.FixtureFactoryUtils.Companion.build
import br.com.gabriel.shop.fixtures.extension.FixtureFactoryExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.springframework.http.HttpStatus

@ExtendWith(FixtureFactoryExtension::class)
class ShopControllerTest {

    private val shopServiceImpl = mock(ShopServiceImpl::class.java)
    private val shopController = ShopController(shopServiceImpl)

    @Test
    fun `quando chamdo deve retorna Status Code ok`(){
        val shopRequest: ShopRequest= build()
        val response = shopController.save(shopRequest)
        Assertions.assertEquals(HttpStatus.OK, response.statusCode)
        Assertions.assertEquals("Salvo com sucesso!", response.body)
    }

    @Test
    fun `qunado chamdo dele listar shops`(){
        val shopResponse: ShopResponse = build()
        `when`(shopServiceImpl.list()).thenReturn(arrayListOf(shopResponse))
        val response = shopController.list()
        Assertions.assertEquals(HttpStatus.OK, response.statusCode)
        Assertions.assertEquals(arrayListOf(shopResponse), response.body)
    }
}