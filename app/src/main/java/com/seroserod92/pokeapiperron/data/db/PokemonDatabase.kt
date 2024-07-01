package com.seroserod92.pokeapiperron.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.seroserod92.pokeapiperron.data.model.PokemonUri

@Database(
    entities = [PokemonUri::class],
    version = 1,
    exportSchema = false
)
abstract class PokemonDatabase: RoomDatabase() {

    abstract fun pokemonDAO(): PokemonDAO
}