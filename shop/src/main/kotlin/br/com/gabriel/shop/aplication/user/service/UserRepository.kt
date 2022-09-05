package br.com.gabriel.shop.aplication.user.service

import br.com.gabriel.shop.aplication.user.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository:JpaRepository<User, Long> {


    fun findByEmail(email: String): User?
}