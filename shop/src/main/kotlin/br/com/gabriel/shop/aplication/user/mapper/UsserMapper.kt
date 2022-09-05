package br.com.gabriel.shop.aplication.user.mapper

import br.com.gabriel.shop.aplication.user.model.Usser
import br.com.gabriel.shop.aplication.user.model.UsserData


fun Usser.toData() = UsserData(
    id = this.id,
    nome = this.nome,
    email = this.email,
    password = this.password
)

fun UsserData.toEntity() = Usser(
    nome = this.nome?:" ",
    email = this.email?:" ",
    password = this.password?:" "
)