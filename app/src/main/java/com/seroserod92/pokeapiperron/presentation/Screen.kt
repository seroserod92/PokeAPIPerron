package com.seroserod92.pokeapiperron.presentation

sealed class Screen(val route: String) {
    object PokemonList: Screen("pokemon_list_screen")
    object DetailedPokemon: Screen("pokemon_detail_screen")
    object PokemonSavedList: Screen("pokemon_saved_list_screen")
}