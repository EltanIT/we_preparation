package com.example.ws_preparation.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.rememberNavController
import com.example.ws_preparation.presentation.navgraph.MainHomeNavGraph
import com.example.ws_preparation.presentation.navgraph.Route
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity: ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapKitFactory.setApiKey("08bfcad4-f93e-4bd0-902f-8e210fa902eb")
        MapKitFactory.initialize(this)

        setContent {
            val navController = rememberNavController()
            MainHomeNavGraph(mainNavHostController = navController, startDestination = Route.MainScreen.route)
        }
    }
}