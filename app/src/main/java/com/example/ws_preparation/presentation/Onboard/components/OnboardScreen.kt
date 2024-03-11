package com.example.ws_preparation.presentation.Onboard.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ws_preparation.presentation.Onboard.OnboardViewModel
import com.example.ws_preparation.presentation.navgraph.Route


@Composable
fun OnboardScreen(
    viewModel: OnboardViewModel,
    navController: NavController
) {
    val page by remember{
        derivedStateOf {
            mutableStateOf( viewModel.page)
        }
    }

    val nextText by remember{
        derivedStateOf {
            viewModel.nextText
        }

    }

    val skipState by remember{
        derivedStateOf {
            viewModel.skipState
        }

    }

    val signInState by remember{
        derivedStateOf {
            viewModel.signInState
        }

    }

    val isLastItem by remember{
        derivedStateOf {
            viewModel.isLastItem
        }

    }


    if (skipState){
        navController.popBackStack()
        navController.navigate(Route.SignUpScreen.route)
    }

    if (signInState){
        navController.popBackStack()
        navController.navigate(Route.SignInScreen.route)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 60.dp, bottom = 64.dp)) {
        TopPart(image = page.value.image,
        Modifier.fillMaxWidth().height(346.dp))
        Spacer(modifier = Modifier.height(48.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 24.dp).fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween) {
            CenterPart(title = page.value.title, description = page.value.description)
            ButtonPart(
                nextText = nextText,
                skipText = "Skip",
                isLastItem = isLastItem,
                onSkipClicked = { viewModel.skipQueue() },
                onNextClicked = {
                    if (nextText.equals("Sign Up")){
                        navController.popBackStack()
                        navController.navigate(Route.SignUpScreen.route)
                    }else{
                        viewModel.getNextPage()
                    }
                }) {
                viewModel.signIn()
            }
        }
    }
}