package com.example.cleanarchcryptocurrencies.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cleanarchcryptocurrencies.common.Constants
import com.example.cleanarchcryptocurrencies.presentation.Screen
import com.example.cleanarchcryptocurrencies.presentation.theme.CleanArchCryptoCurrenciesTheme
import com.example.cleanarchcryptocurrencies.presentation.ui.coin_detail.CoinDetailScreen
import com.example.cleanarchcryptocurrencies.presentation.ui.coin_list.CoinListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchCryptoCurrenciesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(route = Screen.CoinListScreen.route) {
                            CoinListScreen(navController = navController)
                        }
                        composable(route = Screen.CoinDetailScreen.route + "/{" + Constants.PARAM_COIN_ID + "}") {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}