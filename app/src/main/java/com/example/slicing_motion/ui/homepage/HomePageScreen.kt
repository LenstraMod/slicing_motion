    package com.example.slicing_motion.ui.homepage

    import androidx.compose.foundation.Image
    import com.example.slicing_motion.R
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
    import androidx.compose.foundation.layout.statusBarsPadding
    import androidx.compose.foundation.layout.width
    import androidx.compose.foundation.lazy.grid.GridCells
    import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
    import androidx.compose.foundation.lazy.grid.items
    import androidx.compose.foundation.lazy.grid.rememberLazyGridState
    import androidx.compose.foundation.shape.CircleShape
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material3.Card
    import androidx.compose.material3.CardDefaults
    import androidx.compose.material3.Icon
    import androidx.compose.material3.Text
    import androidx.compose.material3.TextField
    import androidx.compose.material3.TextFieldDefaults
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.graphics.ColorFilter
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.TextStyle
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import com.example.slicing_motion.common.model.Kit
    import com.example.slicing_motion.common.model.Plant

    @Composable
    @Preview
    fun HomePageScreen(
        onClickCard: () -> Unit = {}
    ) {

        val plants: List<Plant> = listOf(
            Plant("Selada Hidroponik", "Mudah", "Lorem Ipsum", "3-5 Ming", R.drawable.sayur),
            Plant("Bayam Hidroponik", "Sedang", "Lorem Ipsum", "3-4 Ming", R.drawable.sayur),
            Plant("Pakcoy Hidroponik", "Sedang", "Lorem Ipsum", "4-5 Ming", R.drawable.sayur),
            Plant("Tomat Cherry", "Sulit", "Lorem Ipsum", "8-10 Ming", R.drawable.sayur),
        )

        val kits: List<Kit> = listOf(
            Kit("Paket Pipa NFT", "Rp 125.000", "Rp 150.000", R.drawable.sayur),
            Kit("Paket Lengkap", "Rp 55.000", "Rp 75.000", R.drawable.sayur)
        )

        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            // ==================== COLUMN KONTEN BAWAH ====================
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(start = 22.dp, top = 350.dp, end = 22.dp)
            ) {

                val lazyGridState = rememberLazyGridState()
            // ==================== SEARCH BAR ============================
                TextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text("Cari tanaman...") },
                    textStyle = TextStyle(color = Color.Gray),
                    leadingIcon = {
                        Image(
                            painter = painterResource(R.drawable.search),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Color.Gray),
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFF4F5F7),
                        unfocusedContainerColor = Color(0xFFF4F5F7),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.DarkGray
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // ==================== REKOMENDASI SECTION ============================

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Rekomendasi Untukmu",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = "Lihat Semua",
                        color = Color(19, 151, 121),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    )
                }

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    state = lazyGridState,
                ) {
                    items(plants) { plant ->
                        Card(
                            onClick = onClickCard,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                        ) {

                            Column(
                                modifier = Modifier.padding(10.dp)

                            ) {

                                Image(
                                    painter = painterResource(plant.imageRes),
                                    contentDescription = plant.plantName,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(120.dp)
                                        .clip(RoundedCornerShape(12.dp)),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = plant.plantName,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        val iconRes = when (plant.difficulty) {
                                            "Mudah" -> R.drawable.green
                                            "Sedang" -> R.drawable.orange
                                            "Sulit" -> R.drawable.red
                                            else -> R.drawable.gray
                                        }

                                        val tintColor = when (plant.difficulty) {
                                            "Mudah" -> Color(0xFF2ECC71) // green
                                            "Sedang" -> Color(0xFFFFA500) // orange
                                            "Sulit", -> Color(0xFFEA4335) // red
                                            else -> Color.Gray
                                        }

                                        Icon(
                                            painter = painterResource(iconRes),
                                            contentDescription = null,
                                            tint = tintColor,
                                            modifier = Modifier.size(10.dp)
                                        )


                                        Spacer(modifier = Modifier.width(6.dp))

                                        val textColor = when(plant.difficulty) {
                                            "Mudah" -> Color(0xFF2ECC71)
                                            "Sedang" -> Color(0xFFFFA500)
                                            "Sulit" -> Color(0xFFEA4335)
                                            else -> Color.Gray
                                        }

                                        Text(
                                            text = plant.difficulty,
                                            fontSize = 13.sp,
                                            color = textColor
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(4.dp))

                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.clock),
                                            contentDescription = null,
                                            tint = Color.Gray,
                                            modifier = Modifier.size(14.dp)
                                        )

                                        Spacer(modifier = Modifier.width(6.dp))

                                        Text(
                                            text = plant.time,
                                            fontSize = 13.sp,
                                            color = Color.Gray
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Starter Kit Flash Sale 🔥",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .background(Color(0xFF1ABC9C), shape = RoundedCornerShape(6.dp))
                                .padding(horizontal = 10.dp, vertical = 4.dp)
                        ) {
                            Text(text = "01", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }

                        Text(text = ":", fontWeight = FontWeight.Bold, fontSize = 14.sp)

                        Box(
                            modifier = Modifier
                                .background(Color(0xFF1ABC9C), shape = RoundedCornerShape(6.dp))
                                .padding(horizontal = 10.dp, vertical = 4.dp)
                        ) {
                            Text(text = "20", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }

                        Text(text = ":", fontWeight = FontWeight.Bold, fontSize = 14.sp)

                        Box(
                            modifier = Modifier
                                .background(Color(0xFF1ABC9C), shape = RoundedCornerShape(6.dp))
                                .padding(horizontal = 10.dp, vertical = 4.dp)
                        ) {
                            Text(text = "47", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    state = lazyGridState
                ) {
                    items(kits) {kit ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                        ) {

                            Column(
                                modifier = Modifier.padding(10.dp)

                            ) {

                                Image(
                                    painter = painterResource(kit.imageRes),
                                    contentDescription = kit.NamaKit,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(120.dp)
                                        .clip(RoundedCornerShape(12.dp)),
                                    contentScale = ContentScale.Crop
                                )
                                Spacer(modifier = Modifier.height(8.dp))


                                Text(
                                    text = "Starter Kit",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Gray
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = kit.NamaKit,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {

                                        Text(
                                            text = kit.HargaPromo,
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(19, 151, 121)
                                        )
                                    }

                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = kit.HargaAsli,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            color = Color.Gray
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

            }

            // ==================== HEADER ====================
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(8, 55, 49))
                    .statusBarsPadding()
                    .padding(start = 22.dp, top = 40.dp, end = 22.dp, bottom = 130.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Halo Louis! 👋🏻",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Berkebun Apa Hari Ini?",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color.White, CircleShape)
                        .padding(4.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.profile),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                    )
                }
            }

            // ==================== CARD DI TENGAH ====================
            Card(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 140.dp)
                    .width(500.dp)
                    .height(180.dp)
                    .padding(horizontal = 22.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "Belum Ada Progress Tanaman Hari Ini...",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Ayo pilih tanaman pertama kamu dan mulai tanam sekarang!",
                            fontWeight = FontWeight.Thin,
                            color = Color.DarkGray
                        )
                    }

                    Image(
                        painter = painterResource(R.drawable.daun),
                        contentDescription = null,
                        modifier = Modifier.size(140.dp)
                    )
                }
            }
        }
    }


