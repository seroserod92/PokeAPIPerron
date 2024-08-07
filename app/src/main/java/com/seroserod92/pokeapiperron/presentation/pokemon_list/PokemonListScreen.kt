package com.seroserod92.pokeapiperron.presentation.pokemon_list

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.seroserod92.pokeapiperron.presentation.Screen
import com.seroserod92.pokeapiperron.presentation.pokemon_list.components.PokemonListItem
import kotlinx.coroutines.launch

@Composable
fun PokemonListScreen(
    nav: NavController,
    vm: PokemonListViewModel = hiltViewModel()
) {
    val state = vm.pokemonListState.value
    val coroutineScope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            nav.navigate(Screen.PokemonSavedList.route)
        }) {
            Text(text = "Ir a pokemones guaardados")
        }
        if (state.error.isNullOrBlank() && !state.isLoading)
            Column(modifier = Modifier.fillMaxWidth()) {
                Button(onClick = {
                    coroutineScope.launch {
                        vm.getPokemonList()
                    }
                }) {
                    Text(text = "Obtener Pokemones")
                }
                LazyColumn {
                    items(state.listPokemon) { item ->
                        PokemonListItem(item,
                            onClick = { it ->
                                nav.navigate(Screen.DetailedPokemon.route + "/${it.name}")

                            })
                    }
                }


            }
        if (state.error.isNotBlank()) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
                //verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error
                )
                Button(
                    onClick = {
                        coroutineScope.launch {
                            vm.getPokemonList()
                        }
                    }) {
                    Text(text = "Reintentar")
                }
            }
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }


    }
}