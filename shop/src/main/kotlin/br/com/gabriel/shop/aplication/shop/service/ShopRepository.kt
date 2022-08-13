package br.com.gabriel.shop.aplication.shop.service

import br.com.gabriel.shop.aplication.doman.Shop
import org.springframework.data.jpa.repository.JpaRepository

interface ShopRepository: JpaRepository<Shop, Long> {
}