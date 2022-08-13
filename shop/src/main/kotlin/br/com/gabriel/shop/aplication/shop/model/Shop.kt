package br.com.gabriel.shop.aplication.doman

import br.com.gabriel.shop.aplication.shopitem.model.ShopItem
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "shop")
data class Shop(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val identifier: String,
    @Column(name = "data_shop")
    val dataShop: LocalDateTime = LocalDateTime.now(),
    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    var items: List<ShopItem>
)