package com.example.slicing_motion.ui.pantautanaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.slicing_motion.R


@Composable
@Preview(device = "spec:width=1080px,height=4200px,dpi=440")
fun PantauTanamanScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF093731))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 22.dp, end = 22.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Bagaimana Kabar\nTanamanmu hari ini?",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 28.sp
            )

            Image(
                painter = painterResource(R.drawable.tree_overlook),
                contentDescription = null,
                modifier = Modifier
                    .size(190.dp)
                    .offset(y = (40).dp)
            )
        }

        Column(
            modifier = Modifier
                .zIndex(1f)
                .fillMaxWidth()
                .offset(y = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var text by remember { mutableStateOf("") }
            TextField(
                value = text,
                onValueChange = { newText -> text = newText},
                placeholder = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.search),
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                                .padding(end = 8.dp)
                        )

                        Text(
                            text = "Cari tanaman kamu...",
                            color = Color.Gray
                        )
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .shadow(10.dp, RoundedCornerShape(12.dp))
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White),
        ) {
            item {
                Spacer(Modifier.height(30.dp))
                ElevatedCard(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    )
                ){
                    Text(
                        text = "Daftar Tanamanmu",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                        ),
                        modifier = Modifier
                            .padding(12.dp)
                    )

                    plantList.forEach { plant ->
                        Row{
                            Image(
                                painter = painterResource(plant.imgId),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(12.dp)
                            )

                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(12.dp),
                                verticalArrangement = Arrangement.spacedBy(4.dp),
                                horizontalAlignment = Alignment.Start
                            ) {
                                Text(
                                    text = plant.plantName,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.SemiBold,
                                    ),
                                )

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.dot),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(10.dp),
                                        tint = if (plant.difficulty == "Mudah") Color(0xFF2ECC71) else Color(0xFFC10101)
                                    )

                                    Text(
                                        text = plant.difficulty,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Normal,
                                            color = if (plant.difficulty == "Mudah") Color(0xFF2ECC71) else Color(0xFFC10101)
                                        )
                                    )
                                }

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.overlook),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(20.dp),
                                        tint = Color(0xFF179778)
                                    )

                                    Text(
                                        text = plant.time
                                    )
                                }
                            }

                            Column(
                                modifier = Modifier
                                    .padding(12.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Button(
                                    onClick = {},
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF179778)
                                    ),
                                    shape = RoundedCornerShape(10.dp),
                                    modifier = Modifier
                                        .size(100.dp, 40.dp)
                                        .padding(end = 8.dp),

                                    ) {
                                    Text(
                                        text = "Pantau"
                                    )
                                }
                            }
                        }
                    }
                }

                ElevatedCard(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    )
                ){
                    Text(
                        text = "Riwayat",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                        ),
                        modifier = Modifier
                            .padding(12.dp)
                    )

                    plantList.forEach { plant ->
                        Row{
                            Image(
                                painter = painterResource(plant.imgId),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(12.dp)
                            )

                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(12.dp),
                                verticalArrangement = Arrangement.spacedBy(4.dp),
                                horizontalAlignment = Alignment.Start
                            ) {
                                Text(
                                    text = plant.plantName,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.SemiBold,
                                    ),
                                )

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.dot),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(10.dp),
                                        tint = if (plant.difficulty == "Mudah") Color(0xFF2ECC71) else Color(0xFFC10101)
                                    )

                                    Text(
                                        text = plant.difficulty,
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Normal,
                                            color = if (plant.difficulty == "Mudah") Color(0xFF2ECC71) else Color(0xFFC10101)
                                        )
                                    )
                                }

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.overlook),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(20.dp),
                                        tint = Color(0xFF179778)
                                    )

                                    Text(
                                        text = plant.time
                                    )
                                }
                            }

                            Column(
                                modifier = Modifier
                                    .padding(12.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Button(
                                    onClick = {},
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF179778)
                                    ),
                                    shape = RoundedCornerShape(10.dp),
                                    modifier = Modifier
                                        .size(100.dp, 40.dp)
                                        .padding(end = 8.dp),

                                    ) {
                                    Text(
                                        text = "Pantau"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }


    }
}
