package com.seroserod92.pokeapiperron.di.networking

import com.seroserod92.pokeapiperron.common.Constants
import com.seroserod92.pokeapiperron.data.api.PokemonApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun providesPokemonApiService(): PokemonApiService{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.pokemonApiUrl)
            .build()
            .create(PokemonApiService::class.java)
    }
}