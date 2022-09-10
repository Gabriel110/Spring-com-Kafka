package br.com.gabriel.shop.config.dto

import br.com.gabriel.shop.aplication.user.model.Client
import org.springframework.security.core.userdetails.UserDetails

class ClientDatails(
    private val client: Client
): UserDetails {
    override fun getAuthorities() = null

    override fun getPassword() = client.password

    override fun getUsername() = client.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}