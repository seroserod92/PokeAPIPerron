package com.seroserod92.pokeapiperron.domain.use_cases

import com.seroserod92.pokeapiperron.common.Resource
import com.seroserod92.pokeapiperron.data.model.PokemonPagination
import com.seroserod92.pokeapiperron.data.model.pokemon_data.Pokemon
import com.seroserod92.pokeapiperron.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemon @Inject constructor(val pokemonRepository: PokemonRepository) {

    operator fun invoke(pokeName: String) : Flow<Resource<Pokemon>> = flow {
        try {
            emit(Resource.Loading())
            val pokemon = pokemonRepository.getPokemon(pokeName)
            emit(Resource.Success(pokemon))
        }catch(e:Exception){
            emit(Resource.Error(e.message?: "An expected Error Ocurred"))
        }
    }
}