package com.seroserod92.pokeapiperron.presentation.pokemon_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seroserod92.pokeapiperron.common.Resource
import com.seroserod92.pokeapiperron.domain.use_cases.GetPokemon
import com.seroserod92.pokeapiperron.domain.use_cases.SavePokemonUri
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    val getDetailPokemon: GetPokemon,
    val savePokemonUri: SavePokemonUri,
    val savedState: SavedStateHandle
) : ViewModel() {
    var pokeName: String = ""

    private val _pokemonDetailState = mutableStateOf(PokemonListState())
    val pokemonDetailState: State<PokemonListState> get() = _pokemonDetailState


    init {
        viewModelScope.launch {
            pokeName = savedState.get<String>("pokeName") ?: ""
            getPokemon(pokeName)
        }
    }

    suspend fun getPokemon(pokemonName: String) {
        getDetailPokemon(pokemonName).collect {
            when (it) {

                is Resource.Error -> {
                    _pokemonDetailState.value =
                        PokemonListState(error = it.msg ?: "An Unexpected Error")
                }

                is Resource.Loading -> {
                    _pokemonDetailState.value = PokemonListState(isLoading = true, pokemon = pokemonDetailState.value.pokemon)
                }

                is Resource.Success -> {
                    _pokemonDetailState.value =
                        PokemonListState(pokemon = it.data)
                }
            }
        }
    }

    suspend fun savePokemon(pokemonName: String) {
        savePokemonUri(pokemonName).collect {

            Log.i("POKEMONES: ", it.toString())
            when (it) {
                is Resource.Error -> {
                    _pokemonDetailState.value =
                        PokemonListState(error = it.msg?.let {
                            "Guarda: ${it}"
                        } ?: "An Unexpected Error")
                }

                is Resource.Loading -> {
                    _pokemonDetailState.value = PokemonListState(isLoading = true)
                }

                is Resource.Success -> {
                    _pokemonDetailState.value =

                        PokemonListState(isSaved = it.data ?: false)
                }
            }
        }
    }
}