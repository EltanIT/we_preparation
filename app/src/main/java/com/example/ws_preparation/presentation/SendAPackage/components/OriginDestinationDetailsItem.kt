package com.example.ws_preparation.presentation.SendAPackage.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.presentation.common.CustomPackageTextField
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun OriginDestinationDetailsItem(
    icon: Int,
    title: String,

    value1: String,
    value2: String,
    value3: String,
    value4: String,

    hiltText1: String,
    hiltText2: String,
    hiltText3: String,
    hiltText4: String,

    onValue1ChangedListener: (String) -> Unit,
    onValue2ChangedListener: (String) -> Unit,
    onValue3ChangedListener: (String) -> Unit,
    onValue4ChangedListener: (String) -> Unit,

) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = icon), contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = title,
        style = TextStyle(
            fontSize = 14.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight(500),
            fontFamily = FontFamily(Roboto),
            color = Text4
        )
        )
    }
    Spacer(modifier = Modifier.height(4.dp))
    CustomPackageTextField(value = value1, hiltText = hiltText1, onChangedListener = {onValue1ChangedListener(it)})
    Spacer(modifier = Modifier.height(5.dp))
    CustomPackageTextField(value = value2, hiltText = hiltText2, onChangedListener = {onValue2ChangedListener(it)})
    Spacer(modifier = Modifier.height(5.dp))
    CustomPackageTextField(value = value3, hiltText = hiltText3, onChangedListener = {onValue3ChangedListener(it)})
    Spacer(modifier = Modifier.height(5.dp))
    CustomPackageTextField(value = value4, hiltText = hiltText4, onChangedListener = {onValue4ChangedListener(it)})
}