package com.example.ws_preparation.presentation.AddPaymentMethod.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.ws_preparation.presentation.AddPaymentMethod.AddPaymentMethodViewModel
import com.example.ws_preparation.presentation.common.CustomTopAppBar
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun AddPaymentMethodScreen(
    viewModel: AddPaymentMethodViewModel,
    navController: NavController
) {

    val methodList by remember{
        derivedStateOf {
            mutableStateOf(viewModel.methodList)
        }
    }

    val selectedMethod by remember{
        derivedStateOf {
            mutableStateOf(viewModel.selectedMethod)
        }
    }

    val selectedCard by remember{
        derivedStateOf {
            mutableStateOf(viewModel.selectedCard)
        }
    }




    Column(Modifier.fillMaxSize()) {
        CustomTopAppBar(title = "Add Payment method", isBackStack = true) {
            navController.popBackStack()
        }
        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 67.dp, start = 24.dp, end = 24.dp, bottom = 105.dp),
        verticalArrangement = Arrangement.SpaceBetween) {
            Column() {
                repeat(methodList.value.size){index ->
                    MethodItem(title = methodList.value[index].title,
                        description = methodList.value[index].description,
                        isSelectedMethod = index==selectedMethod.value,
                        isSelectedCard = selectedCard.value,
                        cardList = if (index == 1) listOf("**** **** 3323", "**** **** 1547") else listOf(),
                        onMethodClickListener = {viewModel.redactMethod(index)}){
                        viewModel.redactCard(it)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
           
            
            Button(onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryColor
            ),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .height(46.dp)
                .fillMaxWidth()) {
                Text(text = "Proceed to pay",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Roboto),
                        fontWeight = FontWeight(700),
                        color = Color.White
                    )
                )
            }
        }
    }
}