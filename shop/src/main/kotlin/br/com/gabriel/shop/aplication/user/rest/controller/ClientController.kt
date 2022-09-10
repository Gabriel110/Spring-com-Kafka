package br.com.gabriel.shop.aplication.user.rest.controller

import br.com.gabriel.shop.aplication.user.rest.dto.ClientRequest
import br.com.gabriel.shop.aplication.user.service.ClientService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class ClientController(
    private val clientService: ClientService
) {

    @GetMapping("/save")
    fun save(){
        val clientRequest = ClientRequest(
            nome = "Maria",
            email = "maria@email.com",
            password = "123456789"
        )
        clientService.save(clientRequest)
    }
}