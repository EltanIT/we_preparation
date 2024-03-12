package com.example.ws_preparation.presentation.ChatRider.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ws_preparation.R
import com.example.ws_preparation.data.network.SupabaseInit.client
import com.example.ws_preparation.presentation.ChatRider.ChatRiderViewModel
import com.example.ws_preparation.presentation.common.CustomTopChatBar
import com.example.ws_preparation.presentation.navgraph.Route
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4
import io.github.jan.supabase.gotrue.auth


@Composable
fun ChatRiderScreen(
    viewModel: ChatRiderViewModel,
    navController: NavController
) {

    val profile by remember{
        derivedStateOf {
            mutableStateOf(viewModel.profile)
        }
    }
    
    val messageHistory = viewModel.messagesHistory

    val message by remember{
        derivedStateOf {
            mutableStateOf(viewModel.message)
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        CustomTopChatBar(
            name = profile.value.fullName,
            image = profile.value.image,
            onBackClickListener = { navController.popBackStack() }) {
                navController.navigate(Route.CallRiderScreen.route.replace("{user_id}", viewModel.recipient_id))
        }
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .padding(horizontal = 24.dp)) {
            LazyColumn(Modifier.weight(1f)){
                items(messageHistory.size){
                    if (it==0){
                        Spacer(modifier = Modifier.height(30.dp))
                    }
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 2.dp)) {
                        Box(
                            Modifier
                                .fillMaxWidth(0.6f)
                                .align(
                                    if (messageHistory[it].recipient == viewModel.recipient_id) Alignment.CenterEnd
                                    else Alignment.CenterStart
                                )) {
                            Card(shape = RoundedCornerShape(8.dp),
                            elevation = CardDefaults.cardElevation(
                                0.dp
                            ),
                            colors = CardDefaults.cardColors(
                                if (messageHistory[it].recipient == viewModel.recipient_id) PrimaryColor else Color(0xffCFCFCF)
                            )) {
                                Text(text = messageHistory[it].message,
                                    modifier = Modifier.padding(10.dp),
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    fontFamily = FontFamily(Roboto),
                                    fontWeight = FontWeight(500),
                                    color =  if (messageHistory[it].recipient == viewModel.recipient_id) Color.White else Text4 
                                )
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 11.22.dp),
            verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_emoji),
                    contentDescription = null,)
                TextFieldMessage(value = message.value, 
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 6.5.dp),
                    hiltText = "Enter message", 
                    onChangedListener = {viewModel.redactMessage(it)})
                Image(
                    painter = painterResource(id = R.drawable.ic_send_message),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 4.8.dp)
                        .clickable {
                            viewModel.postMessage()
                        })
            }

        }
    }
}