package com.seroserod92.pokeapiperron.domain.repository

import com.seroserod92.pokeapiperron.data.model.PokemonPagination
import com.seroserod92.pokeapiperron.data.model.pokemon_data.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonRepository {
    suspend fun getPokemonListPagination(
        offset: Int? = 0, limit: Int? = 20
    ): PokemonPagination

    suspend fun getPokemon(pokeName: String): Pokemon
}