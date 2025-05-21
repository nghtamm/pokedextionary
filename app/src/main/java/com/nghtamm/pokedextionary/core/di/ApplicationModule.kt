package com.nghtamm.pokedextionary.core.di

import com.nghtamm.pokedextionary.core.local.RealmProvider
import com.nghtamm.pokedextionary.features.onboarding.data.repository.OnboardingRepository
import com.nghtamm.pokedextionary.features.onboarding.presentation.OnboardingViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    // 🛠️ Realm
    single { RealmProvider.initRealm() }

    // 🛠️ Repository
    single { OnboardingRepository(get()) }

    // 🛠️ ViewModel
    viewModel { OnboardingViewModel(get()) }
}