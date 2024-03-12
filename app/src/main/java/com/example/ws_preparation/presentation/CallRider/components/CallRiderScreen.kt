package com.example.ws_preparation.presentation.CallRider.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.ws_preparation.R
import com.example.ws_preparation.presentation.CallRider.CallRiderViewModel
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.Gray6
import com.example.ws_preparation.presentation.ui.theme.HiltTextColor
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun CallRiderScreen(
    viewModel: CallRiderViewModel,
    navController: NavController,
) {

    val profile by remember{
        derivedStateOf {
            mutableStateOf(viewModel.profile)
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceAround) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = rememberAsyncImagePainter(model = profile.value.image),
                contentDescription = null,
            modifier = Modifier
                .size(84.dp)
                .clip(CircleShape)
                .border(1.dp, HiltTextColor, CircleShape),
            contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.height(9.33.dp))
            Text(text = profile.value.fullName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    fontSize = 18.67.sp,
                    lineHeight = 18.67.sp,
                    fontFamily = FontFamily(Roboto),
                    fontWeight = FontWeight(700),
                    color = PrimaryColor
                )
            )
            Spacer(modifier = Modifier.height(9.33.dp))
            Text(text = "+" + profile.value.phoneNumber,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    fontSize = 18.67.sp,
                    lineHeight = 18.67.sp,
                    fontFamily = FontFamily(Roboto),
                    fontWeight = FontWeight(700),
                    color = Gray2
                )
            )
            Spacer(modifier = Modifier.height(9.33.dp))
            Text(text = "calling...",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 18.67.sp,
                    fontFamily = FontFamily(Roboto),
                    fontWeight = FontWeight(400),
                    color = PrimaryColor
                )
            )
        }

        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        shape = RoundedCornerShape(8.12.dp),
        elevation = CardDefaults.cardElevation(
            0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Gray6
        )) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 55.15.dp, vertical = 49.14.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
                Row(Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                    Image(painter = painterResource(id = R.drawable.ic_add), contentDescription = null)
                    Image(painter = painterResource(id = R.drawable.ic_pause), contentDescription = null)
                    Image(painter = painterResource(id = R.drawable.ic_video), contentDescription = null)
                }
                Spacer(modifier = Modifier.height(43.12.dp))
                Row(Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Image(painter = painterResource(id = R.drawable.ic_volum), contentDescription = null)
                    Image(painter = painterResource(id = R.drawable.ic_micro_off), contentDescription = null)
                    Image(painter = painterResource(id = R.drawable.ic_keypad_outline), contentDescription = null)
                }
                Spacer(modifier = Modifier.height(56.16.dp))
                Image(painter = painterResource(id = R.drawable.ic_call_off), contentDescription = null,
                modifier = Modifier.clickable { navController.popBackStack() })
            }
        }
    }
}