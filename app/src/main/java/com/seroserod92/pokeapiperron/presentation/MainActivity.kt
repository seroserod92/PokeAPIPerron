package com.seroserod92.pokeapiperron.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.seroserod92.pokeapiperron.presentation.pokemon_detail.PokemonDetailScreen
import com.seroserod92.pokeapiperron.presentation.pokemon_list.PokemonListScreen
import com.seroserod92.pokeapiperron.presentation.pokemon_saved_list.PokemonListSavedScreen
import com.seroserod92.pokeapiperron.presentation.ui.theme.PokeAPIPerronTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            PokeAPIPerronTheme {
                Scaffold { innerPadding ->
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = Screen.PokemonList.route
                    ) {
                        composable(
                            route = Screen.PokemonList.route
                        ) {
                            PokemonListScreen(nav = navController)
                        }
                        composable(
                            route = Screen.DetailedPokemon.route +"/{pokeName}"
                        ) {
                            PokemonDetailScreen()
                        }
                        composable(
                            route = Screen.PokemonSavedList.route
                        ) {
                            PokemonListSavedScreen(nav = navController)
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokeAPIPerronTheme {
        Greeting("Android")
    }
}