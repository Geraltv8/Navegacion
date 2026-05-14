package com.UTN.navegacion.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.UTN.navegacion.model.Usuario
import com.UTN.navegacion.ui.theme.customComposables.CustomColumn
import com.UTN.navegacion.ui.theme.nav.DestinoPantalla3

@Composable
fun Pantalla2(navController: NavController, usuario: Usuario) {

    CustomColumn {
        Card(modifier = Modifier.padding(16.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("ID: ${usuario.id}")
                Text("Nombre: ${usuario.nombre}")
                Text("Edad: ${usuario.edad}")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            navController.navigate(DestinoPantalla3(usuario.nombre))
        }) {
            Text("Enviar Nombre a Pantalla 3")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("ir a la pantalla 1")
        }
    }
}