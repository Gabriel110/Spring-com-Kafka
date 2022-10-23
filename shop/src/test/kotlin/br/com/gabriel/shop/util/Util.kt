package br.com.gabriel.shop.util

import br.com.gabriel.shop.aplication.shop.rest.dto.ShopRequest
import br.com.gabriel.shop.aplication.shop.rest.dto.ShopResponse
import br.com.gabriel.shop.aplication.shopitem.rest.dto.ShopItemResponse

class Util {


    fun getShopRequest():ShopRequest{
        return ShopRequest(
            identifier = "lavadora",
            items = arrayListOf(1)
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


    fun getShopItemResponse(): ShopItemResponse{
        return ShopItemResponse(
            id=1,
            productIdentifier="PCGAMER",
            amount=23,
            price="20.0".toFloat()
        )
    }

}