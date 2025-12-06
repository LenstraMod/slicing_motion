package com.example.slicing_motion.ui.register

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*;


@Composable
@Preview
fun RegisterScreen(
    onBackClick: () -> Unit = {},
    onLoginClick: () -> Unit = {}
){

    var usernameValue by remember { mutableStateOf("") }
    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var passwordValueConfirmation by remember { mutableStateOf("") }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Daftar Akun dan Mulai Bertani Hidroponik!\uD83C\uDF3F",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            )

            Spacer(modifier = Modifier.height(42.dp))

            Text(
                text = "Nama Lengkap",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier  = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
            )
            OutlinedTextField(
                value = usernameValue,
                onValueChange = { usernameValue=it },
                label = { Text("Masukkan Nama Lengkap")},
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF7F8F9),
                    unfocusedLabelColor = Color(0xFF8391A1),
                    focusedBorderColor = Color(0xFF179778)
                )
            )

            Spacer(modifier = Modifier.height(42.dp))

            Text(
                text = "Email",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier  = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
            )
            OutlinedTextField(
                value = emailValue,
                onValueChange = { emailValue=it },
                label = { Text("Masukkan Email")},
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF7F8F9),
                    unfocusedLabelColor = Color(0xFF8391A1),
                    focusedBorderColor = Color(0xFF179778)
                )
            )

            Spacer(modifier = Modifier.height(42.dp))

            Text(
                text = "Buat Password",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier  = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
            )
            OutlinedTextField(
                value = passwordValue,
                onValueChange = { passwordValue = it },
                label = { Text("Masukkan Password")},
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF7F8F9),
                    unfocusedLabelColor = Color(0xFF8391A1),
                    focusedBorderColor = Color(0xFF179778)

                )
            )

            Spacer(modifier = Modifier.height(42.dp))

            Text(
                text = "Konfirmasi Password",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier  = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
            )
            OutlinedTextField(
                value = passwordValueConfirmation,
                onValueChange = { passwordValueConfirmation = it },
                label = { Text("Masukkan Password")},
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF7F8F9),
                    unfocusedLabelColor = Color(0xFF8391A1),
                    focusedBorderColor = Color(0xFF179778)
                )
            )

            Spacer(modifier = Modifier.height(42.dp))

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF179778)
                )
            ) {
                Text("Masuk")
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Sudah ada akun? ")
                Text(
                    text = "Masuk",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF179778)
                    ),
                    modifier = Modifier.clickable{
                        onLoginClick()
                    }
                )
            }

        }

        IconButton(
            onClick = {
                onBackClick()
            },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 16.dp, start = 16.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFE8ECF4),
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black
            )
        }
    }
}
