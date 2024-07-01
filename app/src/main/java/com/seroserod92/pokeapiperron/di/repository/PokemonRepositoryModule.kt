package com.seroserod92.pokeapiperron.di.repository

import com.seroserod92.pokeapiperron.data.api.PokemonApiService
import com.seroserod92.pokeapiperron.data.repository.networking.PokemonRepositoryFlowImpl
import com.seroserod92.pokeapiperron.data.repository.networking.PokemonRepositoryImpl
import com.seroserod92.pokeapiperron.domain.repository.PokemonRepository
import com.seroserod92.pokeapiperron.domain.repository.PokemonRepositoryFlow
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PokemonRepositoryModule {
    @Provides
    @Singleton
    fun providesPokemonRepository(pokemonApiService: PokemonApiService): PokemonRepository {
        return PokemonRepositoryImpl(pokemonApiService)
    }

    @Provides
    @Singleton
    fun providesPokemonFlowRepository(pokemonApiService: PokemonApiService): PokemonRepositoryFlow {
        return PokemonRepositoryFlowImpl(pokemonApiService)
    }
}