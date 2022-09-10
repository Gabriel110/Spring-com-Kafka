package br.com.gabriel.shop.aplication.user.mapper

import br.com.gabriel.shop.aplication.user.model.Client
import br.com.gabriel.shop.aplication.user.model.UsserData


fun Client.toData() = UsserData(
    id = this.id,
    nome = this.nome,
    email = this.email,
    password = this.password
)

fun UsserData.toEntity() = Client(
    nome = this.nome?:" ",
    email = this.email?:" ",
    password = this.password?:" "
)