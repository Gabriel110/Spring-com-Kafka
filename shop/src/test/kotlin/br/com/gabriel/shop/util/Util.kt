package br.com.gabriel.shop.util

import br.com.gabriel.shop.aplication.doman.Shop
import br.com.gabriel.shop.aplication.shop.rest.dto.ShopRequest
import br.com.gabriel.shop.aplication.shop.rest.dto.ShopResponse
import br.com.gabriel.shop.aplication.shopitem.model.ShopItem
import br.com.gabriel.shop.aplication.shopitem.rest.dto.ShopItemRequest
import br.com.gabriel.shop.aplication.shopitem.rest.dto.ShopItemResponse
import java.util.Optional

class Util {


    fun getShopRequest():ShopRequest{
        return ShopRequest(
            identifier = "lavadora",
            items = arrayListOf(1)
        )
    }

    fun getOptionalShopItem(): Optional<ShopItem> {
        return Optional.of(
            ShopItem(
                id = 1,
                productIdentifier = "PCGAMER",
                amount = 23,
                price = "20.0".toFloat()
            )
        )
    }

    fun getShopItem(): ShopItem{
        return  ShopItem(
            id = 1,
            productIdentifier = "PCGAMER",
            amount = 23,
            price = "20.0".toFloat()
        )
    }

    fun getShop(): Shop {
        return Shop(
            id = 1,
            identifier = "lavadora",
            items = arrayListOf(
                ShopItem(
                    id = 1,
                    productIdentifier = "PCGAMER",
                    amount = 23,
                    price = "20.0".toFloat()
                )
            )
        )
    }



    fun getShopResponse():ShopResponse{
        return ShopResponse(
            id=1, identifier="lavadora",
            items= arrayListOf(
                ShopItemResponse(
                    id=1,
                    productIdentifier="PCGAMER",
                    amount=23,
                    price="20.0".toFloat()
                )
            )
        )
    }

    fun getShopItemRequest(): ShopItemRequest{
        return ShopItemRequest(
            productIdentifier="PCGAMER",
            amount=23,
            price="20.0".toFloat()
        )
    }

    fun getShopItemResponse(): ShopItemResponse{
        return ShopItemResponse(
            id=1,
            productIdentifier="PCGAMER",
            amount=23,
            price="20.0".toFloat()
        )
    }

}