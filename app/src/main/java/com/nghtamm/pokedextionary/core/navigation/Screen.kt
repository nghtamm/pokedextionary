package com.nghtamm.pokedextionary.core.navigation

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboarding")
    object Pokedex : Screen("pokedex")
}