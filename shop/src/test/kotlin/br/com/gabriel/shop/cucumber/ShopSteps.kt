package br.com.gabriel.shop.cucumber

import br.com.gabriel.shop.aplication.shop.rest.controller.ShopController
import br.com.gabriel.shop.aplication.shop.rest.dto.ShopRequest
import br.com.gabriel.shop.aplication.shop.rest.dto.ShopResponse
import br.com.gabriel.shop.aplication.shop.service.ShopServiceImpl
import br.com.gabriel.shop.util.Util
import io.cucumber.java.pt.Dado
import io.cucumber.java.pt.Entao
import io.cucumber.java.pt.Quando
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity


class ShopSteps {

    private val shopServiceImpl = Mockito.mock(ShopServiceImpl::class.java)
    private val shopController = ShopController(shopServiceImpl)
    private val util = Util()

    lateinit var response: ResponseEntity<List<ShopResponse>>
    lateinit var shopRequest: ShopRequest
    lateinit var shpControllrResponse: ResponseEntity<String>

    @Quando("acessa o controler")
    fun acessa_o_controler() {
        Mockito.`when`(shopServiceImpl.list()).thenReturn(arrayListOf(util.getShopResponse()))
        response = shopController.list()
    }

    @Entao("e retonado uma lista de shop")
    fun e_retonado_uma_lista_de_shop() {
        Assertions.assertEquals(HttpStatus.OK, response.statusCode)
        Assertions.assertEquals(arrayListOf(util.getShopResponse()), response.body)
    }

    @Dado("um request do tipo shop")
    fun um_request_do_tipo_shop() {
        shopRequest = util.getShopRequest()
    }

    @Quando("um resquest valido")
    fun um_resquest_valido() {
        shpControllrResponse = shopController.save(shopRequest)
        Assertions.assertInstanceOf(ShopRequest::class.java, shopRequest)
    }

    @Entao("salve no banco")
    fun salve_no_banco() {
        Assertions.assertEquals(HttpStatus.OK, shpControllrResponse.statusCode)
        Assertions.assertEquals("Salvo com sucesso!", shpControllrResponse.body)
    }
}