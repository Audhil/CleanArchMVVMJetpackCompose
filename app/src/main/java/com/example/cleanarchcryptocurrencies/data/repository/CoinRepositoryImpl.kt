package com.example.cleanarchcryptocurrencies.data.repository

import com.example.cleanarchcryptocurrencies.data.remote.CoinPaprikaApi
import com.example.cleanarchcryptocurrencies.data.remote.dto.CoinDto
import com.example.cleanarchcryptocurrencies.data.remote.dto.CointDetailDto
import com.example.cleanarchcryptocurrencies.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl
@Inject
constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> =
        api.getCoins()

    override suspend fun getCoinById(coinId: String): CointDetailDto =
        api.getCoinById(coinId = coinId)
}