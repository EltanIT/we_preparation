package com.example.ws_preparation.presentation.activity.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.ws_preparation.presentation.navgraph.Onboard_AuthorizationNavGraph
import com.example.ws_preparation.presentation.ui.theme.Ws_preparationTheme
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
                val startDestination = remember{
                    viewModel.startDestination
                }
                val navController = rememberNavController()
                if (startDestination.isNotEmpty()){
                    Onboard_AuthorizationNavGraph(navHostController = navController, startDestination = startDestination)
                }

            }
        }
    }
}