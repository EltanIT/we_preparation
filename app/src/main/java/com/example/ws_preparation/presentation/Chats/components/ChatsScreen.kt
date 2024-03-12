@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.ws_preparation.presentation.Chats.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ws_preparation.presentation.Chats.ChatsViewModel
import com.example.ws_preparation.presentation.common.CustomExceptionDialogAlert
import com.example.ws_preparation.presentation.common.CustomTextFieldSearch
import com.example.ws_preparation.presentation.common.CustomTopAppBar
import com.example.ws_preparation.presentation.navgraph.Route
import com.example.ws_preparation.presentation.ui.theme.TransparentColor


@Composable
fun ChatsScreen(
    viewModel: ChatsViewModel,
    navController: NavController
) {

    val list = viewModel.chatsList

    val exception by remember{
        derivedStateOf {
            mutableStateOf(viewModel.exception)
        }
    }

    if (exception.value.isNotEmpty()){
        CustomExceptionDialogAlert(exception = exception.value) {
            viewModel.defaultException()
        }
    }


    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        CustomTopAppBar(title = "Chats", isBackStack = true) {
            navController.popBackStack()
        }
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .background(TransparentColor)) {
            Spacer(modifier = Modifier.height(21.dp))
            CustomTextFieldSearch(value = "", hiltText = "Search for a driver", onChangedListener = {})
            Spacer(modifier = Modifier.height(27.dp))
            LazyColumn(){
                items(list.size){
                    ChatItem(
                        name = list[it].name?:"John Joshua",
                        lastMessage = list[it].lastMessage?:"Thanks for your service",
                        countMessage = list[it].countMessage?:1,
                        image = list[it].image?:""){
                        navController.navigate(Route.ChatsRiderScreen.route.replace("{user_id}", list[it].user_id?:""))
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

        }
    }
}