package com.seroserod92.pokeapiperron.data.repository.networking

import com.seroserod92.pokeapiperron.data.api.PokemonApiService
import com.seroserod92.pokeapiperron.data.model.PokemonPagination
import com.seroserod92.pokeapiperron.data.model.pokemon_data.Pokemon
import com.seroserod92.pokeapiperron.domain.repository.PokemonRepository

class PokemonRepositoryImpl(val pokemonApiService: PokemonApiService): PokemonRepository{
    override suspend fun getPokemonListPagination(offset: Int?, limit: Int?): PokemonPagination {
        return pokemonApiService.getPokemonListPagination(offset,limit)
    }

    override suspend fun getPokemon(pokeName: String): Pokemon {
       return pokemonApiService.getPokemon(pokeName)
    }
}