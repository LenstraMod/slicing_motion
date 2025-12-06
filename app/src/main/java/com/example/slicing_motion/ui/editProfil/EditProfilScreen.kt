package com.example.slicing_motion.ui.editProfil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slicing_motion.R

@Composable
@Preview(device = "spec:width=1080px,height=5000px,dpi=440")
fun EditProfilScreen(
    onBackClick: () -> Unit = {},
    onCheckingOrder: () -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var ubahPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
            .padding(horizontal = 18.dp)
    ) {

        /** ---------- HEADER ---------- **/
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp),
            contentAlignment = Alignment.Center
        ) {

            // Back Button (posisi kiri)
            Surface(
                onClick = onBackClick,
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
                text = "Edit Profil",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        /** ---------- PROFILE IMAGE ---------- **/
        Box(
            modifier = Modifier
                .size(95.dp)
                .align(Alignment.CenterHorizontally)
                .background(Color(0xFFE8F5F2), CircleShape) // ⬅ background hijau muda
                .padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "Foto Profil",
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // ---------- Nama Lengkap ----------
        Text(
            text = "Nama Lengkap",
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = nama,
            onValueChange = { nama = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            label = { Text("Nama Lengkap...") },
            textStyle = TextStyle(color = Color.Gray),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF4F5F7),
                unfocusedContainerColor = Color(0xFFF4F5F7),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.DarkGray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // ---------- Email ----------
        Text(
            text = "Email",
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            label = { Text("Email...") },
            textStyle = TextStyle(color = Color.Gray),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF4F5F7),
                unfocusedContainerColor = Color(0xFFF4F5F7),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.DarkGray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // ---------- Password ----------
        Text(
            text = "Password",
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            label = { Text("Password...") },
            visualTransformation = PasswordVisualTransformation(),
            textStyle = TextStyle(color = Color.Gray),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF4F5F7),
                unfocusedContainerColor = Color(0xFFF4F5F7),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.DarkGray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // ---------- Ubah Password ----------
        Text(
            text = "Ubah Password",
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = ubahPassword,
            onValueChange = { ubahPassword = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            label = { Text("Ubah Password...") },
            visualTransformation = PasswordVisualTransformation(),
            textStyle = TextStyle(color = Color.Gray),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF4F5F7),
                unfocusedContainerColor = Color(0xFFF4F5F7),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.DarkGray
            )
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { /* kosong */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF139779)
            )
        ) {
            Text(
                text = "Simpan",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}
