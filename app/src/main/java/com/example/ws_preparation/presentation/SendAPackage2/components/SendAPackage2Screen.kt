package com.example.ws_preparation.presentation.Wallet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ws_preparation.presentation.SendAPackage2.SendAPackage2ViewModel
import com.example.ws_preparation.presentation.common.ChargesInformation
import com.example.ws_preparation.presentation.common.CustomTopAppBar
import com.example.ws_preparation.presentation.common.PackageInformation
import com.example.ws_preparation.presentation.navgraph.Route
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto


@Composable
fun SendAPackage2Screen(
    viewModel: SendAPackage2ViewModel,
    navController: NavController
) {

    val data by remember{
        derivedStateOf {
            mutableStateOf(viewModel.data)
        }
    }

    val stateSuccessful by remember{
        derivedStateOf {
            mutableStateOf(viewModel.stateSuccessful)
        }
    }

    if (stateSuccessful.value){
        navController.navigate(Route.DeliverySuccessfulScreen.route.replace("{order_id}", data.value.order_id))
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        CustomTopAppBar(title = "Send a package", isBackStack = true) {
            navController.popBackStack()
        }
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 24.dp)) {
            Spacer(modifier = Modifier.height(24.dp))
            PackageInformation(
                address = "${data.value.originDetails.address}, ${data.value.originDetails.phoneNumber}",
                number = data.value.originDetails.phoneNumber?:"",
                destinationDetails = data.value.destinationDetails,
                packageDetails = data.value.packageDetails,
                uuid = data.value.uuid
            )

            Spacer(modifier = Modifier.height(8.dp))
            ChargesInformation(chargesPackageData = data.value.chargesPackageData)
            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Click on  delivered for successful delivery and rate rider or report missing item",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = FontFamily(Roboto),
                    color = Color(0xff2F80ED)
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Button(onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .height(48.dp)
                        .border(1.dp, PrimaryColor, RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                    )) {
                    Text(text = "Report",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 16.sp,
                            fontFamily = FontFamily(Roboto),
                            fontWeight = FontWeight(700),
                            color = PrimaryColor
                        )
                    )
                }
                Spacer(modifier = Modifier.width(24.dp))
                Button(onClick = {
                    viewModel.successfulDelivery()},
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryColor,
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Successful",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 16.sp,
                            fontFamily = FontFamily(Roboto),
                            fontWeight = FontWeight(700),
                            color = Color.White
                        )
                    )
                }

            }
        }
    }



}