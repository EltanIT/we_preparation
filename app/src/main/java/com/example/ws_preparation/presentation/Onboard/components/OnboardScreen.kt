package com.example.ws_preparation.presentation.Onboard.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
    val page = remember{
        viewModel.page
    }

    val buttonState = remember{
        viewModel.buttonState
    }

    val skipState = remember{
        viewModel.skipState
    }


    if (skipState){
        navController.navigate(Route.SignUpScreen.route)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 60.dp, bottom = 64.dp)) {
        TopPart(image = page.image)
        CenterPart(title = page.title, description = page.description)
        ButtonPart(
            buttonState = buttonState ,
            skipText = "Skip",
            onSkipClicked = { viewModel.skipQueue() },
            onNextClicked = {
                if (buttonState.equals("Sign Up")){
                    navController.navigate(Route.SignUpScreen.route)
                }else{
                    viewModel.getNextPage()
                }

            }) {
                navController.navigate(Route.SignInScreen.route)
        }

    }


}