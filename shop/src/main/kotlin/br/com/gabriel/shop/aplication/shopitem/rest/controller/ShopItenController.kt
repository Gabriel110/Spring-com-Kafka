package br.com.gabriel.shop.aplication.shopitem.rest.controller

import br.com.gabriel.shop.aplication.shopitem.rest.dto.ShopItemRequest
import br.com.gabriel.shop.aplication.shopitem.rest.dto.ShopItemResponse
import br.com.gabriel.shop.aplication.shopitem.service.ShopItemServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/shop_item")
class ShopItenController(
    private val shopItenService: ShopItemServiceImpl
) {


    @PostMapping("/save")
    fun save(@RequestBody shopItemRequest: ShopItemRequest): ResponseEntity<String> {
        shopItenService.save(shopItemRequest)
        return ResponseEntity.ok().body("Salvo com sucesso!")
    }

    @GetMapping("/list")
    fun list(): ResponseEntity<List<ShopItemResponse>> {
        val shopItem = shopItenService.list()
        return ResponseEntity.ok().body(shopItem)
    }
}