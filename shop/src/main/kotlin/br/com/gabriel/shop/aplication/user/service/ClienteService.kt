package br.com.gabriel.shop.aplication.user.service

import br.com.gabriel.shop.aplication.user.mapper.toEntity
import br.com.gabriel.shop.aplication.user.model.ClienteData
import br.com.gabriel.shop.aplication.user.rest.dto.ClienteRequest
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import br.com.gabriel.shop.config.dto.ClienteDatails as MyUserDatails

@Service
data class ClienteService(
    private val clientePortRepository: ClientePortRepository
): UserDetailsService{

    override fun loadUserByUsername(username: String): UserDetails {
        ClienteData.from(
            email = username
        ).runCatching {
           val user = this.findByEmail(clientePortRepository, username)
           return MyUserDatails(user!!.toEntity())
       }.getOrElse{
           throw RuntimeException()
       }
    }

    fun save(request: ClienteRequest): ClienteData{
        return ClienteData.from(request)
            .runCatching {
                this.save(clientePortRepository)
            }.getOrElse {
                throw RuntimeException()
            }
    }
}