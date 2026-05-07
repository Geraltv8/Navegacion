package com.UTN.navegacion.ui.theme.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.UTN.navegacion.model.Usuario
import com.UTN.navegacion.ui.theme.screens.Pantalla1
import com.UTN.navegacion.ui.theme.screens.Pantalla2
import com.UTN.navegacion.ui.theme.screens.Pantalla3
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DestinoPantalla1,
        modifier = modifier)
    {
        composable<DestinoPantalla1> { Pantalla1(navController) }

        composable<DestinoPantalla2> { backStackEntry ->
            val datos = backStackEntry.toRoute<DestinoPantalla2>()
            val usuario = Json.decodeFromString<Usuario>(datos.userJson)

            Pantalla2(navController, usuario)
        }

        composable<DestinoPantalla3> { backStackEntry ->
            val datos = backStackEntry.toRoute<DestinoPantalla3>()
            Pantalla3(navController, datos.nombre)
        }
    }
}

@Serializable
object DestinoPantalla1
@Serializable
data class DestinoPantalla2(val userJson: String)
@Serializable
data class DestinoPantalla3(val nombre: String)