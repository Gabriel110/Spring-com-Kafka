package br.com.gabriel.shop.aplication.user.service

import br.com.gabriel.shop.aplication.user.mapper.toData
import br.com.gabriel.shop.aplication.user.mapper.toEntity
import br.com.gabriel.shop.aplication.user.model.UsserData
import org.hibernate.annotations.common.util.impl.LoggerFactory.logger
import org.springframework.stereotype.Repository

@Repository
class UserPortService(
    private val userRepository: UserRepository
): UserPortRepository {

    val logger = logger(UserPortRepository::class.java)

    override fun findByEmail(email: String): UsserData? {
        logger.info("Buscando usuario por email!")
        val response = userRepository.findByEmail(email)
        return response?.toData()
    }

    override fun save(data: UsserData): UsserData {
        val response = userRepository.save(data.toEntity())
        return response.toData()
    }


}