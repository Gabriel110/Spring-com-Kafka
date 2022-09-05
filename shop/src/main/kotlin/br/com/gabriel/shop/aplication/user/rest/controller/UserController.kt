package br.com.gabriel.shop.aplication.user.rest.controller

import br.com.gabriel.shop.aplication.user.rest.dto.UserRequest
import br.com.gabriel.shop.aplication.user.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {

    @GetMapping("/save")
    fun save(){
        val userRequest = UserRequest(
            nome = "Maria",
            email = "maria@email.com",
            password = "123456789"
        )
        userService.save(userRequest)
    }
}