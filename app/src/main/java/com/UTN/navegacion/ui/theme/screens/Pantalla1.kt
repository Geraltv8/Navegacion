package com.UTN.navegacion.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.UTN.navegacion.model.Usuario
import com.UTN.navegacion.ui.theme.nav.DestinoPantalla2
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun Pantalla1(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        TextField(
            value = nombre,
            onValueChange = { if (it.length <= 20) nombre = it },
            label = { Text("Nombre") },
            singleLine = true,

        )
        TextField(value = edad,
            onValueChange = { if (it.length <= 3) edad = it },
            label = { Text("Edad") },
            singleLine = true,

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
        )

        Button(onClick = {
            val user = Usuario(
                id = (1..1000).random(),
                nombre = nombre,
                edad = edad.toIntOrNull() ?: 0
            )

            val json = Json.encodeToString(user)

            navController.navigate(DestinoPantalla2(json))
        }) {
            Text("Enviar a Pantalla 2")
        }
    }
}