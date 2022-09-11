package br.com.gabriel.shop.aplication.user.service

import br.com.gabriel.shop.aplication.user.mapper.toData
import br.com.gabriel.shop.aplication.user.mapper.toEntity
import br.com.gabriel.shop.aplication.user.model.ClienteData
import org.hibernate.annotations.common.util.impl.LoggerFactory.logger
import org.springframework.stereotype.Repository

@Repository
class ClientePortService(
    private val clienteRepository: ClienteRepository
): ClientePortRepository {

    val logger = logger(ClientePortRepository::class.java)

    override fun findByEmail(email: String): ClienteData? {
        logger.info("Buscando usuario por email!")
        val response = clienteRepository.findByEmail(email)
        return response?.toData()
    }

    override fun save(data: ClienteData): ClienteData {
        val response = clienteRepository.save(data.toEntity())
        return response.toData()
    }


}