package com.example.ws_preparation.presentation.AddPaymentMethod.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.presentation.common.CustomRadioButton
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun MethodItem(
    title: String,
    description: String,
    isSelectedMethod: Boolean,
    isSelectedCard: Int,
    cardList: List<String> = listOf(),

    onMethodClickListener: () -> Unit,
    onCardClickListener: (Int) -> Unit,
) {

    Card(modifier = Modifier.fillMaxWidth().clickable { onMethodClickListener() },
    colors = CardDefaults.cardColors(
        containerColor = Color.White
    ),
    elevation = CardDefaults.cardElevation(
        3.dp
    ),
    shape = RoundedCornerShape(0.dp)) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 9.5.dp, vertical = 24.dp)) {
            Row(
                Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomRadioButton(isSelected = isSelectedMethod)
                Spacer(modifier = Modifier.width(8.dp))
                Column() {
                    Text(text = title,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontFamily = FontFamily(Roboto),
                            fontWeight = FontWeight(400),
                            color = Text4
                        )
                    )
                    Text(text = description,
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            fontFamily = FontFamily(Roboto),
                            fontWeight = FontWeight(400),
                            color = Gray2
                        )
                    )
                }
            }
            if (cardList.isNotEmpty() && isSelectedMethod){
                repeat(cardList.size){
                    CardItem(isSelectedCard = it==isSelectedCard, title = cardList[it]){
                        onCardClickListener(it)
                    }
                }
            }
        }

    }
}