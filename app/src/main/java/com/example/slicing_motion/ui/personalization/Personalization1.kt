package com.example.slicing_motion.ui.personalization

import android.provider.MediaStore
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slicing_motion.R

@Composable
@Preview
fun Personalization1() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF093731))    ) {
        // --- TOP BAR SECTION ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(26.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(56.dp)
                    .background(Color(0xFF35504B), RoundedCornerShape(16.dp))
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "1/3",
                    style = TextStyle(color = Color.White, fontSize = 14.sp)
                )
                Spacer(Modifier.size(12.dp))
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF35504B)),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(12.dp),
                ) {
                    Text(text = "Lewati", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Yuk Jawab Biar HydropoMe Tahu Kebutuhanmu \uD83D\uDC9A",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

        Spacer(Modifier.height(48.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(Color.White)

        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                item {
                    Column(modifier = Modifier.padding(16.dp)) {
                        QuestionHeader("Apakah kamu pernah mencoba menanam hidroponik sebelumnya?")

                        Spacer(modifier = Modifier.height(16.dp))

                        val q1Options = listOf(
                            "Belum pernah",
                            "Pernah tapi masih pemula",
                            "Sudah cukup berpengalaman"
                        )

                        var selectedOption1 by remember { mutableStateOf("") }

                        q1Options.forEach { option ->
                            OptionItem(
                                text = option,
                                selected = selectedOption1 == option,
                                onClick = { selectedOption1 = option }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun QuestionHeader(text : String){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color(0xFFE8F5F2), CircleShape)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.eco_fill),
                contentDescription = null,
                tint = Color(0xFF179778),
                modifier = Modifier.size(24.dp)
            )

        }
            Spacer(Modifier.size(12.dp))

        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 22.sp
            ),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun OptionItem(text: String, selected : Boolean, onClick: () -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF7F8F9))
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
