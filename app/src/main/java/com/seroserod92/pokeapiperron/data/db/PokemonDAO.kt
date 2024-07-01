package com.seroserod92.pokeapiperron.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.seroserod92.pokeapiperron.data.model.PokemonUri
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePokemonUri(pokemonUri: PokemonUri)

    @Query("select * from pokemon_uri")
    fun getAllPokemonUriSaved(): Flow<List<PokemonUri>>
}