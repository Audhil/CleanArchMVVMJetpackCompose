package com.example.cleanarchcryptocurrencies.presentation.ui.coin_list

import com.example.cleanarchcryptocurrencies.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)