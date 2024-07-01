package com.seroserod92.pokeapiperron.data.model

data class PokemonPagination(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<PokemonUri>
)