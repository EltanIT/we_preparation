package com.example.ws_preparation.presentation.TransactionSuccessful.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ws_preparation.R
import com.example.ws_preparation.presentation.TransactionSuccessful.TransactionSuccessfulViewModel
import com.example.ws_preparation.presentation.navgraph.Route
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun TransactionSuccessfulScreen(
    viewModel: TransactionSuccessfulViewModel,
    navController: NavController
) {

    val uuid = viewModel.uuid

    val isSuccessful by remember{
        derivedStateOf {
            mutableStateOf(viewModel.isSuccessful)
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.ic_loading), contentDescription = null,
        modifier = Modifier.size(119.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (isSuccessful.value){
                Text(text = "Instant delivery",
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 30.sp,
                        fontFamily = FontFamily(Roboto),
                        fontWeight = FontWeight(500),
                        color = Text4
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Your rider is on the way to your destination",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Roboto),
                    fontWeight = FontWeight(400),
                    color = Text4
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Tracking Number $uuid",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Roboto),
                    fontWeight = FontWeight(500),
                    color = Text4,
                    textAlign = TextAlign.Center
                )
            )
        }
        Column() {
            Button(onClick = {navController.navigate(Route.MainScreen.route)},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryColor
            )) {
                Text(text = "Track my item",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Roboto),
                        fontWeight = FontWeight(700),
                        color = Color.White
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {navController.navigate(Route.MainScreen.route)},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp)
                    .border(1.dp, PrimaryColor, RoundedCornerShape(4.dp)),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                )) {
                Text(text = "Go back to homepage",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Roboto),
                        fontWeight = FontWeight(700),
                        color = PrimaryColor
                    )
                )
            }
        }
    }
}