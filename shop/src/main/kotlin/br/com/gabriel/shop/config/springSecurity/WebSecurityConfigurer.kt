package br.com.gabriel.shop.config.springSecurity

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurityConfigurer(
    private val userDetailsService: UserDetailsService
){

     fun configure(http: HttpSecurity?){
        http?.authorizeRequests()?.anyRequest()?.authenticated()
            ?.and()
            ?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            ?.and()
            ?.formLogin()?.disable()?.httpBasic()
    }

    fun configure(auth: AuthenticationManagerBuilder?){
        auth?.userDetailsService(userDetailsService)
            ?.passwordEncoder(bCryptPasswordEncoder())
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}