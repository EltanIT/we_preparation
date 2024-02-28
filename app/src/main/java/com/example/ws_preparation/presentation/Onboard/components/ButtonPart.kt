package com.example.ws_preparation.presentation.Onboard.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto


@Composable
fun ButtonPart(
    buttonState: String,
    skipText: String,
    onSkipClicked: () -> Unit,
    onNextClicked: () -> Unit,
    onSignInClicked: () -> Unit,
) {
    val buttonStateIsEnd = buttonState.equals("Sign Up")
    if (!buttonStateIsEnd){
        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { onSkipClicked },
            modifier = Modifier
                .height(50.dp)
                .width(100.dp)
                .clip(RoundedCornerShape(4.69.dp))
                .border(1.dp, PrimaryColor, shape = RoundedCornerShape(4.69.dp))
                .background(Color.White, shape = RoundedCornerShape(4.69.dp))) {
                Text(text = skipText,
                    style = TextStyle(
                        fontSize =14.sp,
                        fontFamily = FontFamily(Roboto),
                        fontWeight = FontWeight(700),
                        color = PrimaryColor
                    )
                )
            }

            Button(onClick = { onNextClicked() },
                modifier = Modifier
                    .height(50.dp)
                    .width(100.dp)
                    .clip(RoundedCornerShape(4.69.dp))
                    .background(PrimaryColor)) {
                Text(text = buttonState,
                    style = TextStyle(
                        fontSize =14.sp,
                        fontFamily = FontFamily(Roboto),
                        fontWeight = FontWeight(700),
                        color = Color.White
                    )
                )
            }
        }
    }else{
        Column(Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { onNextClicked() },
                modifier = Modifier
                    .height(50.dp)
                    .width(100.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(PrimaryColor)) {
                Text(text = buttonState,
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
    Spacer(modifier = Modifier.height(20.dp))
    Row(
        modifier = Modifier.alpha(if (!buttonStateIsEnd) 0f else 1f)
    ) {
        Text(text = "Already have an account?",
            modifier = Modifier.clickable { onNextClicked() },
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                color = Gray2
            )
        )
        Text(text = "Sign in",
            modifier = Modifier.clickable {
                if (buttonStateIsEnd){
                    onSignInClicked()
                }
                },
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(500),
                color = PrimaryColor
            )
        )
    }

}