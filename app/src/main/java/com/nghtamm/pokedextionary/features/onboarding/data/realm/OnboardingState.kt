package com.nghtamm.pokedextionary.features.onboarding.data.realm

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class OnboardingState : RealmObject {
    @PrimaryKey
    var id: Int = 0
    var completed: Boolean = false
}