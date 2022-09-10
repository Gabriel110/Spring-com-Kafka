package br.com.gabriel.shop.aplication.user.rest.dto

data class ClientRequest(
    val nome: String,
    val email: String,
    val password: String
)