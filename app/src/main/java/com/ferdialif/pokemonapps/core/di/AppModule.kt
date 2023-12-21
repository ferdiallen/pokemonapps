package com.ferdialif.pokemonapps.core.di

import androidx.room.Room
import com.ferdialif.pokemonapps.data.api.GetDetailPokemon
import com.ferdialif.pokemonapps.data.api.GetPokemon
import com.ferdialif.pokemonapps.data.local.dao.PokedexDao
import com.ferdialif.pokemonapps.data.local.database.PokedexDatabase
import com.ferdialif.pokemonapps.domain.model.GeneralModelPokemonData
import com.ferdialif.pokemonapps.domain.repository.GetPokemonDetailImpl
import com.ferdialif.pokemonapps.domain.repository.GetPokemonImpl
import com.ferdialif.pokemonapps.domain.use_case.GetPokemonDetailUseCase
import com.ferdialif.pokemonapps.domain.use_case.GetPokemonUseCase
import com.ferdialif.pokemonapps.presentation.home.HomeViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single {
        HttpClient(Android) {
            install(ContentNegotiation) {
                json()
            }
        }
    }

    single {
        Room.databaseBuilder(
            androidApplication(),
            PokedexDatabase::class.java, "Pokedex"
        ).build()
    }

    single<GetPokemon> {
        GetPokemonImpl(get())
    }
    single {
        GetPokemonUseCase(get())
    }
    single<GetDetailPokemon> {
        GetPokemonDetailImpl(get())
    }
    single {
        GetPokemonDetailUseCase(get())
    }

    single<PokedexDao> {
        get<PokedexDatabase>().dao()
    }
    viewModel {
        HomeViewModel(get(), get(), get())
    }
}