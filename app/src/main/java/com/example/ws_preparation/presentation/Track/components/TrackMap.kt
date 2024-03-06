package com.example.ws_preparation.presentation.Track.components

import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.maps.model.LatLng


@Composable
fun TrackMap(
    originCoordinate: LatLng,
    destinationCoordinates: List<LatLng>
) {


    AndroidView(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.379f),
        factory = {
            WebView(it).apply {
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                settings.cacheMode = WebSettings.LOAD_NO_CACHE
            }
    },
    update = {
        if (destinationCoordinates.isNotEmpty()){
            var destinationText = ""
            for (i in 0..destinationCoordinates.size-1){
                destinationText += "~${destinationCoordinates[i].latitude}%2C${destinationCoordinates[i].longitude}"
            }
            val url ="https://yandex.ru/maps/?ll=${originCoordinate.latitude}%2C${originCoordinate.longitude}"+
                    "&mode=routes&rtext=${originCoordinate.latitude}%2C${originCoordinate.longitude}${destinationText}&rtt=auto&z=14"
            it.loadUrl(url)

        }else{
            it.loadUrl("https://yandex.ru/maps/?ll=${originCoordinate.latitude}%2C${originCoordinate.longitude}")
        }
    })


}