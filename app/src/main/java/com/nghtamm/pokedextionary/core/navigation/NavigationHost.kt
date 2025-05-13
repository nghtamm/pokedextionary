package com.nghtamm.pokedextionary.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nghtamm.pokedextionary.features.onboarding.presentation.OnboardingScreen
import com.nghtamm.pokedextionary.features.pokedex.PokedexScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                onNext = {
                    navController.navigate(Screen.Pokedex.route)
                },
            )
        }
        composable(Screen.Pokedex.route) {
            PokedexScreen()
        }
    }
}