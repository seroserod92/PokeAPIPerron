package com.seroserod92.pokeapiperron.presentation.pokemon_saved_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.seroserod92.pokeapiperron.common.Resource
import com.seroserod92.pokeapiperron.domain.use_cases.GetPokemonListSaved
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonListSavedViewModel @Inject constructor(val getPokemonListSaved: GetPokemonListSaved): ViewModel() {

    private val _pokemonListState = mutableStateOf(PokemonListSavedState())
    val pokemonListState: State<PokemonListSavedState> get() = _pokemonListState

    suspend fun getPokemonListSaved() {
        getPokemonListSaved.invoke().collect {
            when (it) {
                is Resource.Error -> {
                    _pokemonListState.value =
                        PokemonListSavedState(error = it.msg ?: "An Unexpected Error")
                }

                is Resource.Loading -> {
                    _pokemonListState.value = PokemonListSavedState(isLoading = true)
                }

                is Resource.Success -> {
                    _pokemonListState.value =
                        PokemonListSavedState(listPokemon = it.data ?: emptyList())
                }
            }
        }
    }
}