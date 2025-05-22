package com.nghtamm.pokedextionary.core.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.nghtamm.pokedextionary.features.onboarding.presentation.OnboardingScreen
import com.nghtamm.pokedextionary.features.pokedex.presentation.PokedexScreen

@ExperimentalMaterial3Api
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
            OnboardingScreen(navController = navController)
        }
        composable(Screen.Pokedex.route) {
            PokedexScreen(navController = navController)
        }
    }
}