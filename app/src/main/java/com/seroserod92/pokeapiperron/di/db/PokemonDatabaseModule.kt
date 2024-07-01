package com.seroserod92.pokeapiperron.di.db

import android.app.Application
import androidx.room.Room
import com.seroserod92.pokeapiperron.data.db.PokemonDAO
import com.seroserod92.pokeapiperron.data.db.PokemonDatabase
import com.seroserod92.pokeapiperron.data.repository.db.PokemonDBRepositoryImpl
import com.seroserod92.pokeapiperron.domain.db.PokemonDBRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PokemonDatabaseModule {

    @Provides
    @Singleton
    fun providesPokemonDatabase(app: Application): PokemonDatabase{
        return Room.databaseBuilder(app,PokemonDatabase::class.java,"pokemonClient").build()
    }

    @Provides
    @Singleton
    fun providesPokemonDao(pokemonDatabase: PokemonDatabase): PokemonDAO{
        return pokemonDatabase.pokemonDAO()
    }

    @Provides
    @Singleton
    fun providesPokemonDBRepository(pokemonDAO: PokemonDAO): PokemonDBRepository{
        return PokemonDBRepositoryImpl(pokemonDAO)
    }
}