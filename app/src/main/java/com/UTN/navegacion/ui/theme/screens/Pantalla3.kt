package com.UTN.navegacion.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.UTN.navegacion.ui.theme.nav.DestinoPantalla1

@Composable
fun Pantalla3(navController: NavController, nombre: String) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text= "Bienvenido a la pantalla final, $nombre",
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center
        )
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
