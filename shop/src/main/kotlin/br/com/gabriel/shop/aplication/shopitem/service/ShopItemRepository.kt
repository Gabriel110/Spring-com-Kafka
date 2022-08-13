package br.com.gabriel.shop.aplication.shopitem.service

import br.com.gabriel.shop.aplication.shopitem.model.ShopItem
import org.springframework.data.jpa.repository.JpaRepository

interface ShopItemRepository: JpaRepository<ShopItem, Long> {
}