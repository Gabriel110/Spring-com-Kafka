package br.com.gabriel.shop.aplication.user.service

import br.com.gabriel.shop.aplication.user.mapper.toEntity
import br.com.gabriel.shop.aplication.user.model.UsserData
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import br.com.gabriel.shop.config.dto.UserDatails as MyUserDatails

@Service
class UserService(
    private val userPortRepository: UserPortRepository
): UserDetailsService{

    override fun loadUserByUsername(username: String): UserDetails {
        UsserData.from(
            email = username
        ).runCatching {
           val user = this.findByEmail(userPortRepository, username)
           return MyUserDatails(user!!.toEntity())
       }.getOrElse{
           throw RuntimeException()
       }
    }
}