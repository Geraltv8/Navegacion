package com.UTN.navegacion.ui.theme.utils

import com.UTN.navegacion.model.Usuario
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun createUserJson(name: String, age: String): String {
    val user = Usuario(
        id = (1..1000).random(),
        nombre = name,
        edad = age.toIntOrNull() ?: 0
    )

    return Json.encodeToString(user)
}
