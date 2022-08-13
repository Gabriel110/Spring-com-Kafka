package br.com.gabriel.shop.aplication.shop.rest.controller

import br.com.gabriel.shop.aplication.shop.rest.dto.ShopRequest
import br.com.gabriel.shop.aplication.shop.rest.dto.ShopResponse
import br.com.gabriel.shop.aplication.shop.service.ShopServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/shop")
class ShopController(
    private val shopServiceImpl: ShopServiceImpl
) {

    @PostMapping("/save")
    fun save(@RequestBody shopRequest: ShopRequest): ResponseEntity<String> {
        shopServiceImpl.save(shopRequest)
        return ResponseEntity.ok().body("Salvo com sucesso!")
    }

    @GetMapping("/list")
    fun list(): ResponseEntity<List<ShopResponse>> {

        return ResponseEntity.ok().body(shopServiceImpl.list())
    }
}