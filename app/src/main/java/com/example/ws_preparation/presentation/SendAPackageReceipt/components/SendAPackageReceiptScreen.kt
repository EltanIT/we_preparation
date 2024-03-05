package com.example.ws_preparation.presentation.SendAPackageReceipt.components

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
import com.example.ws_preparation.presentation.SendAPackageReceipt.SendAPackageReceiptViewModel
import com.example.ws_preparation.presentation.common.CustomTopAppBar
import com.example.ws_preparation.presentation.navgraph.Route
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto


@Composable
fun SendAPackageReceiptScreen(
    viewModel: SendAPackageReceiptViewModel,
    navController: NavController
) {

    val data by remember{
        derivedStateOf {
            mutableStateOf(viewModel.data)
        }
    }
    val statePost by remember{
        derivedStateOf {
            mutableStateOf(viewModel.statePost)
        }
    }

    if (statePost.value.equals("true")){
        navController.navigate(Route.TransactionSuccessfulScreen.route.replace("{uuid}", data.value.uuid))
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
            Spacer(modifier = Modifier.height(46.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                    Button(onClick = { navController.popBackStack() },
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .height(48.dp)
                            .border(1.dp, PrimaryColor, RoundedCornerShape(8.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )) {
                        Text(text = "Edit package",
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
                    viewModel.post()},
                    modifier = Modifier
                        .height(48.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryColor,
                    ),
                shape = RoundedCornerShape(8.dp)) {
                    Text(text = "Make payment",
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