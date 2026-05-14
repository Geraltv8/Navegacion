package com.UTN.navegacion.DataSource

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.UTN.navegacion.model.Usuario
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UserStore(private val context: Context) {
    private val USER_KEY = stringPreferencesKey("user_data")

    suspend fun saveUser(user: String) {
        context.dataStore.edit { it[USER_KEY] = user }
    }

    val userFlow: Flow<Usuario?> = context.dataStore.data.map { prefs ->
        prefs[USER_KEY]?.let { Json.decodeFromString<Usuario>(it) }
    }
}