package com.seroserod92.pokeapiperron.presentation.pokemon_list

import com.seroserod92.pokeapiperron.data.model.PokemonUri

data class PokemonListState(
    val isLoading: Boolean = false,
    val listPokemon: List<PokemonUri> = emptyList(),
    val error: String = ""
)