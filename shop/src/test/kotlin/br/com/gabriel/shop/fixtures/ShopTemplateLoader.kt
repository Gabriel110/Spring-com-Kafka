package br.com.gabriel.shop.fixtures

import br.com.gabriel.shop.aplication.shop.model.Shop
import br.com.gabriel.shop.aplication.shop.rest.dto.ShopRequest
import br.com.gabriel.shop.aplication.shop.rest.dto.ShopResponse
import br.com.gabriel.shop.aplication.shopitem.model.ShopItem
import br.com.gabriel.shop.aplication.shopitem.rest.dto.ShopItemRequest
import br.com.gabriel.shop.aplication.shopitem.rest.dto.ShopItemResponse
import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader

class ShopTemplateLoader: TemplateLoader {
    override fun load() {
        Fixture.of(ShopRequest::class.java).addTemplate(
            "default",
            object: Rule(){
                init {
                    add("identifier","lavadora")
                    add("items", arrayListOf(1))
                }
            }
        )

        Fixture.of(ShopResponse::class.java).addTemplate(
            "default",
            object: Rule(){
                init {
                    add("id", "1".toLong())
                    add("identifier","lavadora")
                    add("items", has(1).of(ShopItemResponse::class.java,"default"))
                }
            }
        )

        Fixture.of(Shop::class.java).addTemplate(
            "default",
            object: Rule(){
                init {
                    add("id", "1".toLong())
                    add("identifier","lavadora")
                    add("items", has(1).of(ShopItem::class.java,"default"))
                }
            }
        )

        Fixture.of(ShopItemResponse::class.java).addTemplate(
            "default",
            object: Rule(){
                init {
                    add("id","1".toLong())
                    add("productIdentifier", "PCGAMER")
                    add("amount", 23)
                    add("price", "20.0".toFloat())
                }
            }
        )

        Fixture.of(ShopItem::class.java).addTemplate(
            "default",
            object: Rule(){
                init {
                    add("id","1".toLong())
                    add("productIdentifier", "PCGAMER")
                    add("amount", 23)
                    add("price", "20.0".toFloat())
                }
            }
        )


        Fixture.of(ShopItemRequest::class.java).addTemplate(
            "default",
            object: Rule(){
                init {
                    add("productIdentifier", "PCGAMER")
                    add("amount", 23)
                    add("price", "20.0".toFloat())
                }
            }
        )


    }

}