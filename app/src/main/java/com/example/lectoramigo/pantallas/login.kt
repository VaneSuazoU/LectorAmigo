package com.example.lectoramigo.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lectoramigo.ui.theme.*

import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.animateLottieCompositionAsState

import com.example.lectoramigo.R


@Composable
fun login(
    onIrARegistro: () -> Unit = {},
    onIrARecuperar: () -> Unit = {}
) {
    var usuario by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Lavanda, RosaSuave)))
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Celeste),
            elevation = CardDefaults.cardElevation(6.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Bienvenido a LectorAmigo",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = AzulGris
                )

                Spacer(modifier = Modifier.height(20.dp))

                val composition by rememberLottieComposition(
                    spec = LottieCompositionSpec.RawRes(R.raw.login_animation)
                )
                val progress by animateLottieCompositionAsState(composition, iterations = LottieConstants.IterateForever)
                LottieAnimation(
                    composition = composition,
                    progress = { progress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                )


                Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(
                    value = usuario,
                    onValueChange = { usuario = it },
                    label = { Text("Usuario") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = AzulGris,
                        unfocusedIndicatorColor = Lavanda,
                        cursorColor = AzulGris
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = contrasena,
                    onValueChange = { contrasena = it },
                    label = { Text("Contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = AzulGris,
                        unfocusedIndicatorColor = Lavanda,
                        cursorColor = AzulGris,
                        focusedLabelColor = AzulGris,
                        unfocusedLabelColor = Lavanda
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { /* TODO: validar */ },
                    colors = ButtonDefaults.buttonColors(containerColor = RosaClaro),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Ingresar", color = AzulGris, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "¿No tienes cuenta?",
                        color = AzulGris
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    TextButton(onClick = { onIrARegistro() }) {
                        Text(
                            text = "Regístrate",
                            color = Azul
                        )
                    }
                }
                TextButton(onClick = { onIrARecuperar() }) {
                    Text("Olvidé mi contraseña", color = AzulGris)
                }
            }
        }
    }
}
