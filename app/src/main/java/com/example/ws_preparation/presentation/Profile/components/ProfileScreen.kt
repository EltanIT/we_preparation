package com.example.ws_preparation.presentation.Wallet.components

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Switch
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
import com.example.ws_preparation.presentation.Profile.ProfileViewModel
import com.example.ws_preparation.presentation.common.CustomTopAppBar
import com.example.ws_preparation.presentation.common.ProfileRow
import com.example.ws_preparation.presentation.navgraph.Route
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4
import com.example.ws_preparation.presentation.ui.theme.TransparentColor


@Composable
fun ProfileScreen(
        viewModel: ProfileViewModel,
        navController: NavController
) {

    val actionList = viewModel.actionsList

    val isDarkMod by remember{
        derivedStateOf {
            mutableStateOf(viewModel.isDarkMod)
        }
    }

    val profile by remember{
        derivedStateOf {
            mutableStateOf(viewModel.profile)
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        CustomTopAppBar(title = "Profile", isBackStack = false) {}
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 24.dp)) {
            Spacer(modifier = Modifier.height(34.5.dp))
            ProfileRow(name = profile.value.fullName, image = 0, balance = profile.value.fullName) {
                
            }
            Spacer(modifier = Modifier.height(26.5.dp).background(TransparentColor))
            Row(Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Enable dark Mode",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Roboto),
                        fontWeight = FontWeight(500),
                        color = Text4
                    )
                )
                Switch(checked = isDarkMod.value, onCheckedChange = {viewModel.redactDarkMod()})
            }
            Spacer(modifier = Modifier.height(19.dp))
            Column(Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly) {
                repeat(actionList.size){
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            when (it) {
                                3 -> {
                                    navController.navigate(Route.AddPaymentMethodScreen.route)
                                }
                            }
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 10.dp
                        ),
                    shape = RoundedCornerShape(0.dp)) {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 13.dp),
                        verticalAlignment = Alignment.CenterVertically) {
                            Image(painter = painterResource(id = actionList[it].icon),
                                contentDescription = null,
                            )
                            Spacer(modifier = Modifier.width(9.dp))
                            Column(Modifier.weight(1f)) {
                                Text(text = actionList[it].title,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        lineHeight = 16.sp,
                                        fontFamily = FontFamily(Roboto),
                                        fontWeight = FontWeight(500),
                                        color = Text4
                                    )
                                )
                                if (actionList[it].description.isNotEmpty()){
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(text = actionList[it].description,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            lineHeight = 16.sp,
                                            fontFamily = FontFamily(Roboto),
                                            fontWeight = FontWeight(400),
                                            color = Gray2
                                        )
                                    )
                                }

                            }
                            Image(painter = painterResource(id = R.drawable.ic_vector),
                                contentDescription = null,
                            )

                        }
                    }
                }
            }


        }
        
    }

}