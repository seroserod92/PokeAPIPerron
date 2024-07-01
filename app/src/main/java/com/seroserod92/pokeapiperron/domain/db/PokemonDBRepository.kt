package com.seroserod92.pokeapiperron.domain.db

import com.seroserod92.pokeapiperron.data.model.PokemonUri
import kotlinx.coroutines.flow.Flow

interface PokemonDBRepository {
    suspend fun savePokemonUri(pokemonUri: PokemonUri)

    fun getAllPokemonUriSaved(): Flow<List<PokemonUri>>
}