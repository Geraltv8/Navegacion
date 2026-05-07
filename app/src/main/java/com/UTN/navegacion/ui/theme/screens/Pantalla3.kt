package com.UTN.navegacion.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.UTN.navegacion.ui.theme.nav.DestinoPantalla1

@Composable
fun Pantalla3(navController: NavController, nombre: String) {

    Column {
        Text("Bienvenido a la pantalla final, $nombre")
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("ir a la pantalla 2")
        }

        Button(onClick = {
            navController.navigate(DestinoPantalla1) {
                popUpTo(0) { inclusive = true }
            }
        }) {
            Text("ir a la pantalla 1")
        }
    }
}
