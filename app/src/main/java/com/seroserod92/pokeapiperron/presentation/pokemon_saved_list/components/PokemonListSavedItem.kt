package com.seroserod92.pokeapiperron.presentation.pokemon_saved_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seroserod92.pokeapiperron.data.model.PokemonUri

@Composable
fun PokemonListSavedItem(pokemonUri: PokemonUri, onClick: (PokemonUri)-> Unit){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable {
                onClick(pokemonUri)
            }) {
        Column {
            Text(text = pokemonUri.name, color = Color.Green, fontSize = 20.sp)
            Text(text = pokemonUri.url, color = Color.LightGray)
        }
    }
}