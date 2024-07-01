package com.seroserod92.pokeapiperron.presentation.pokemon_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.seroserod92.pokeapiperron.common.Resource
import com.seroserod92.pokeapiperron.domain.use_cases.GetPokemonPagination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(val getPokemonPagination: GetPokemonPagination): ViewModel() {

    private val _pokemonListState = mutableStateOf(PokemonListState())
    val pokemonListState: State<PokemonListState> get() = _pokemonListState

    suspend fun getPokemonList() {
        getPokemonPagination().collect {
            when (it) {
                is Resource.Error -> {
                    _pokemonListState.value =
                        PokemonListState(error = it.msg ?: "An Unexpected Error")
                }

                is Resource.Loading -> {
                    _pokemonListState.value = PokemonListState(isLoading = true)
                }

                is Resource.Success -> {
                    _pokemonListState.value =
                        PokemonListState(listPokemon = it.data?.results ?: emptyList())
                }
            }
        }
    }
}