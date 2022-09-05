package br.com.gabriel.shop.config.dto

import br.com.gabriel.shop.aplication.user.model.Usser
import org.springframework.security.core.userdetails.UserDetails

class UserDatails(
    private val user: Usser
): UserDetails {
    override fun getAuthorities() = null

    override fun getPassword() = user.password

    override fun getUsername() = user.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}