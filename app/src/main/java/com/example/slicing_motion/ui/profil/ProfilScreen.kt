package com.example.slicing_motion.ui.profil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
@Preview(showBackground = true)
fun ProfilScreen(
    onEditClick : () -> Unit = {},
    onCheckOrder: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        /** HEADER HIJAU */
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            color = Color(0xFF064E47),
            shape = BottomCurveShape
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Box(
                        modifier = Modifier
                            .size(78.dp)
                            .background(Color.White, CircleShape)
                            .padding(4.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.profile),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(CircleShape)
                                .fillMaxSize()
                        )
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column {
                        Text(
                            text = "Mellafesa",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "mellafesaa@gmail.com",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White.copy(alpha = 0.9f)
                        )
                    }
                }

                Button(
                    onClick = onEditClick,
                    modifier = Modifier.height(38.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2CB579),
                        contentColor = Color.White
                    ),
                    contentPadding = PaddingValues(horizontal = 18.dp)
                ) {
                    Text("Edit", fontSize = 13.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        /** CARD CONTAINER */
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            StatusPesananCard(onCheckOrder = onCheckOrder)
            PersonalisasiCard()
            LogoutCard()
        }
    }
}

@Composable
fun StatusPesananCard(
    onCheckOrder: () -> Unit = {}
) {
    Surface(
        onClick = onCheckOrder,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        color = Color.White,
        shadowElevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 22.dp)
        ) {
            Text(
                "Status Pesanan Marketplace",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A)
            )
            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                StatusItem(R.drawable.cart, "Diproses")
                StatusItem(R.drawable.truck, "Dikirim")
                StatusItem(R.drawable.medal, "Selesai")
            }
        }
    }
}

@Composable
fun StatusItem(icon: Int, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(icon),
            contentDescription = title,
            modifier = Modifier.size(40.dp),
            colorFilter = ColorFilter.tint(Color(0xFF139779))

        )
        Spacer(Modifier.height(6.dp))
        Text(title, fontSize = 12.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun PersonalisasiCard() {
    GenericMenuCard(
        title = "Personalisasi",
        iconRes = R.drawable.leaf,
        iconBg = Color(0xFFE7F5F0),
        iconColor = Color(0xFF2CB579)
    )
}

@Composable
fun LogoutCard() {
    GenericMenuCard(
        title = "Logout",
        iconRes = R.drawable.logout,   // << icon logout kamu
        titleColor = Color(0xFFE63939),
        iconBg = Color(0xFFFFEBEB),
        iconColor = Color(0xFFE63939)
    )
}

@Composable
fun GenericMenuCard(
    title: String,
    iconRes: Int,
    titleColor: Color = Color(0xFF1A1A1A),
    iconBg: Color,
    iconColor: Color
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        color = Color.White,
        shadowElevation = 10.dp
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .background(iconBg, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(iconRes),
                        contentDescription = title,
                        modifier = Modifier.size(22.dp),
                        colorFilter = ColorFilter.tint(iconColor)
                    )
                }

                Spacer(Modifier.width(12.dp))

                Text(title, fontSize = 15.sp, fontWeight = FontWeight.SemiBold, color = titleColor)
            }

            Image(
                painter = painterResource(R.drawable.forward),
                contentDescription = "Next",
                modifier = Modifier.size(20.dp),
                colorFilter = ColorFilter.tint(iconColor)
            )
        }
    }
}
