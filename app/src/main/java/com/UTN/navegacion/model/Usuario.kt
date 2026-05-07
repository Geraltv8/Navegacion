package com.UTN.navegacion.model

import kotlinx.serialization.Serializable


/*
"{
    "Usuario" {
        "id":"7483",
        "nombre": "Gerardo",
        "edad": 31,
    }
}"

 */
@Serializable
data class Usuario(
    val id: Int,
    val nombre: String,
    val edad: Int
)

