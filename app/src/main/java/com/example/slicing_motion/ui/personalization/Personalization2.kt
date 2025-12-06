package com.example.slicing_motion.ui.personalization

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
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slicing_motion.R

@Composable
@Preview(device = "spec:width=1080px,height=4340px,dpi=440")
fun Personalization2(
    onBackClick: () -> Unit = {},
    onNextClick: () -> Unit = {},
    onSkipClick: () -> Unit = {}
) {
    var experience by remember {mutableStateOf("")}
    var goals by remember { mutableStateOf("") }

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
                onClick = {onBackClick()},
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
                    text = "2/3",
                    style = TextStyle(color = Color.White, fontSize = 14.sp)
                )
                Spacer(Modifier.size(12.dp))
                Button(
                    onClick = { onSkipClick },
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
                verticalArrangement = Arrangement.spacedBy(34.dp)
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(10.dp,RoundedCornerShape(24.dp))
                            .background(Color.White)
                            .padding(10.dp)

                    ) {
                        QuestionHeader("Jenis tanaman apa saja yang ingin kamu tanam?")

                        Spacer(modifier = Modifier.height(16.dp))
                        var selectedPlants by remember { mutableStateOf(setOf<String>()) }

                        val plantOptions = listOf(
                            "Sayuran daun (misalnya selada, bayam)",
                            "Buah (misalnya tomat, stroberi)",
                            "Tanaman herbal",
                            "Belum tahu / ingin rekomendasi"
                        )


                        Column(modifier = Modifier.padding(16.dp)) {
                            plantOptions.forEach { plant ->
                                CheckItem(
                                    text = plant,
                                    // Check if this specific item is in our set
                                    checked = selectedPlants.contains(plant),
                                    onCheckedChange = {
                                        // Logic: If selected, remove it. If not, add it.
                                        selectedPlants = if (selectedPlants.contains(plant)) {
                                            selectedPlants - plant
                                        } else {
                                            selectedPlants + plant
                                        }
                                    }
                                )
                            }
                        }
                    }
                }

                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(10.dp,RoundedCornerShape(24.dp))
                            .background(Color.White)
                            .padding(10.dp)
                    ) {
                        QuestionHeader("Berapa  waktu yang bisa diluangkan per hari untuk merawat tanaman?")

                        Spacer(modifier = Modifier.height(16.dp))

                        val q2Options = listOf(
                            "< 10 menit",
                            "10–30 menit",
                            "> 30 menit",
                        )

                        var selectedOption2 by remember { mutableStateOf("") }

                        q2Options.forEach { option ->
                            OptionItem(
                                text = option,
                                selected = selectedOption2 == option,
                                onClick = { selectedOption2 = option }
                            )
                        }
                    }
                }

                item {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .shadow(10.dp,RoundedCornerShape(24.dp))
                        .background(Color.White)
                        .padding(10.dp)) {
                        QuestionHeader("Di mana kamu akan menanam tanaman hidroponik?")

                        Spacer(modifier = Modifier.height(16.dp))

                        val q2Options = listOf(
                            "Dalam ruangan",
                            "Luar Ruangan   ",
                            "Balkon atau teras",
                        )

                        var selectedOption2 by remember { mutableStateOf("") }

                        q2Options.forEach { option ->
                            OptionItem(
                                text = option,
                                selected = selectedOption2 == option,
                                onClick = { selectedOption2 = option }
                            )
                        }
                    }
                }

                item {
                    Spacer(Modifier.height(24.dp))
                    Button(
                        onClick = { onNextClick() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(46.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF179778))
                    ) {
                        Text(
                            text = "Selanjutnya",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}




