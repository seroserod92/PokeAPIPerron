package com.seroserod92.pokeapiperron.data.model.pokemon_data

data class Pokemon(
    val base_experience: Int,
    val height: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val sprites: Sprites,
    val weight: Int
)