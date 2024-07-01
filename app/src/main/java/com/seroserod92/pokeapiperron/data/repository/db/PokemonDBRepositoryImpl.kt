package com.seroserod92.pokeapiperron.data.repository.db

import com.seroserod92.pokeapiperron.data.db.PokemonDAO
import com.seroserod92.pokeapiperron.data.model.PokemonUri
import com.seroserod92.pokeapiperron.domain.db.PokemonDBRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PokemonDBRepositoryImpl(val pokemonDAO: PokemonDAO): PokemonDBRepository {
    override suspend fun savePokemonUri(pokemonUri: PokemonUri) {
        CoroutineScope(Dispatchers.IO).launch{
            pokemonDAO.savePokemonUri(pokemonUri)
        }
    }

    override fun getAllPokemonUriSaved(): Flow<List<PokemonUri>> {
        return pokemonDAO.getAllPokemonUriSaved()
    }
}