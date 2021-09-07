package com.example.cleanarchcryptocurrencies.domain.repository

import com.example.cleanarchcryptocurrencies.data.remote.dto.CoinDto
import com.example.cleanarchcryptocurrencies.data.remote.dto.CointDetailDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId: String) : CointDetailDto
}