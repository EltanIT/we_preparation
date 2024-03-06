package com.example.ws_preparation.presentation.AddPaymentMethod.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.R
import com.example.ws_preparation.presentation.common.CustomRadioButton
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun CardItem(
    isSelectedCard: Boolean,
    title: String,
    onCardClickListener: () -> Unit
) {

    Card(modifier = Modifier.fillMaxWidth()
        .padding(top=8.dp)
        .clickable { onCardClickListener()},
    colors = CardDefaults.cardColors(
        containerColor = Color.White
    ),
    elevation = CardDefaults.cardElevation(
        3.dp
    ),
    shape = RoundedCornerShape(0.dp)) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 9.5.dp, vertical = 24.dp),
            verticalAlignment = Alignment.CenterVertically
                ) {
            CustomRadioButton(isSelected = isSelectedCard)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = title,
                modifier = Modifier.weight(1f),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = FontFamily(Roboto),
                    color = Text4
                )
            )
            Image(painter = painterResource(id = R.drawable.ic_delete), contentDescription = null)
        }
    }
}