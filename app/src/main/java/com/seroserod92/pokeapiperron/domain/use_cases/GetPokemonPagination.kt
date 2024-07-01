package com.seroserod92.pokeapiperron.domain.use_cases

import com.seroserod92.pokeapiperron.common.Resource
import com.seroserod92.pokeapiperron.data.model.PokemonPagination
import com.seroserod92.pokeapiperron.domain.repository.PokemonRepository
import com.seroserod92.pokeapiperron.domain.repository.PokemonRepositoryFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

class GetPokemonPagination @Inject constructor(val pokemonRepository: PokemonRepository, val pokemonRepositoryFlow: PokemonRepositoryFlow) {

    operator fun invoke() : Flow<Resource<PokemonPagination>> = flow {
        try {
            emit(Resource.Loading())
            //val pagination = pokemonRepository.getPokemonListPagination(0, 200)
            pokemonRepositoryFlow.getPokemonListPagination(0,200).collect{ pagination->
                emit(Resource.Success(pagination))
            }
        }catch(e:Exception){
            println("holis desde el error")
            emit(Resource.Error(e.message?: "An expected Error Ocurred"))
        }
    }.flowOn(Dispatchers.IO)
}