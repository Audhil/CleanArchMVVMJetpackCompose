package com.example.cleanarchcryptocurrencies.domain.model

data class Coin(
    val id: String? = null,
    val isActive: Boolean = false,
    val name: String? = null,
    val rank: Int? = null,
    val symbol: String? = null
)