package com.example.ws_preparation.presentation.SendAPackage.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ws_preparation.R
import com.example.ws_preparation.presentation.SendAPackage.SendAPackageViewModel
import com.example.ws_preparation.presentation.common.CustomTopAppBar
import com.example.ws_preparation.presentation.navgraph.Route
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto


@Composable
fun SendAPackageScreen(
    viewModel: SendAPackageViewModel,
    navController: NavController
) {

    val originDetails by remember{
        derivedStateOf {
            mutableStateOf(viewModel.originDetails)
        }
    }
    val destinationDetails by remember{
        derivedStateOf {
            mutableStateOf(viewModel.destinationDetails)
        }
    }
    val packageDetails by remember{
        derivedStateOf {
            mutableStateOf(viewModel.packageDetails)
        }
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
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.height(43.dp))
            OriginDestinationDetailsItem(
                icon = R.drawable.ic_origin_details,
                title = "Origin Details",
                value1 = originDetails.value.address?:"",
                value2 = originDetails.value.state?:"",
                value3 = originDetails.value.phoneNumber?:"",
                value4 = originDetails.value.others?:"",
                hiltText1 = "Address",
                hiltText2 = "State,Country",
                hiltText3 = "Phone number",
                hiltText4 = "Others",
                onValue1ChangedListener = {viewModel.redactOriginAddress(it)},
                onValue2ChangedListener = {viewModel.redactOriginState(it)},
                onValue3ChangedListener = {viewModel.redactOriginPhoneNumber(it)},
                onValue4ChangedListener ={viewModel.redactOriginOthers(it)}
            )
            Spacer(modifier = Modifier.height(39.dp))
            repeat(destinationDetails.value.size){index ->
                OriginDestinationDetailsItem(
                    icon = R.drawable.ic_destination_details,
                    title = "Destination Details",
                    value1 = destinationDetails.value[index].address?:"",
                    value2 =destinationDetails.value[index].state?:"",
                    value3 = destinationDetails.value[index].phoneNumber?:"",
                    value4 = destinationDetails.value[index].others?:"",
                    hiltText1 = "Address",
                    hiltText2 = "State,Country",
                    hiltText3 = "Phone number",
                    hiltText4 = "Others",
                    onValue1ChangedListener = {viewModel.redactDestinationAddress(it, index)},
                    onValue2ChangedListener = {viewModel.redactDestinationState(it, index)},
                    onValue3ChangedListener = {viewModel.redactDestinationPhoneNumber(it, index)},
                    onValue4ChangedListener = {viewModel.redactDestinationOthers(it, index)}
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { viewModel.addDestination() }) {
                Image(painter = painterResource(id = R.drawable.ic_add_destination), contentDescription = null)
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = "Add destination",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Roboto),
                        fontWeight = FontWeight(400),
                        color = Gray2
                    )
                )
            }
            Spacer(modifier = Modifier.height(13.dp))
            PackageDetailsItem(
                title = "Package Details",
                value1 = packageDetails.value.packageItems?:"",
                value2 = packageDetails.value.weightItem?:"",
                value3 = packageDetails.value.worthItems?:"",
                hiltText1 = "package items",
                hiltText2 = "Weight of item(kg)",
                hiltText3 = "Worth of Items",
                onValue1ChangedListener = {viewModel.redactPackageItems(it)},
                onValue2ChangedListener = {viewModel.redactPackageWeight(it)} ,
                onValue3ChangedListener = {viewModel.redactPackageWorth(it)}
            )

            Spacer(modifier = Modifier.height(39.dp))
            Row(Modifier.fillMaxWidth()) {
                Card(
                modifier = Modifier
                    .height(75.dp)
                    .fillMaxWidth()
                    .clickable {
                        viewModel.createPackage()
                        navController.navigate(
                            Route.SendAPackageReceiptScreen.route.replace(
                                "{data}",
                                viewModel.getData()
                            )
                        )
                    },
                colors = CardDefaults.cardColors(
                    containerColor = PrimaryColor
                ),
                    shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                )) {
                    Column(Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly) {
                        Image(painter = painterResource(id = R.drawable.ic_clock), contentDescription = null)
                        Text(text = "Instant delivery",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 16.sp,
                                fontFamily = FontFamily(Roboto),
                                fontWeight = FontWeight(500),
                                color = Color.White
                            )
                        )
                    }

                }
            }
            
        }
    }

    
}