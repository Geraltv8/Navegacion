package com.UTN.navegacion.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.UTN.navegacion.model.Usuario
import com.UTN.navegacion.ui.theme.nav.DestinoPantalla3

@Composable
fun Pantalla2(navController: NavController, usuario: Usuario) {

    Column {
        Text("ID: ${usuario.id}")
        Text("Nombre: ${usuario.nombre}")
        Text("Edad: ${usuario.edad}")

        Button(onClick = {
            navController.navigate(DestinoPantalla3(usuario.nombre))
        }) {
            Text("Enviar Nombre a Pantalla 3")
        }
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("ir a la pantalla 1")
        }
    }
}