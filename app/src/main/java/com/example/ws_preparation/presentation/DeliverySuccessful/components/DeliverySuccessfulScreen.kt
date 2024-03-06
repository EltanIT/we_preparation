package com.example.ws_preparation.presentation.DeliverySuccessful.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ws_preparation.R
import com.example.ws_preparation.presentation.DeliverySuccessful.DeliverySuccessfulViewModel
import com.example.ws_preparation.presentation.common.CustomExceptionDialogAlert
import com.example.ws_preparation.presentation.navgraph.Route
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@ExperimentalMaterial3Api
@Composable
fun DeliverySuccessfulScreen(
    viewModel: DeliverySuccessfulViewModel,
    navController: NavController
) {

    val context = LocalContext.current

    viewModel.rotateInit(context)

    val isSuccessful by remember{
        derivedStateOf {
            mutableStateOf(viewModel.isSuccessful)
        }
    }

    val comment by remember{
        derivedStateOf {
            mutableStateOf(viewModel.comment)
        }
    }

    val rating by remember{
        derivedStateOf {
            mutableStateOf(viewModel.rating)
        }
    }

    val exception by remember{
        derivedStateOf {
            mutableStateOf(viewModel.exception)
        }
    }

    if (exception.value.equals("true")){
        navController.navigate(Route.MainScreen.route)
    }else if (exception.value.isNotEmpty()){
        CustomExceptionDialogAlert(exception = exception.value) {
            viewModel.defaultException()

        }
    }

    val infinitiPolice = rememberInfiniteTransition()
    val angle by infinitiPolice.animateFloat(initialValue = 0f, targetValue = -360f, animationSpec = infiniteRepeatable(
        animation = tween(2000, 1000, LinearEasing),
        repeatMode = RepeatMode.Restart
    ))

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        if (isSuccessful.value){
            Image(painter = painterResource(id = R.drawable.ic_successful), contentDescription = null)
        }else{
            Image(painter = painterResource(id = R.drawable.ic_loading), contentDescription = null,
                modifier = Modifier
                    .size(119.dp)
                    .rotate(angle))
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.height(54.dp)) {
            if (isSuccessful.value){
                Text(text = "Delivery Successful",
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 30.sp,
                        fontFamily = FontFamily(Roboto),
                        fontWeight = FontWeight(500),
                        color = Text4
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Your Item has been delivered successfully",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Roboto),
                        fontWeight = FontWeight(400),
                        color = Text4
                    )
                )
            }
        }

        Column(Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Rate Rider",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Roboto),
                    fontWeight = FontWeight(400),
                    color = Color(0xff0560FA)
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomRating(countActiveStars = rating.value)
            Spacer(modifier = Modifier.height(36.59.dp))

            BasicTextField(value = comment.value, onValueChange = {viewModel.redactComment(it)},
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Roboto),
                    fontWeight = FontWeight(400),
                    color = Text4
                ),
                decorationBox = {
                    Card(modifier = Modifier.fillMaxSize(),
                    elevation = CardDefaults.cardElevation(
                        4.dp
                    ),
                    shape = RoundedCornerShape(0.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )) {

                    }
                    Row(
                        Modifier
                            .fillMaxSize()
                            .padding(start = 12.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                        Image(painter = painterResource(id = R.drawable.ic_comment), contentDescription = null)
                        Box(
                            Modifier
                                .fillMaxSize()
                                .padding(horizontal = 12.dp),
                        contentAlignment = Alignment.CenterStart){
                            if (comment.value.isEmpty()){
                                Text(text = "Add feedback",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 16.sp,
                                        fontFamily = FontFamily(Roboto),
                                        fontWeight = FontWeight(400),
                                        color = Gray2
                                    )
                                )
                            }
                            it()
                        }
                    }
                }
            )
        }
        Button(onClick = {
            viewModel.postComment()

                         },
            modifier = Modifier
                .fillMaxWidth()
                .height(46.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryColor
            )) {
            Text(text = "Done",
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