package com.example.ws_preparation.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.ws_preparation.presentation.navgraph.MainHomeNavGraph
import com.example.ws_preparation.presentation.navgraph.Route
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MainHomeNavGraph(mainNavHostController = navController, startDestination = Route.MainScreen.route)
        }
    }
}