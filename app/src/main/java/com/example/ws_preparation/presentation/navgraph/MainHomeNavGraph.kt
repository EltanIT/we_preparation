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
import com.example.ws_preparation.domain.model.PackageData
import com.example.ws_preparation.presentation.Home.HomeScreen
import com.example.ws_preparation.presentation.MainScreen.MainScreenViewModel
import com.example.ws_preparation.presentation.MainScreen.components.MainScreen
import com.example.ws_preparation.presentation.SendAPackage.SendAPackageViewModel
import com.example.ws_preparation.presentation.SendAPackage.components.SendAPackageScreen
import com.example.ws_preparation.presentation.SendAPackageReceipt.SendAPackageReceiptViewModel
import com.example.ws_preparation.presentation.SendAPackageReceipt.components.SendAPackageReceiptScreen
import com.example.ws_preparation.presentation.TransactionSuccessful.TransactionSuccessfulViewModel
import com.example.ws_preparation.presentation.TransactionSuccessful.components.TransactionSuccessfulScreen
import com.example.ws_preparation.presentation.Wallet.components.ProfileScreen
import com.example.ws_preparation.presentation.Wallet.components.TrackScreen
import com.example.ws_preparation.presentation.Wallet.components.WalletScreen
import com.google.gson.Gson


@Composable
fun MainHomeNavGraph(
    mainNavHostController: NavHostController,
    startDestination: String,
) {
    NavHost(mainNavHostController, startDestination,
        modifier= Modifier.background(Color.White)) {
        composable(Route.MainScreen.route) {
            val viewModel: MainScreenViewModel = hiltViewModel()
           MainScreen(viewModel, mainNavHostController)
        }
        composable(Route.SendAPackageScreen.route) {
            val viewModel: SendAPackageViewModel = hiltViewModel()
            SendAPackageScreen(viewModel = viewModel, navController = mainNavHostController)
        }
        composable(Route.SendAPackageReceiptScreen.route) {
            val viewModel: SendAPackageReceiptViewModel = hiltViewModel()
            val dataJson = it.arguments?.getString("data")
            viewModel.setDataInit(Gson().fromJson(dataJson, PackageData::class.java))
            SendAPackageReceiptScreen(viewModel = viewModel, navController = mainNavHostController)

        }
        composable(Route.TransactionSuccessfulScreen.route) {
            val viewModel: TransactionSuccessfulViewModel = hiltViewModel()
            val uuid = it.arguments?.getString("uuid")
            viewModel.setUUID(uuid?:"")
            TransactionSuccessfulScreen(viewModel = viewModel, navController = mainNavHostController)
        }
        composable(Route.AddPaymentMethodScreen.route) {

        }
        composable(Route.NotificationScreen.route) {

        }

    }
}