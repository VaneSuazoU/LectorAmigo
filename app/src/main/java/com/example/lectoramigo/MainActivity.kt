package com.example.lectoramigo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.lectoramigo.ui.theme.LectorAmigoTheme

import com.example.lectoramigo.pantallas.login
import com.example.lectoramigo.pantallas.registro

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lectoramigo.pantallas.recuperarcontrasena


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LectorAmigoTheme {
                AppNav()
            }
        }
    }
}
sealed class Ruta(val route: String) {
    data object Login: Ruta("login")
    data object Registro: Ruta("registro")
    data object RecuperarContrasena: Ruta("recuperarcontrasena")
}

@Composable
fun AppNav() {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = Ruta.Login.route) {
        composable(Ruta.Login.route) {
            login(
                onIrARegistro = { nav.navigate(Ruta.Registro.route) },
                onIrARecuperar = { nav.navigate(Ruta.RecuperarContrasena.route) }
            )
        }
        composable(Ruta.Registro.route) {
            registro(
                onRegistroExitoso = { nav.popBackStack() },
                onVolver = { nav.popBackStack() }
            )
        }
        composable(route = Ruta.RecuperarContrasena.route) {
            recuperarcontrasena (
                onRecuperado = { nav.popBackStack() },
                onVolver = { nav.popBackStack() }
            )
            }

    }
}
