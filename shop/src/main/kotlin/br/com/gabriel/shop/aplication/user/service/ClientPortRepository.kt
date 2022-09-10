package br.com.gabriel.shop.aplication.user.service

import br.com.gabriel.shop.aplication.user.model.UsserData

interface ClientPortRepository {

    fun findByEmail(email: String): UsserData?

    fun save(data: UsserData): UsserData
}