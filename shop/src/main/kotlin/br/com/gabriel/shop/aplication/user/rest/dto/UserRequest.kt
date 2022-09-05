package br.com.gabriel.shop.aplication.user.rest.dto

data class UserRequest(
    val nome: String,
    val email: String,
    val password: String
)