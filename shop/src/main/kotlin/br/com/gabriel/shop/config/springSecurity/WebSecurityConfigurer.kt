package br.com.gabriel.shop.config.springSecurity

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurityConfigurer(
    private val userDetailsService: UserDetailsService
): WebSecurityConfigurerAdapter(){

     override fun configure(http: HttpSecurity?){
        http?.authorizeRequests()?.anyRequest()?.authenticated()
            ?.and()
            ?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            ?.and()
            ?.formLogin()?.disable()?.httpBasic()
    }

    override fun configure(auth: AuthenticationManagerBuilder?){
        auth?.userDetailsService(userDetailsService)
            ?.passwordEncoder(bCryptPasswordEncoder())
    }


    override fun configure(web: WebSecurity?) {
        web?.ignoring()
            ?.antMatchers(HttpMethod.GET, "/actuator/**")
            ?.antMatchers(HttpMethod.POST, "/h2-console/**")
            ?.antMatchers(HttpMethod.GET, "/h2-console/**")
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}