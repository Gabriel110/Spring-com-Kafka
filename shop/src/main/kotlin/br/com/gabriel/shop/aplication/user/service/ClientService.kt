package br.com.gabriel.shop.aplication.user.service

import br.com.gabriel.shop.aplication.user.mapper.toEntity
import br.com.gabriel.shop.aplication.user.model.UsserData
import br.com.gabriel.shop.aplication.user.rest.dto.ClientRequest
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import br.com.gabriel.shop.config.dto.ClientDatails as MyUserDatails

@Service
data class ClientService(
    private val clientPortRepository: ClientPortRepository
): UserDetailsService{

    override fun loadUserByUsername(username: String): UserDetails {
        UsserData.from(
            email = username
        ).runCatching {
           val user = this.findByEmail(clientPortRepository, username)
           return MyUserDatails(user!!.toEntity())
       }.getOrElse{
           throw RuntimeException()
       }
    }

    fun save(request: ClientRequest): UsserData{
        return UsserData.from(request)
            .runCatching {
                this.save(clientPortRepository)
            }.getOrElse {
                throw RuntimeException()
            }
    }
}