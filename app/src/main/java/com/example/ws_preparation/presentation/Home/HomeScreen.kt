package com.example.ws_preparation.presentation.Home

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.ws_preparation.presentation.navgraph.Route


@Composable
fun HomeScreen(
    navController: NavController
) {

    Button(onClick = {navController.navigate(Route.SendAPackageScreen.route)}) {
        Text(text = "Send a package")
    }
}