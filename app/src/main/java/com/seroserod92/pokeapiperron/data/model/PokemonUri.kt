package com.seroserod92.pokeapiperron.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_uri")
data class PokemonUri(
    @PrimaryKey
    val name: String,
    val url: String
)