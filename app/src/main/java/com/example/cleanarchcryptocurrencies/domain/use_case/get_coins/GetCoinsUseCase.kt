package com.example.cleanarchcryptocurrencies.domain.use_case.get_coins

import com.example.cleanarchcryptocurrencies.common.Resources
import com.example.cleanarchcryptocurrencies.data.remote.dto.toCoin
import com.example.cleanarchcryptocurrencies.domain.model.Coin
import com.example.cleanarchcryptocurrencies.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase
@Inject
constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resources<List<Coin>>> = flow {
        try {
            emit(Resources.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resources.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resources.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resources.Error<List<Coin>>("Couldn't reach server. Check your internet connection"))
        }
    }
}