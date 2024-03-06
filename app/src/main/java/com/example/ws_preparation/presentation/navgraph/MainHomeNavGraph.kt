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
import com.example.ws_preparation.presentation.AddPaymentMethod.AddPaymentMethodViewModel
import com.example.ws_preparation.presentation.AddPaymentMethod.components.AddPaymentMethodScreen
import com.example.ws_preparation.presentation.DeliverySuccessful.DeliverySuccessfulViewModel
import com.example.ws_preparation.presentation.DeliverySuccessful.components.DeliverySuccessfulScreen
import com.example.ws_preparation.presentation.Home.HomeScreen
import com.example.ws_preparation.presentation.MainScreen.MainScreenViewModel
import com.example.ws_preparation.presentation.MainScreen.components.MainScreen
import com.example.ws_preparation.presentation.SendAPackage.SendAPackageViewModel
import com.example.ws_preparation.presentation.SendAPackage.components.SendAPackageScreen
import com.example.ws_preparation.presentation.SendAPackage2.SendAPackage2ViewModel
import com.example.ws_preparation.presentation.SendAPackageReceipt.SendAPackageReceiptViewModel
import com.example.ws_preparation.presentation.SendAPackageReceipt.components.SendAPackageReceiptScreen
import com.example.ws_preparation.presentation.TransactionSuccessful.TransactionSuccessfulViewModel
import com.example.ws_preparation.presentation.TransactionSuccessful.components.TransactionSuccessfulScreen
import com.example.ws_preparation.presentation.Wallet.components.ProfileScreen
import com.example.ws_preparation.presentation.Wallet.components.SendAPackage2Screen
import com.example.ws_preparation.presentation.Wallet.components.TrackScreen
import com.example.ws_preparation.presentation.Wallet.components.WalletScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.gson.Gson


@Composable
fun MainHomeNavGraph(
    mainNavHostController: NavHostController,
    startDestination: String,
) {

    val systemUiController = rememberSystemUiController()

    NavHost(mainNavHostController, startDestination,
        modifier= Modifier.background(Color.White)) {
        composable(Route.MainScreen.route) {
            systemUiController.setStatusBarColor(
                color = Color.White
            )
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
            val viewModel: AddPaymentMethodViewModel = hiltViewModel()
            AddPaymentMethodScreen(viewModel = viewModel, navController = mainNavHostController)
        }
        composable(Route.NotificationScreen.route) {

        }
        composable(Route.SendAPackage2Screen.route) {
            val viewModel: SendAPackage2ViewModel = hiltViewModel()
            SendAPackage2Screen(viewModel = viewModel, navController = mainNavHostController)
        }
        composable(Route.DeliverySuccessfulScreen.route) {
            val id = it.arguments?.getString("order_id")
            val viewModel: DeliverySuccessfulViewModel = hiltViewModel()
            viewModel.setOrder(id?:"")
            DeliverySuccessfulScreen(viewModel = viewModel, navController = mainNavHostController)
        }

    }
}