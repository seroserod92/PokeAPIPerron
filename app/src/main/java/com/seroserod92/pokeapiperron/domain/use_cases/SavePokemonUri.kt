package com.seroserod92.pokeapiperron.domain.use_cases

import com.seroserod92.pokeapiperron.common.Constants
import com.seroserod92.pokeapiperron.common.Resource
import com.seroserod92.pokeapiperron.data.model.PokemonPagination
import com.seroserod92.pokeapiperron.data.model.PokemonUri
import com.seroserod92.pokeapiperron.domain.db.PokemonDBRepository
import com.seroserod92.pokeapiperron.domain.repository.PokemonRepository
import com.seroserod92.pokeapiperron.domain.repository.PokemonRepositoryFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

class SavePokemonUri @Inject constructor(val pokemonDBRepository: PokemonDBRepository) {

    operator fun invoke(name: String) : Flow<Resource<Boolean>> = flow {
        try {
            emit(Resource.Loading())
            val succ = pokemonDBRepository.savePokemonUri(PokemonUri(name, "${Constants.pokemonApiUrl}pokemon/${name}"))
            emit(Resource.Success(true))
        }catch(e:Exception){
            emit(Resource.Error(e.message?: "An expected Error Ocurred"))
        }
    }.flowOn(Dispatchers.IO)
}