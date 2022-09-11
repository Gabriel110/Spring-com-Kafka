package br.com.gabriel.shop.aplication.user.model

import br.com.gabriel.shop.aplication.user.rest.dto.ClienteRequest
import br.com.gabriel.shop.aplication.user.service.ClientePortRepository

data class ClienteData(
    val id: Long? = null,
    val nome: String? = null,
    val email: String? = null,
    val password: String? = null
) {

    fun save(repo: ClientePortRepository): ClienteData{
        return repo.save(this)
    }

    fun findByEmail(repo: ClientePortRepository, email: String): ClienteData? {
        return repo.findByEmail(email)
    }


    companion object {
        fun from(
            email: String?,
        ) = ClienteData(
            email = email,
        )

        fun from(
            clienteRequest: ClienteRequest
        ) = ClienteData(
            nome = clienteRequest.nome,
            email = clienteRequest.email,
            password = clienteRequest.password
        )
    }
}