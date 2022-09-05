package br.com.gabriel.shop.aplication.user.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import br.com.gabriel.shop.config.dto.UserDatails as MyUserDatails

@Service
class UserService(
    private val userRepository: UserRepository
): UserDetailsService{

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByEmail(username) ?: throw RuntimeException()
        return MyUserDatails(user)
    }
}