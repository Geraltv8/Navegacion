package com.UTN.navegacion.ui.theme.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.UTN.navegacion.ui.theme.customComposables.CustomColumn
import com.UTN.navegacion.ui.theme.customComposables.CustomEditText
import com.UTN.navegacion.ui.theme.nav.DestinoPantalla2
import com.UTN.navegacion.ui.theme.utils.createUserJson

@Composable
fun Pantalla1(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }

    CustomColumn {
        Text(text = "Registro de Usuario", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(32.dp))

        CustomEditText(
            nombre,
            {nombre = it},
            "Nombre del usuario",
            15
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomEditText(
            edad,
            {edad = it},
            "Edad del usuario",
            3,
            KeyboardType.Number
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
            val json = createUserJson(nombre, edad)

            navController.navigate(DestinoPantalla2(json))
        },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar a Pantalla 2")
        }
    }
}