package com.example.slicing_motion.ui.onboarding

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slicing_motion.R

@Composable
@Preview
fun onboarding3(
    onFinishClick: () -> Unit = {},
    onSkipClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF093731))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.55f)
        ){
            Image(
                painter = painterResource(id = R.drawable.onboarding3),
                contentDescription = "onboarding2",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()

            )

            Button(
                onClick = { onSkipClick() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 48.dp, end = 24.dp)
            ){
                Text(
                    text = "Lewati",
                    color = Color(0xFF179778),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(Modifier.height(42.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.45f)
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text="Belanja Starter Kit & Jual Hasil Panen!",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 32.sp
                    )
                )

                Spacer(Modifier.height(32.dp))

                Text(
                    text = "Belanja, jual panen, dan penuhi kebutuhanmu di marketplace kami. Praktis banget buat kamu yang suka berkebun dari rumah!",
                    style = TextStyle(
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {onBackClick()},
                    modifier = Modifier
                        .size(56.dp)
                        .background(Color(0xFF35504B),RoundedCornerShape(16.dp))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Row(
                    modifier =  Modifier.weight(1f),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .background(Color(0xFF4A635F),CircleShape)
                    )

                    Spacer(Modifier.size(8.dp))

                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .shadow(
                                elevation = 10.dp,
                                shape = CircleShape,
                                spotColor = Color(0xFF179778), // Green glow
                                ambientColor = Color(0xFF179778)
                            )
                            .background(Color(0xFF179778), CircleShape)
                    )
                }

                IconButton(
                    onClick = {onFinishClick()},
                    modifier = Modifier
                        .size(56.dp)
                        .background(Color(0xFF35504B),RoundedCornerShape(16.dp))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Next",
                        tint = Color.White
                    )
                }
            }

        }
    }
}