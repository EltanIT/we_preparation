package com.example.ws_preparation.presentation.Home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.ws_preparation.R
import com.example.ws_preparation.presentation.Home.HomeViewModel
import com.example.ws_preparation.presentation.common.CustomTextFieldSearch
import com.example.ws_preparation.presentation.navgraph.Route
import com.example.ws_preparation.presentation.ui.theme.Roboto


@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navController: NavController
) {

    val profile by remember{
        derivedStateOf {
            mutableStateOf(viewModel.profile)
        }
    }

    val advertisement = viewModel.advertisement

    val search by remember{
        derivedStateOf {
            mutableStateOf(viewModel.search)
        }
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)) {
        Spacer(modifier = Modifier.height(24.dp))
        CustomTextFieldSearch(value = search.value, hiltText = "Search services", onChangedListener = {viewModel.redactSearch(it)})
        Spacer(modifier = Modifier.height(24.dp))

        HomeProfileRow(name = profile.value.fullName, image = profile.value.image) {
            navController.navigate(Route.NotificationScreen.route)
        }
        Spacer(modifier = Modifier.height(39.dp))

        Row(Modifier.fillMaxWidth()) {
            Text(text = "Special for you",
                modifier = Modifier.weight(1f),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Roboto),
                    fontWeight = FontWeight(500),
                    color = Color(0xffEC8000)
                )
            )
            Image(painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = null)
        }
        Spacer(modifier = Modifier.height(7.dp))
        LazyRow(){
            items(advertisement.size){
                Image(
                    modifier = Modifier.height(64.dp).width(166.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(1.dp, Color(0xffEC8000), RoundedCornerShape(8.dp)),
                    painter = rememberAsyncImagePainter(model = advertisement[it].image),
                    contentDescription = null)
            }

        }
        Spacer(modifier = Modifier.height(19.dp))
        Row(Modifier.fillMaxWidth()) {
            ActionHomeItem(
                modifier = Modifier.weight(1f),
                image = R.drawable.ic_customer_care,
                title = "Customer Care",
                description = "Our customer care service line is available from 8 -9pm week days and 9 - 5 weekends - tap to call us today")
            {}
            Spacer(modifier = Modifier.width(23.dp))
            ActionHomeItem(
                modifier = Modifier.weight(1f),
                image = R.drawable.ic_send_a_package,
                title = "Send a package",
                description = "Request for a driver to pick up or deliver your package for you")
            {
                navController.navigate(Route.SendAPackageScreen.route)
            }
        }
        Spacer(modifier = Modifier.height(23.dp))
        Row(Modifier.fillMaxWidth()) {
            ActionHomeItem(
                modifier = Modifier.weight(1f),
                image = R.drawable.ic_wallet,
                title = "Fund your wallet",
                description = "To fund your wallet is as easy as ABC, make use of our fast technology and top-up your wallet today")
            {}
            Spacer(modifier = Modifier.width(23.dp))
            ActionHomeItem(
                modifier = Modifier.weight(1f),
                image = R.drawable.ic_send_a_package,
                title = "Chats",
                description = "Search for available rider within your area")
            {
                navController.navigate(Route.ChatsScreen.route)
            }
        }


    }
}