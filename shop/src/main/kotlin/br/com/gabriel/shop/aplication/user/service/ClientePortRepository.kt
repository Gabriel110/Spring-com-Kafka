package br.com.gabriel.shop.aplication.user.service

import br.com.gabriel.shop.aplication.user.model.ClienteData

interface ClientePortRepository {

    fun findByEmail(email: String): ClienteData?

    fun save(data: ClienteData): ClienteData
}