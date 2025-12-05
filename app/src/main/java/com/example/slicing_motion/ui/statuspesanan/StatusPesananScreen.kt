package com.example.slicing_motion.ui.statuspesanan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slicing_motion.R

@Composable
@Preview(showBackground = true, device = "spec:width=1080px,height=4200px,dpi=440")
fun StatusPesananScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
            .padding(horizontal = 18.dp)
    ) {
        // ---------- HEADER ----------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp),
            contentAlignment = Alignment.Center
        ) {

            // Back Button (posisi kiri)
            Surface(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(45.dp),
                shape = CircleShape,
                color = Color.White
            ) {
                Icon(
                    painter = painterResource(R.drawable.back),
                    contentDescription = "Back",
                    tint = Color.Black,
                    modifier = Modifier.padding(10.dp)
                )
            }

            // Title di tengah
            Text(
                text = "Status Pesanan",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // ---------- BUTTONS ----------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Diproses
            Button(
                onClick = { /* kosong */ },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF139779)
                )
            ) {
                Text(
                    text = "Diproses",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            // Dikirim
            Button(
                onClick = { /* kosong */ },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .border(2.dp, Color(0xFF139779), RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE8F5F2)
                )
            ) {
                Text(
                    text = "Dikirim",
                    color = Color(0xFF139779),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            // Selesai
            Button(
                onClick = { /* kosong */ },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .border(2.dp, Color(0xFF139779), RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE8F5F2)
                )
            ) {
                Text(
                    text = "Selesai",
                    color = Color(0xFF139779),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // ---------- CARD PESANAN ----------
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(modifier = Modifier.padding(10.dp)) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Gambar di kiri
                    Image(
                        painter = painterResource(R.drawable.profile), // ganti sesuai gambar
                        contentDescription = "Produk",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    // Teks di kanan gambar
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Paket Lengkap",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Rp120.000",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF139779)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Rp150.000",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Gray
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Jumlah Produk: 3",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Garis pemisah
                Divider(color = Color.Gray, thickness = 1.dp)

                Spacer(modifier = Modifier.height(8.dp))

                // Detail bawah garis
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "1 Produk",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray
                    )
                    Text(
                        text = "Rp120.000",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF139779)
                    )
                }
            }
        }
    }
}
