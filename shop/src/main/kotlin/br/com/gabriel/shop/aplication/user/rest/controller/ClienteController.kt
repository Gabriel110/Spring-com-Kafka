package br.com.gabriel.shop.aplication.user.rest.controller

import br.com.gabriel.shop.aplication.user.rest.dto.ClienteRequest
import br.com.gabriel.shop.aplication.user.service.ClienteService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class ClienteController(
    private val clienteService: ClienteService
) {

    @GetMapping("/save")
    fun save(){
        val clienteRequest = ClienteRequest(
            nome = "Maria",
            email = "maria@email.com",
            password = "123456789"
        )
        clienteService.save(clienteRequest)
    }
}