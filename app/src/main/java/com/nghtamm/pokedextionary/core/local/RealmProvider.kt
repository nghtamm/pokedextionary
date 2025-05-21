package com.nghtamm.pokedextionary.core.local

import com.nghtamm.pokedextionary.features.onboarding.data.realm.OnboardingState
import io.realm.kotlin.*

object RealmProvider {
    fun initRealm(): Realm {
        val config = RealmConfiguration.create(
            schema = setOf(
                OnboardingState::class
            )
        )
        return Realm.open(config)
    }
}