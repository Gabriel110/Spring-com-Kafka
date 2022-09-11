package br.com.gabriel.shop.aplication.user.service

import br.com.gabriel.shop.aplication.user.model.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository:JpaRepository<Cliente, Long> {

    fun findByEmail(email: String): Cliente?
}