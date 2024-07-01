package com.seroserod92.pokeapiperron.presentation.pokemon_saved_list

import com.seroserod92.pokeapiperron.data.model.PokemonUri

data class PokemonListSavedState(
    val isLoading: Boolean = false,
    val listPokemon: List<PokemonUri> = emptyList(),
    val error: String = ""
)