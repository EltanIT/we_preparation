package com.example.ws_preparation.presentation.activity.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.ws_preparation.presentation.navgraph.Onboard_AuthorizationNavGraph
import com.example.ws_preparation.presentation.ui.theme.Ws_preparationTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        setContent {
            val viewModel: MainActivityViewModel = hiltViewModel()

            Ws_preparationTheme(
                darkTheme = false
            ) {
                val systemUiController = rememberSystemUiController()
                systemUiController.setStatusBarColor(
                    color = Color.White
                )

                val startDestination by remember{
                    derivedStateOf {
                        mutableStateOf(viewModel.startDestination)
                    }
                }

                val navController = rememberNavController()
                if (startDestination.value.isNotEmpty()){
                    Onboard_AuthorizationNavGraph(navHostController = navController, startDestination = startDestination.value)
                }
            }
        }
    }
}