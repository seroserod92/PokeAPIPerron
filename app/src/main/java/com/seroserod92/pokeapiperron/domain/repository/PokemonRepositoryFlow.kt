package com.seroserod92.pokeapiperron.domain.repository

import com.seroserod92.pokeapiperron.data.model.PokemonPagination
import com.seroserod92.pokeapiperron.data.model.pokemon_data.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepositoryFlow {
    fun getPokemonListPagination(
        offset: Int? = 0, limit: Int? = 20
    ): Flow<PokemonPagination>

    suspend fun getPokemon(pokeName: String): Flow<Pokemon>
}
