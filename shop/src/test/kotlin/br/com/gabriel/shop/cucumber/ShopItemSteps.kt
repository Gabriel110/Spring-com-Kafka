package br.com.gabriel.shop.cucumber

import br.com.gabriel.shop.aplication.shopitem.rest.controller.ShopItenController
import br.com.gabriel.shop.aplication.shopitem.rest.dto.ShopItemResponse
import br.com.gabriel.shop.aplication.shopitem.service.ShopItemServiceImpl
import br.com.gabriel.shop.util.Util
import io.cucumber.java.pt.Entao
import io.cucumber.java.pt.Quando
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity


class ShopItemSteps {

    private val shopItenService = Mockito.mock(ShopItemServiceImpl::class.java)
    private val shopController = ShopItenController(shopItenService)
    private val util = Util()

    lateinit var responseList: ResponseEntity<List<ShopItemResponse>>

    @Quando("chmado o controller")
    fun chmado_o_controller() {
        Mockito.`when`(shopItenService.list()).thenReturn(arrayListOf(util.getShopItemResponse()))
        responseList = shopController.list()
    }

    @Entao("retone uma lista de shop item")
    fun retone_uma_lista_de_shop_item() {
        Assertions.assertEquals(HttpStatus.OK, responseList.statusCode)
        Assertions.assertEquals(arrayListOf(util.getShopItemResponse()), responseList.body)
    }

}