package br.com.gabriel.shop.aplication.user.rest.dto

data class ClienteRequest(
    val nome: String,
    val email: String,
    val password: String
)