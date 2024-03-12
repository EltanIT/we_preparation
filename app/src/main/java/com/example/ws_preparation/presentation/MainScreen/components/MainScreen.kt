package com.example.ws_preparation.presentation.MainScreen.components

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
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
import androidx.navigation.compose.rememberNavController
import com.example.ws_preparation.presentation.MainScreen.MainScreenViewModel
import com.example.ws_preparation.presentation.navgraph.HomeNavGraph
import com.example.ws_preparation.presentation.navgraph.Route
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel,
    mainNavController: NavController,
) {
    
    val navController = rememberNavController()

    val navigationList = viewModel.navigationList

    val selectedIndex by remember{
        derivedStateOf {
            mutableStateOf(viewModel.selectedIndex)
        }
    }


    Scaffold(Modifier.fillMaxSize(),
        containerColor = Color.White,
    bottomBar = {
        Card(modifier = Modifier
            .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 25.dp
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )) {
            Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround) {
                repeat(navigationList.size){index ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable {
                            viewModel.redactSelectedIndex(index)
                            navController.navigate(navigationList[index].title)
                        }
                    ) {
                        if (selectedIndex.value == index){
                            Spacer(modifier = Modifier
                                .height(2.dp)
                                .width(35.dp)
                                .background(PrimaryColor))
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Image(painter = painterResource(
                            id = if (selectedIndex.value==index) navigationList[index].selectedImage else
                            navigationList[index].unselectedImage), contentDescription = null)
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(text = navigationList[index].title,
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 14.06.sp,
                            fontFamily = FontFamily(Roboto),
                            fontWeight = FontWeight(400),
                            color = if (selectedIndex.value==index) PrimaryColor else Gray2
                        )
                        )
                        Spacer(modifier = Modifier.height(9.dp))

                    }
                }

            }
        }
        
    }) {
        HomeNavGraph(
            navHostController = navController,
            mainNavHostController = mainNavController,
            startDestination = Route.HomeScreen.route,
            it)
    }
}