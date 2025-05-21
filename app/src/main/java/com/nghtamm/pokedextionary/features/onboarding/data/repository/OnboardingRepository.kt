package com.nghtamm.pokedextionary.features.onboarding.data.repository

import com.nghtamm.pokedextionary.features.onboarding.data.realm.OnboardingState
import io.realm.kotlin.Realm

class OnboardingRepository(
    private val realm: Realm
) {
    fun isCompleted(): Boolean {
        val state = realm.query<OnboardingState>(OnboardingState::class, "id == 0")
            .first()
            .find()
        return state?.completed == true
    }

    suspend fun complete() {
        realm.write {
            val state = query<OnboardingState>(OnboardingState::class, "id == 0")
                .first()
                .find()
            if (state != null) {
                state.completed = true
            } else {
                copyToRealm(OnboardingState().apply {
                    id = 0
                    completed = true
                })
            }
        }
    }
}