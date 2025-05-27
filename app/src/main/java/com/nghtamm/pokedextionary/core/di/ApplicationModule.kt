package com.nghtamm.pokedextionary.core.di

import com.nghtamm.pokedextionary.core.local.RealmProvider
import com.nghtamm.pokedextionary.core.network.*
import com.nghtamm.pokedextionary.features.onboarding.data.repository.OnboardingRepository
import com.nghtamm.pokedextionary.features.onboarding.presentation.OnboardingViewModel
import com.nghtamm.pokedextionary.features.pokedex.data.repository.PokemonRepository
import com.nghtamm.pokedextionary.features.pokedex.presentation.PokedexViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    // 🛠️ Realm
    single { RealmProvider.initRealm() }

    // 🛠️ Network
    single<NetworkService> { RetrofitClient.instance }

    // 🛠️ Repository
    single { OnboardingRepository(get()) }
    single { PokemonRepository(get()) }

    // 🛠️ ViewModel
    viewModel { OnboardingViewModel(get()) }
    viewModel { PokedexViewModel(get()) }
}