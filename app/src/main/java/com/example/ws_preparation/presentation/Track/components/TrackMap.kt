package com.example.ws_preparation.presentation.Track.components

import android.graphics.ColorSpace
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.ws_preparation.R
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.RequestPoint
import com.yandex.mapkit.RequestPointType
import com.yandex.mapkit.directions.DirectionsFactory
import com.yandex.mapkit.directions.driving.DrivingOptions
import com.yandex.mapkit.directions.driving.DrivingRoute
import com.yandex.mapkit.directions.driving.DrivingRouterType
import com.yandex.mapkit.directions.driving.DrivingSession.DrivingRouteListener
import com.yandex.mapkit.directions.driving.VehicleOptions
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.Error
import com.yandex.runtime.image.ImageProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun rememberMapViewWithLifecycle(): MapView {
    val context = LocalContext.current
    val mapView = remember{
        MapView(context).apply {
            id = R.id.mapview
        }
    }
    val lifecycleObserver = rememberMapLifecycleObserver(mapView)
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(lifecycle){
        lifecycle.addObserver(lifecycleObserver)
        onDispose {
            lifecycle.removeObserver(lifecycleObserver)
        }
    }

    return mapView
}

@Composable
fun rememberMapLifecycleObserver(mapView: MapView): LifecycleEventObserver =
    remember(mapView) {
        LifecycleEventObserver{_, event ->
            when(event){
                Lifecycle.Event.ON_START ->{
                    MapKitFactory.getInstance().onStart()
                    mapView.onStart()
                }
                Lifecycle.Event.ON_STOP -> {
                    MapKitFactory.getInstance().onStop()
                    mapView.onStop()
                }
                else -> {}
            }
        }
    }


@Composable
fun TrackMap(
    originCoordinate: Point,
    destinationCoordinates: List<Point>
) {
    val mapView = rememberMapViewWithLifecycle()
    val context = LocalContext.current

    val drivingRouter = DirectionsFactory.getInstance().createDrivingRouter(DrivingRouterType.ONLINE)
    val drivingOptions = DrivingOptions().apply {
        routesCount = 2
    }
    val vehicleOptions = VehicleOptions()

    val points = buildList {
        add(RequestPoint(originCoordinate, RequestPointType.WAYPOINT, null, null))
        add(RequestPoint(destinationCoordinates[0], RequestPointType.WAYPOINT, null, null))
    }
    
    
    AndroidView(
        {mapView},
        modifier = Modifier
            .fillMaxHeight(0.379f)
            .fillMaxWidth()
    ){mapview ->
        CoroutineScope(Dispatchers.Main).launch{
            mapview.map.move(
                CameraPosition(
                    originCoordinate,
                    15f,
                    0f,
                    0f
                )
            )

            val placemarkIcon = ImageProvider.fromResource(context.applicationContext, R.drawable.ic_placemark)

           mapView.map.mapObjects.addPlacemark().apply {
                geometry = originCoordinate
                setIcon(placemarkIcon)
            }

            for (i in destinationCoordinates){
                mapView.map.mapObjects.addPlacemark().apply {
                    geometry = i
                    setIcon(placemarkIcon)
                }
            }

            drivingRouter.requestRoutes(
                points,
                drivingOptions,
                vehicleOptions,
                object: DrivingRouteListener{
                    override fun onDrivingRoutes(routes: MutableList<DrivingRoute>) {
                        for (route in routes){
                            val line = mapView.map.mapObjects.addPolyline(route.geometry)
                            line.strokeWidth = 2f
                        }

                    }

                    override fun onDrivingRoutesError(p0: Error) {

                    }

                }
            )

        }

    }
    
    


//    AndroidView(
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight(0.379f),
//        factory = {
//            WebView(it).apply {
//                webViewClient = WebViewClient()
//                settings.javaScriptEnabled = true
//                settings.cacheMode = WebSettings.LOAD_NO_CACHE
//            }
//    },
//    update = {
//        if (destinationCoordinates.isNotEmpty()){
//            var destinationText = ""
//            for (i in 0..destinationCoordinates.size-1){
//                destinationText += "~${destinationCoordinates[i].latitude}%2C${destinationCoordinates[i].longitude}"
//            }
//            val url ="https://yandex.ru/maps/?ll=${originCoordinate.latitude}%2C${originCoordinate.longitude}"+
//                    "&mode=routes&rtext=${originCoordinate.latitude}%2C${originCoordinate.longitude}${destinationText}&rtt=auto&z=14"
//            it.loadUrl(url)
//
//        }else{
//            it.loadUrl("https://yandex.ru/maps/?ll=${originCoordinate.latitude}%2C${originCoordinate.longitude}")
//        }
//    })


}