package com.example.lectoramigo.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lectoramigo.ui.theme.*

@Composable
fun home(
    usuario: String = "Usuario",
    onLogout: () -> Unit = {}
) {
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
                Text(
                    text = "Bienvenido, $usuario 👋",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = AzulGris
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Esta es tu app **LectorAmigo**.\n\n" +
                            "Aquí podrás acceder a funciones de lectura y escritura pensadas " +
                            "para mejorar la accesibilidad de personas con discapacidad visual.",
                    color = AzulGris,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = { onLogout() },
                    colors = ButtonDefaults.buttonColors(containerColor = RosaClaro),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Cerrar sesión", color = AzulGris, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}