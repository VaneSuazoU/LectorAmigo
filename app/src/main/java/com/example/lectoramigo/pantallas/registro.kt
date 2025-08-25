package com.example.lectoramigo.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lectoramigo.ui.theme.*

data class Usuario(val nombre: String, val contrasena: String)

val usuariosSimulados = mutableListOf<Usuario>()

@Composable
fun registro(
    onRegistroExitoso: () -> Unit = {},
    onVolver: () -> Boolean
) {
    var nombre by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var confirmar by remember { mutableStateOf("") }
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Registro de Usuario", fontSize = 22.sp, color = AzulGris)

                Spacer(Modifier.height(16.dp))

                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Usuario") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = contrasena,
                    onValueChange = { contrasena = it },
                    label = { Text("Contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = confirmar,
                    onValueChange = { confirmar = it },
                    label = { Text("Confirmar contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(20.dp))

                Button(
                    onClick = {
                        when {
                            usuariosSimulados.size >= 5 -> {
                                mensaje = "❌ Ya se alcanzó el límite de 5 usuarios"
                            }
                            contrasena != confirmar -> {
                                mensaje = "❌ Las contraseñas no coinciden"
                            }
                            nombre.isBlank() -> {
                                mensaje = "❌ El usuario no puede estar vacío"
                            }
                            else -> {
                                usuariosSimulados.add(Usuario(nombre, contrasena))
                                mensaje = "✅ Usuario registrado con éxito"
                                onRegistroExitoso()
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = RosaClaro),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Registrar", color = AzulGris)
                }

                Spacer(Modifier.height(12.dp))
                Text(mensaje, color = AzulGris)

                Spacer(Modifier.height(20.dp))
                TextButton(onClick = { onVolver() }) {
                    Text("Volver", color = Azul)
                }
            }
        }
    }
}