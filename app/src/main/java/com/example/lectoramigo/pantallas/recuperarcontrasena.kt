package com.example.lectoramigo.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lectoramigo.ui.theme.*

@Composable
fun recuperarcontrasena(
    onRecuperado: () -> Unit = {},
    onVolver: () -> Unit = {}
) {
    var nombre by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

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
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Recuperar Contraseña", fontSize = 22.sp, color = AzulGris)

                Spacer(Modifier.height(16.dp))

                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Usuario") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(20.dp))

                Button(
                    onClick = {
                        val usuario = usuariosSimulados.find { it.nombre == nombre }
                        if (usuario != null) {
                            mensaje = "Tu contraseña es: ${usuario.contrasena}"
                            onRecuperado()
                        } else {
                            mensaje = "❌ Usuario no encontrado"
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = RosaClaro),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Recuperar", color = AzulGris)
                }

                Spacer(Modifier.height(12.dp))
                Text(mensaje, color = AzulGris)

                Spacer(Modifier.height(20.dp))

                TextButton(onClick = { onVolver() }) {
                    Text("Volver al Login", color = Azul)
                }
            }
        }
    }
}
