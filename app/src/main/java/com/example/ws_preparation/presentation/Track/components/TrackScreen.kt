package com.example.ws_preparation.presentation.Wallet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.ws_preparation.domain.model.DeliveryData
import com.example.ws_preparation.presentation.Track.TrackViewModel
import com.example.ws_preparation.presentation.Track.components.TrackDeliveryInfo
import com.example.ws_preparation.presentation.Track.components.TrackMap
import com.example.ws_preparation.presentation.navgraph.Route
import com.example.ws_preparation.presentation.ui.theme.TransparentColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.android.gms.maps.model.LatLng


@Composable
fun TrackScreen(
    viewModel: TrackViewModel,
    navController: NavController
) {


    val uuid by remember{
        derivedStateOf {
            mutableStateOf(viewModel.uuid)
        }
    }

    val status by remember{
        derivedStateOf {
            mutableStateOf(viewModel.status)
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        TrackMap(
            originCoordinate = LatLng(0.0, 0.0),
            destinationCoordinates = listOf(LatLng(0.0, 0.0)))
        TrackDeliveryInfo(uuid = uuid.value, deliveryData = status.value){
            navController.navigate(Route.SendAPackage2Screen.route)
        }
    }


}