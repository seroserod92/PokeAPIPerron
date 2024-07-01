package com.seroserod92.pokeapiperron.presentation.pokemon_detail

import com.seroserod92.pokeapiperron.data.model.PokemonUri
import com.seroserod92.pokeapiperron.data.model.pokemon_data.Pokemon

data class PokemonListState(
    val isLoading: Boolean = false,
    val pokemon: Pokemon? = null,
    val error: String = "",
    val isSaved: Boolean = false
)