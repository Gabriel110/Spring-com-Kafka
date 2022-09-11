package br.com.gabriel.shop.config.dto

import br.com.gabriel.shop.aplication.user.model.Cliente
import org.springframework.security.core.userdetails.UserDetails

class ClienteDatails(
    private val cliente: Cliente
): UserDetails {
    override fun getAuthorities() = null

    override fun getPassword() = cliente.password

    override fun getUsername() = cliente.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}