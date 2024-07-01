package com.seroserod92.pokeapiperron.domain.use_cases

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

class GetPokemonListSaved @Inject constructor(val pokemonDBRepository: PokemonDBRepository) {

    operator fun invoke() : Flow<Resource<List<PokemonUri>>> = flow {
        try {
            emit(Resource.Loading())
            pokemonDBRepository.getAllPokemonUriSaved().collect{ pagination->
                emit(Resource.Success(pagination))
            }
        }catch(e:Exception){
            emit(Resource.Error(e.message?: "An expected Error Ocurred"))
        }
    }.flowOn(Dispatchers.IO)
}