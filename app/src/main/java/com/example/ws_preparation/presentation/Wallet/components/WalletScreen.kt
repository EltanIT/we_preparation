package com.example.ws_preparation.presentation.Wallet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ws_preparation.presentation.Wallet.WalletViewModel
import com.example.ws_preparation.presentation.common.CustomTopAppBar
import com.example.ws_preparation.presentation.common.ProfileRow
import com.example.ws_preparation.presentation.navgraph.Route
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4
import com.example.ws_preparation.presentation.ui.theme.TransparentColor


@Composable
fun WalletScreen(
    viewModel: WalletViewModel,
    navController: NavController
) {

    val profile by remember{
        derivedStateOf {
            mutableStateOf(viewModel.profile)
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        CustomTopAppBar(title = "Wallet", isBackStack = false) {}
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .background(TransparentColor)) {
            ProfileRow(name = profile.value.fullName, image = profile.value.image,
                balance = profile.value.balance,
                padding = PaddingValues(top=48.5.dp)) {

            }
            Spacer(modifier = Modifier.height(35.dp))
            TopUp {
                navController.navigate(Route.AddPaymentMethodScreen.route)
            }
            Spacer(modifier = Modifier.height(41.dp))
            Text(text = "Transaction History",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily(Roboto),
                    color = Text4
                )
            )
            Spacer(modifier = Modifier.height(24.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()
                ){
                items(10){
                    TransactionItem(price = "N10000",
                        description = "fdsaf",
                        date = "14 fsad, fdas",
                        isTrue = true)
                    Spacer(modifier = Modifier.height(12.dp))
                }

            }

        }
    }
}