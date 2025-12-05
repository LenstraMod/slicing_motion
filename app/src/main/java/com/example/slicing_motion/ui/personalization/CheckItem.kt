package com.example.slicing_motion.ui.personalization

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
@Preview
fun CheckItem(
    text: String = "",
    checked: Boolean = false,
    onCheckedChange: () -> Unit = {}
){
    val mainGreen = Color(0xFF179778)
    val lightGreen = Color(0xFFE8F5F2)
    val grayBackground = Color(0xFFF7F8F9)

    val backgroundColor = if (checked) lightGreen else grayBackground
    val containerBorderColor = if (checked) mainGreen else Color.Transparent

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .border(1.dp,containerBorderColor, RoundedCornerShape(12.dp))
            .clickable{}
      ,
        verticalAlignment = Alignment.CenterVertically
    ){
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChange() },
            colors = CheckboxDefaults.colors(
                checkedColor = mainGreen,
                uncheckedColor = Color.LightGray
            ),
        )

        Text(
            text = text,
            color = Color.Black
        )
    }
}