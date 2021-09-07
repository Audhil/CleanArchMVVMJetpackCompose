package com.example.cleanarchcryptocurrencies.data.remote.dto

import com.example.cleanarchcryptocurrencies.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("rank")
    val rank: Int? = null,
    @SerializedName("symbol")
    val symbol: String? = null,
    @SerializedName("type")
    val type: String? = null
)

fun CoinDto.toCoin(): Coin =
    Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )