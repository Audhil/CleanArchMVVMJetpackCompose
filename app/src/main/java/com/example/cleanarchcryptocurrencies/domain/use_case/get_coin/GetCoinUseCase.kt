package com.example.cleanarchcryptocurrencies.domain.use_case.get_coin

import com.example.cleanarchcryptocurrencies.common.Resources
import com.example.cleanarchcryptocurrencies.data.remote.dto.toCoinDetail
import com.example.cleanarchcryptocurrencies.domain.model.CoinDetail
import com.example.cleanarchcryptocurrencies.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase
@Inject
constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resources<CoinDetail>> = flow {
        try {
            emit(Resources.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId = coinId).toCoinDetail()
            emit(Resources.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resources.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resources.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}