package com.example.ws_preparation.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ws_preparation.presentation.Onboard.OnboardViewModel
import com.example.ws_preparation.presentation.Onboard.components.OnboardScreen
import com.example.ws_preparation.presentation.SignUp.components.SignUpScreen

@Composable
fun Onboard_AuthorizationNavGraph(
    navHostController: NavHostController,
    startDestination: String,
) {

    NavHost(navHostController, startDestination){
        composable(Route.OnboardScreen.route){
            val viewModel: OnboardViewModel = hiltViewModel()
            OnboardScreen(viewModel = viewModel, navController = navHostController)
        }
        composable(Route.SignUpScreen.route){
            SignUpScreen()
        }
        composable(Route.SignInScreen.route){

        }
    }
}