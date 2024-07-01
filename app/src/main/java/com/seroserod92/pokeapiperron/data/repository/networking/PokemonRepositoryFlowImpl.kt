package com.seroserod92.pokeapiperron.data.repository.networking

import com.seroserod92.pokeapiperron.data.api.PokemonApiService
import com.seroserod92.pokeapiperron.data.model.PokemonPagination
import com.seroserod92.pokeapiperron.data.model.pokemon_data.Pokemon
import com.seroserod92.pokeapiperron.domain.repository.PokemonRepositoryFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonRepositoryFlowImpl (val pokemonApiService: PokemonApiService): PokemonRepositoryFlow {
    override fun getPokemonListPagination(offset: Int?, limit: Int?): Flow<PokemonPagination> = flow {
        emit(pokemonApiService.getPokemonListPagination(offset,limit))
    }

    override suspend fun getPokemon(pokeName: String): Flow<Pokemon>  =flow{
        emit(pokemonApiService.getPokemon(pokeName))
    }
}