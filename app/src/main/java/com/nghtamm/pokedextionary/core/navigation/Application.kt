package com.nghtamm.pokedextionary.core.navigation

import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.nghtamm.pokedextionary.core.theme.PokedextionaryTheme
import com.nghtamm.pokedextionary.features.onboarding.presentation.OnboardingViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun Application() {
    val navController = rememberNavController()
    val onboardingViewModel: OnboardingViewModel = koinViewModel()
    val isCompleted = onboardingViewModel.isCompleted.collectAsState()

    PokedextionaryTheme {
        NavigationHost(
            navController = navController,
            startDestination = if (isCompleted.value == true)
                Screen.Pokedex.route
            else
                Screen.Onboarding.route
        )
    }
}