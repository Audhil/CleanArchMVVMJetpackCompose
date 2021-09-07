package com.example.cleanarchcryptocurrencies.presentation.ui.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchcryptocurrencies.common.Resources
import com.example.cleanarchcryptocurrencies.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel
@Inject
constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    //  side note: getCoinsUseCase() = getCoinsUseCase.invoke()
    private fun getCoins() = getCoinsUseCase().onEach { result ->
        when (result) {
            is Resources.Success -> {
                _state.value = CoinListState(coins = result.data ?: emptyList())
            }

            is Resources.Error -> {
                _state.value =
                    CoinListState(error = result.message ?: "An unexpected error occured")
            }

            is Resources.Loading -> {
                _state.value = CoinListState(isLoading = true)
            }
        }
    }.launchIn(viewModelScope)
}