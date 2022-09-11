package br.com.gabriel.shop.aplication.user.mapper

import br.com.gabriel.shop.aplication.user.model.Cliente
import br.com.gabriel.shop.aplication.user.model.ClienteData


fun Cliente.toData() = ClienteData(
    id = this.id,
    nome = this.nome,
    email = this.email,
    password = this.password
)

fun ClienteData.toEntity() = Cliente(
    nome = this.nome?:" ",
    email = this.email?:" ",
    password = this.password?:" "
)