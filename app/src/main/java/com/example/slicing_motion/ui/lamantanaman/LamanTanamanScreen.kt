package com.example.slicing_motion.ui.lamantanaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slicing_motion.R

val BottomCurveShape = GenericShape { size, _ ->
    moveTo(0f, 0f)

    lineTo(size.width, 0f)

    lineTo(size.width, size.height * 0.88f)

    quadraticBezierTo(
        size.width / 2,
        size.height * 1.10f,
        0f,
        size.height * 0.88f
    )

    close()
}

@Composable
@Preview(device = "spec:width=1080px,height=4200px,dpi=440")
fun LamanTamanScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(330.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.sayurlaman),
                contentDescription = "Tanaman",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(BottomCurveShape),   // ⬅️ cuma lengkung bawah
                contentScale = ContentScale.Crop
            )


            Surface(
                modifier = Modifier
                    .padding(start = 18.dp, top = 50.dp)
                    .size(45.dp),
                shape = CircleShape,
                color = Color.White
            ) {

                Icon(
                    painter = painterResource(R.drawable.back),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .padding(10.dp)
                )

            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier.padding(horizontal = 22.dp)) {

            Text(
                text = "Selada Hidroponik",
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {

                Icon(
                    painter = painterResource(R.drawable.green),
                    tint = Color(0xFF2ECC71),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = "Mudah",
                    fontSize = 20.sp,
                    color = Color(0xFF2ECC71)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Icon(
                    painter = painterResource(R.drawable.clock),
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(12.dp)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = "3–5 Ming",
                    fontSize = 20.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Deskripsi",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Selada merupakan salah satu tanaman paling populer dalam budidaya hidroponik karena pertumbuhannya yang cepat dan perawatannya yang mudah. Tanaman ini cocok untuk pemula karena tidak memerlukan banyak nutrisi khusus atau perawatan intensif. Selada tumbuh subur di sistem hidroponik seperti NFT (Nutrient Film Technique) dan dapat dipanen dalam waktu 3–5 minggu setelah tanam",
                fontSize = 15.sp,
                color = Color.Gray,
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            val list = listOf(
                "Wadah atau Bak Tanam – Tempat air nutrisi dan tanaman diletakkan.",
                "Net Pot / Pot kecil berlubang – Untuk menahan tanaman dan media tanam.",
                "Spons / Rockwool – Media tanam tempat benih tumbuh.",
                "Pompa Air (untuk NFT) – Mengalirkan nutrisi secara sirkulasi.",
                "Penutup atau Styrofoam – Untuk menopang netpot.",
                "Alat ukur pH dan TDS – Untuk memantau kualitas larutan nutrisi.",
                "Benih selada ",
                "Nutrisi AB Mix  ",
                "Air Bersih "
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Text(
                    text = "Alat dan Bahan",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(16.dp))

                list.forEachIndexed { index, item ->

                    val parts = item.split("–")

                    Text(
                        text = buildAnnotatedString {
                            append("${index + 1}. ${parts[0].trim()} ")
                            addStyle(
                                style = SpanStyle(fontWeight = FontWeight.Bold),
                                start = 0,
                                end = length
                            )

                            // Teks setelah tanda –
                            if (parts.size > 1) {
                                append("– ${parts[1].trim()}")
                                addStyle(
                                    style = SpanStyle(fontWeight = FontWeight.Normal, color = Color.Gray),
                                    start = parts[0].length + 3,
                                    end = length
                                )
                            }
                        },
                        fontSize = 16.sp,
                        lineHeight = 22.sp,
                        modifier = Modifier.padding(bottom = 8.dp),
                        color = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Tutorial Menanam",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
            )

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
                            painter = painterResource(R.drawable.tutorial),
                            contentDescription = "Tutorial",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .clip(RoundedCornerShape(12.dp)),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Menanam Selada Hidroponik",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
               }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(12.dp)),
                color = Color(0xFF139779)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Mulai Tanam Dan Pantau",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

