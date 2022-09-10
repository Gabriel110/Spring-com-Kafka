package br.com.gabriel.shop.aplication.user.service

import br.com.gabriel.shop.aplication.user.model.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository:JpaRepository<Client, Long> {

    fun findByEmail(email: String): Client?
}