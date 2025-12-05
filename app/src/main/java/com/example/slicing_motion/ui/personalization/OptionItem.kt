package com.example.slicing_motion.ui.personalization

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OptionItem(text: String, selected : Boolean, onClick: () -> Unit){
    val mainGreen = Color(0xFF179778)
    val selectedBackground = Color(0xFFE8F5F2)
    val unselectedBackground = Color(0xFFF7F8F9)

    val backgroundColor = if (selected) selectedBackground else unselectedBackground;
    val borderColor = if (selected) mainGreen else Color.Transparent

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .border(1.dp, borderColor, RoundedCornerShape(12.dp))
            .clickable{ onClick() }
            .padding(vertical = 12.dp, horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        RadioButton(
            selected = selected,
            onClick = null,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color(0xFF179778),
                unselectedColor = Color.LightGray
            )
        )

        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
            )
        )
    }
}