package com.seroserod92.pokeapiperron.data.api

import com.seroserod92.pokeapiperron.data.model.PokemonPagination
import com.seroserod92.pokeapiperron.data.model.pokemon_data.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon/")
    suspend fun getPokemonListPagination(
        @Query("offset") offset: Int? = 0,
        @Query("limit") limit: Int? = 20
    ): PokemonPagination

    @GET("pokemon/{pokeName}")
    suspend fun getPokemon(@Path("pokeName") pokeName: String): Pokemon
}