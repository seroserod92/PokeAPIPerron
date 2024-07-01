package com.seroserod92.pokeapiperron.presentation.pokemon_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun PokemonDetailScreen(
    vm: PokemonDetailViewModel = hiltViewModel()
) {
    val state = vm.pokemonDetailState.value
    val cS = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()) {
        state.pokemon?.let {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "${state.pokemon.id}")
                Text(text = state.pokemon.name)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(text = "Height: ${state.pokemon.height}")
                    Text(text = "Weight: ${state.pokemon.weight}")
                }
                Text(text = "Imagen posterior")
                AsyncImage(
                    model = state.pokemon.sprites.front_default,
                    contentDescription = null,
                    modifier = Modifier.size(height = 300.dp, width = 300.dp)
                )
                Text(text = "Imagen trasera")
                AsyncImage(
                    model = state.pokemon.sprites.back_default,
                    contentDescription = null,
                    modifier = Modifier.size(height = 300.dp, width = 300.dp)
                )
                Button(onClick = {
                    cS.launch {
                        vm.savePokemon(vm.pokeName)
                    }
                }) {
                    Text(text = "Guardar pokemon")
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = state.error,
                color = MaterialTheme.colorScheme.error
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }


    }
}
