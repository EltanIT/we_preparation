package com.example.ws_preparation.presentation.navgraph

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ws_preparation.presentation.Home.HomeScreen
import com.example.ws_preparation.presentation.Profile.ProfileViewModel
import com.example.ws_preparation.presentation.Track.TrackViewModel
import com.example.ws_preparation.presentation.Wallet.WalletViewModel
import com.example.ws_preparation.presentation.Wallet.components.ProfileScreen
import com.example.ws_preparation.presentation.Wallet.components.TrackScreen
import com.example.ws_preparation.presentation.Wallet.components.WalletScreen


@Composable
fun HomeNavGraph(
    navHostController: NavHostController,
    mainNavHostController: NavController,
    startDestination: String,
    paddingValues: PaddingValues
) {
    NavHost(navHostController, startDestination,
        modifier= Modifier
            .background(Color.White)
            .padding(paddingValues)) {
        composable(Route.HomeScreen.route) {
            HomeScreen(mainNavHostController)
        }
        composable(Route.WalletScreen.route) {
            val viewModel: WalletViewModel = hiltViewModel()
            WalletScreen(viewModel, mainNavHostController)
        }
        composable(Route.TrackScreen.route) {
            val viewModel: TrackViewModel = hiltViewModel()
            TrackScreen(viewModel, mainNavHostController)
        }
        composable(Route.ProfileScreen.route) {
            val viewModel: ProfileViewModel = hiltViewModel()
            ProfileScreen(viewModel, mainNavHostController)
        }

    }
}