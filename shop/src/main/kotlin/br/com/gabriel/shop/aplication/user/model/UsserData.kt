package br.com.gabriel.shop.aplication.user.model

import br.com.gabriel.shop.aplication.user.service.UserPortRepository

data class UsserData(
    val id: Long? = null,
    val nome: String? = null,
    val email: String? = null,
    val password: String? = null
) {

    fun save(repo: UserPortRepository): UsserData{
        return repo.save(this)
    }

    fun findByEmail(repo: UserPortRepository, email: String): UsserData? {
        return repo.findByEmail(email)
    }


    companion object {
        fun from(
            email: String?,
        ) = UsserData(
            email = email,
        )
    }
}